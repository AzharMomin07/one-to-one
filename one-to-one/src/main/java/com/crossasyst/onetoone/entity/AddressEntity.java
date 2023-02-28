package com.crossasyst.onetoone.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")

public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "addressId")
    private PatientEntity patient;

}
