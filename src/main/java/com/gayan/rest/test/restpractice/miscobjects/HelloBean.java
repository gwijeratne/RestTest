package com.gayan.rest.test.restpractice.miscobjects;

import java.util.List;

public class HelloBean {

    private String name;
    private int age;
    private List<String> childNames;

    public HelloBean(String name, int age, List<String> childNames) {
        this.name = name;
        this.age = age;
        this.childNames = childNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }
}
