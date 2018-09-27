package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty
    private String name;
    @JsonProperty
    private int age;
    @JsonProperty
    private Address address;

    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
