package optional;

import optional.domain.Address;
import optional.domain.Customer;

import java.util.Optional;

public class OptionalMain {


    public static void main(String[] args) {
        Address address = new Address("5", "TW184EZ");
        Customer customer = new Customer(address);

        final String zipCode = Optional.of(customer)
            .map(Customer::getAddress)
            .map(Address::getZipCode)
            .orElse("empty");

        System.out.println(zipCode);

        }


}
