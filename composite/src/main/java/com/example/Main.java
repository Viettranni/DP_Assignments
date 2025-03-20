package com.example;

public class Main {
    public static void main(String[] args) {
        // Creating the Organization
        Organization autoMobile = new Organization();

        // Creating the Departments
        Department hr = new Department("HR");
        Department billing = new Department("Billing");
        Department marketing = new Department("Marketing");
        Department marketingFeature = new Department("Marketing Feature");
        Department marketingTools = new Department("Marketing Tools");

        // Creating the Employees
        Employee viet = new Employee("Viet", 2100.0);
        Employee saed = new Employee("Saed", 2500.0);
        Employee ivan = new Employee("Ivan", 2300.0);
        Employee pavel = new Employee("Pavel", 5000.0);

        // Adding the Departments into Organizaton
        autoMobile.addDepartment(hr);
        autoMobile.addDepartment(billing);
        autoMobile.addDepartment(marketing);

        // Adding Departments within a Department
        marketing.addDepartment(marketingFeature);
        marketingFeature.addDepartment(marketingTools);

        // Adding the employees into Departments
        hr.addEmployee(pavel);
        hr.addEmployee(ivan);
        marketingFeature.addEmployee(saed);
        billing.addEmployee(viet);
        marketingTools.addEmployee(pavel);

        // Before removing the Department
        double totalSalaryBefore = autoMobile.getTotalSalary();
        System.out.println("The total salary is before removing the HR Department: " + totalSalaryBefore);

        // Removing the Department and checking the total salary
        marketing.deleteDepartment(marketingFeature);
        double totalSalarAfter = autoMobile.getTotalSalary();
        System.out.println("The total salary is after removing the Marketing Feature Department:" + totalSalarAfter);

        // Output of the Organization XML
        System.out.println("\nOrganizational Structure in XML:");
        autoMobile.printXmlStructure();
    }
}
