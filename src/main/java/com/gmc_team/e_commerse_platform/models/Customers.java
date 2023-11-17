package com.gmc_team.e_commerse_platform.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Customers")
public class Customers extends abstract_class{

    @Column
    private String name;
    @Column
    private String secondname;
    @Column
    private String username;
    @Column
    private String email;
    @OneToMany(cascade = {CascadeType.REMOVE})
    private List<Address> address;

    @Column
    private Gender gender;
    @Column
    private Instant birthday;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Roles> roles;


    @ManyToMany
    private List<Online_shop> registerstores;
    @OneToMany
    private List<Product> favoriteproduct;

//    @ElementCollection
//    private HashMap<Long ,Integer> loyaltypoints;// long = store id ,integer = point should make

//    @OneToMany
//    private HashMap<Long , Referral_programs> referralprogram; //store id = long ,refferal program
}
