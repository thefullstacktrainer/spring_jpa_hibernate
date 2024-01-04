package com.excelr.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.excelr.collection.entity.Employee;
import com.excelr.collection.entity.PhoneNumber;

public class StoreEmployeeData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        // Create an employee
        Employee employee = new Employee();
        employee.setName("Advaith Shet");

        // Create phone numbers
        PhoneNumber phoneNumber1 = new PhoneNumber("0802919333", "Home");
        PhoneNumber phoneNumber2 = new PhoneNumber("9876543210", "Work");

        // Add phone numbers to the employee
        employee.addPhoneNumber("home", phoneNumber1);
        employee.addPhoneNumber("work", phoneNumber2);

        // Save the employee (and associated phone numbers) to the database
        session.persist(employee);

        t.commit();

        // Fetch and print employee data
        Employee fetchedEmployee = session.get(Employee.class, employee.getId());
        System.out.println("Employee ID: " + fetchedEmployee.getId());
        System.out.println("Employee Name: " + fetchedEmployee.getName());

        // Accessing phone numbers associated with the employee
        System.out.println("Phone Numbers:");
        fetchedEmployee.getPhoneNumbers().forEach((type, phoneNumber) -> {
            System.out.println("Type: " + type + ", Number: " + phoneNumber.getNumber());
        });

        session.close();
        System.out.println("Employee Data stored successfully");
    }
}
