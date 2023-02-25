package org.example.streams;

public class Employee {
    private Integer ID;
    private String name;
    private Double salary;

    public Employee(Integer ID, String name, Double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void salaryIncrement(Double amount) {
        salary += amount / 100 * salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
