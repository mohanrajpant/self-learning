package com.builder;

public class Person {
    private final String salutation;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String suffix;
    private final Address address;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomeOwner;

    public Person(String salutation,
                  String firstName,
                  String middleName,
                  String lastName,
                  String suffix,
                  Address address,
                  boolean isFemale,
                  boolean isEmployed,
                  boolean isHomeOwner) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.address = address;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomeOwner = isHomeOwner;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }

    public static class Address {

        private final String city;
        private final String state;
        private final String pin;

        public Address(String city, String state, String pin) {
            this.city = city;
            this.state = state;
            this.pin = pin;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getPin() {
            return pin;
        }
    }
}
