package com.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Employee {
    protected String name;
    protected Double salary;

    // Constructor
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // XML
    public Element toXmlElement(Document doc) {
        Element employeeElement = doc.createElement("employee");
        employeeElement.setAttribute("name", name);
        employeeElement.setAttribute("salary", String.valueOf(salary));
        return employeeElement;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }


    
}
