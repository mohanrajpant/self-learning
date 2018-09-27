package com.builder;

public class BuilderMain {

    public static void main(String[] args) {
        PersonBuilder.get()
            .with($ -> {
                $.salutation = "Mr";
                $.firstName = "Mohanraj";
                $.lastName = "Pant";
                $.isFemale = false;
                $.isEmployed = true;
            })
            .with($ -> $.isHomewOwner = false)
            .with($ -> $.address = PersonBuilder.AddressBuilder.get()
                .with($_address -> {
                    $_address.city = "Mumbai";
                    $_address.state = "MH";
                    $_address.pin = "400705";
                }).createAddress())
            .createPerson();


        // using Generic Builder

    }
}
