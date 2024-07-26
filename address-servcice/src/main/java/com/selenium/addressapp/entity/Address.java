package com.selenium.addressapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    //id, lane 1, lane 2, state, city, zip, employeeid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="lane1")
    private String lane1;
    @Column(name="lane2")
    private String lane2;

    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;

    @Column(name="zip")
    private String zip;

   /* private Integer employeeid;*/
}
