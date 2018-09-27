package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class Address {

    @JsonProperty
    private String streetname;
    @JsonProperty
    private String postcode;

    public Address(String streetname, String postcode) {
        this.streetname = streetname;
        this.postcode = postcode;
    }
}
