package com.selenium.addressapp.controller;

import com.selenium.addressapp.addressresponse.AddressResponse;
import com.selenium.addressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") Integer empId){
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(empId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

}
