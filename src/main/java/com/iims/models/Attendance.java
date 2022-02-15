package com.iims.models;

public class Attendance {

    private int empId;
    private String empName, date;
    private Boolean isPresent;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", date='" + date + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }

    public Attendance() {}

    public Attendance(String empName, String date, Boolean isPresent) {
        this.empName = empName;
        this.date = date;
        this.isPresent = isPresent;
    }

    public Attendance(int empId, String empName, String date, Boolean isPresent) {
        this.empId = empId;
        this.empName = empName;
        this.date = date;
        this.isPresent = isPresent;
    }
}
