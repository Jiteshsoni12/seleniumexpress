package com.seleniumexpress.employeeapp.service;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repository.EmployeeRepo;
import com.seleniumexpress.employeeapp.response.AddressResponse;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Value("${addresservice.base.url}")
    private String addressBaseUrl;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    private RestTemplate restTemplate;

    public EmployeeService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    //here we can't return employee object directly it is bad practise
    //so we converted employee object to employeeresponse through modelmapper
    public EmployeeResponse getEmployeeById(Integer id){

        AddressResponse addressResponse;

        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        addressResponse = restTemplate.getForObject(addressBaseUrl + "/address/{employeeId}", AddressResponse.class, id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }



}
