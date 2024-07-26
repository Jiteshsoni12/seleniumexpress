package com.selenium.addressapp.service;

import com.selenium.addressapp.addressresponse.AddressResponse;
import com.selenium.addressapp.entity.Address;
import com.selenium.addressapp.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(Integer employeeid){
        Address address = addressRepo.findAddressByEmpolyeeId(employeeid);
        /*AddressResponse addressByEmployeeId = new AddressResponse();
        addressByEmployeeId.setId(address.getId());
        addressByEmployeeId.setLane1(address.getLane1());
        addressByEmployeeId.setLane2(address.getLane2());
        addressByEmployeeId.setCity(address.getCity());
        addressByEmployeeId.setState(address.getState());
        addressByEmployeeId.setZip(address.getZip());*/
        AddressResponse addressByEmployeeId = modelMapper.map(address, AddressResponse.class);

        return addressByEmployeeId;
    }
}
