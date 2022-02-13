package com.iims.models;

public class Attendance {

    private int emp_id;
    private String name, date;
    private Boolean isPresent;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }

    public Attendance() {}

    public Attendance(String name, String date, Boolean isPresent) {
        this.name = name;
        this.date = date;
        this.isPresent = isPresent;
    }

    public Attendance(int emp_id, String name, String date, Boolean isPresent) {
        this.emp_id = emp_id;
        this.name = name;
        this.date = date;
        this.isPresent = isPresent;
    }
}
