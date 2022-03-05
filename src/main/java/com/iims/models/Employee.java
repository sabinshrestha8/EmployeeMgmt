package com.iims.models;

public class Employee {
    private int id;
    private String name;
    private long contact;
    private String address;
    private int age;
    private String joinDate;
    private int departmentId;
    private String departmentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", joinDate='" + joinDate + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

    public Employee() {
    }

    public Employee(int id, String name, long contact, String address, int age, String joinDate, int departmentId) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.age = age;
        this.joinDate = joinDate;
        this.departmentId = departmentId;
    }

    public Employee(String name, long contact, String address, int age, String joinDate, int departmentId) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.age = age;
        this.joinDate = joinDate;
        this.departmentId = departmentId;
    }

    public Employee(String name, long contact, String address, int age, int departmentId) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.age = age;
        this.departmentId = departmentId;
    }
}
