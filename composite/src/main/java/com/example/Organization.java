package com.example;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Organization {
    List<Department> departments = new ArrayList<>();

    // Adding a Department
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println(department.getName() + " added succesfully!");
    }

    // Removing the Department
    public void removeDepartment(Department department) {
        departments.remove(department);
        System.out.println(department.getName() + " removed succesfully!");
    }

    // Calculating the total salary from all of the sub Departments
    public double getTotalSalary(){
        double totalSalary = 0;
        for (Department department:departments) {
            totalSalary += department.getTotalSalary();
        }

        return totalSalary;
    }

    // XML
    public void printXmlStructure() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("AutoMobile");
            doc.appendChild(rootElement);

            for (Department department : departments) {
                rootElement.appendChild(department.toXmlElement(doc));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
