package org.example.streams;

import java.util.List;

public class EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findByID(Integer eid) {
        for (Employee e : employees) {
            if (e.getID().equals(eid)) {
                return e;
            }
        }
        return null;
    }
}
