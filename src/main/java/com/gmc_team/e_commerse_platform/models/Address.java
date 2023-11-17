package com.gmc_team.e_commerse_platform.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Address")
public class Address extends abstract_class{

    @Column
    private String country;
    @Column
    private String add1;
    @Column
    private String add2;
    @Column
    private Integer postal_code;
    @Column
    private String state;
    @Column
    private String city;
    @Column
    private Long phone;

    @Column
    private Long onlineshop;
    @Column
    private Long CustomerId;
}
