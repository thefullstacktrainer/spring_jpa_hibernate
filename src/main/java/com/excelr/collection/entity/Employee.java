// Employee.java
package com.excelr.collection.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {

    private Long id;
    private String name;
    private Map<String, PhoneNumber> phoneNumbers = new HashMap<>();

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public void addPhoneNumber(String type, PhoneNumber phoneNumber) {
        phoneNumbers.put(type, phoneNumber);
        phoneNumber.setEmployee(this);
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    // Equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}

