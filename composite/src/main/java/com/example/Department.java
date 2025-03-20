package com.example;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Department {
    private String name;
    private double totalSalary;

    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();


    // Constructor
    public Department(String name) {
        this.name = name;
    }

    // Gets the Department name
    public String getName() {
        return name;
    }

    // Gets the Departments total salary
    public double getSalary() {
        return totalSalary;
    }

    // Calculating the total salary of this Department and returning it
    public double getTotalSalary() {
        // Resetting the current salary
        totalSalary = 0;

        // Looping through the current Departments employees
        for (Employee employee:employees) {
            totalSalary += employee.getSalary();
        }

        // Looping through the Sub Departments employees
        for (Department department:departments) {
            totalSalary += department.getTotalSalary();
        }
        
        return totalSalary;
    }

    // XML
    public Element toXmlElement(Document doc) {
        Element departmentElement = doc.createElement("department");
        departmentElement.setAttribute("name", name);

        for (Employee employee : employees) {
            departmentElement.appendChild(employee.toXmlElement(doc));
        }

        for (Department department : departments) {
            departmentElement.appendChild(department.toXmlElement(doc));
        }

        return departmentElement;
    }

    public void deleteDepartment(Department department) {
        departments.remove(department);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}
