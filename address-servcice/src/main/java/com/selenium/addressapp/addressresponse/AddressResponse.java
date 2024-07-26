package com.selenium.addressapp.addressresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

    private Integer id;
    private String lane1;
    private String lane2;
    private String city;
    private String state;
    private String zip;
}
