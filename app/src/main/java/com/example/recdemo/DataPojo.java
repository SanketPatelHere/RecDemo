package com.example.recdemo;

public class DataPojo {
    int id;
    String name, dept, salary;
    boolean isHeader, isFooter;

    public DataPojo(int id, String name, String dept, String salary, boolean isHeader, boolean isFooter) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.isHeader = isHeader;
        this.isFooter = isFooter;
    }


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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
