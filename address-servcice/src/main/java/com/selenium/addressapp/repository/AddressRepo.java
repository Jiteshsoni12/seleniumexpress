package com.selenium.addressapp.repository;

import com.selenium.addressapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {

    //address based on a employee id

    @Query(value="Select ea.id, ea.lane1, ea.lane2, ea.city, ea.state, ea.zip from seleniumexpress.address ea join seleniumexpress.employee e on e.id = ea.employeeid where ea.employeeid=:employeeid",nativeQuery = true)
    Address findAddressByEmpolyeeId(@Param("employeeid") Integer employeeid);
}
