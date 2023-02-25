package org.example.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class StreamsAPITest {
    Employee employee1;
    Employee employee2;
    Employee employee3;
    List<Employee> employeeList;
    EmployeeRepository employeeRepository;
    Employee[] arrayOfEmps;
    @BeforeEach
    void init() {
        employee1 = new Employee(1, "Jeff Bezos", 100000.0);
        employee2 = new Employee(2, "Bill Gates", 200000.0);
        employee3 = new Employee(3, "Mark Zucks", 300000.0);
        employeeList = List.of(employee1, employee2, employee3);

        employeeRepository = new EmployeeRepository(List.of(employee1, employee2, employee3));
        arrayOfEmps = new Employee[]{employee1, employee2, employee3};
    }
    @Test
    void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
        employeeList.forEach(e -> e.salaryIncrement(10.0));
        /* It calls the salaryIncrement() on each element in the employeeList. */

        assertThat(employeeList, contains(
                hasProperty("salary", equalTo(110000.0)),
                hasProperty("salary", equalTo(220000.0)),
                hasProperty("salary", equalTo(330000.0))
        ));
    }
    @Test
    void whenMapIdToEmployees_thenGetEmployeeStream() {
        // this converts the stream of Integers into the stream of Employees.
        Integer[] employeeIDs = { 1, 2, 3 };
        List<Employee> employees = Stream.of(employeeIDs)
                .map(employeeRepository::findByID)
                .toList();
        assertEquals(employees.size(), employeeIDs.length);
    }
    @Test
    void whenFilterEmployees_thenGetFilteredStream() {
        // this first filters out null references for invalid employee ids
        // then again apply a filter to only keep employees with salaries over
        // a certain threshold.
        Integer[] empIds = { 1, 2, 3, 4 };
        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findByID)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 200000)
                .toList();

        assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
    }
    @Test
    void whenFindFirst_thenGetFirstEmployeeInStream() {
        Integer[] empIds = { 1, 2, 3, 4 };

        Employee employee = Stream.of(empIds)
                .map(employeeRepository::findByID)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);

        assertEquals(employee.getSalary(), 200000.0);
    }
    @Test
    void whenStreamToArray_thenGetArray() {
        // we can get an array from a stream using the toArray() method.
        // Employee[]::new creates an empty array of Employee - which
        // is then filled with elements from the stream.

        Employee[] employees = employeeList.toArray(Employee[]::new);

        assertThat(employeeList.toArray(), equalTo(employees));
    }
    @Test
    void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .toList();
        namesFlatStream.forEach(System.out::println);
        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }
    @Test
    void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
        // the first peek is used to increment the salaries
        // the second peek is used to print the employees.
        // collect is used as the terminal operation.

        employeeList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

        assertThat(employeeList, contains(
                hasProperty("salary", equalTo(110000.0)),
                hasProperty("salary", equalTo(220000.0)),
                hasProperty("salary", equalTo(330000.0))
        ));
    }
    @Test
    void whenStreamCount_thenGetElementCount() {
        // counts the employee whose salary is greater than a given base.
        Long empCount = employeeList.stream()
                .filter(e -> e.getSalary() > 200000)
                .count();
        assertEquals(empCount, 1);
    }
    @Test
    void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .toList();
    }
    @Test
    void whenFindMin_thenGetMinElementFromStream() {
        Employee firstEmp = employeeList.stream()
                .min(Comparator.comparing(Employee::getID))
                .orElseThrow(NoSuchElementException::new);

        assertEquals(firstEmp.getID(), 1);
    }
    @Test
    void whenFindMax_thenGetMaxElementFromStream() {
        Employee maxSalEmp = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        assertEquals(maxSalEmp.getSalary(), 300000.0);
    }
    @Test
    void whenAppleMatch_thenReturnBoolean() {
        List<Integer> integers = Arrays.asList(2, 4, 5, 6, 8);
        boolean allEven = integers.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = integers.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfFour = integers.stream().noneMatch(i -> i % 4 == 0);

        assertFalse(allEven);
        assertTrue(oneEven);
        assertFalse(noneMultipleOfFour);
    }
}