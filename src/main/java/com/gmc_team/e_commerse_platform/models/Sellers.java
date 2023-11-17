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
@Table(name = "sellers")
public class Sellers extends abstract_class{
    @Column
    private String firstname;
    @Column
    private String secondname;
    @Column
    private String username;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Address address;
    @Column
    private Instant birthday;
    @Column
    private String email;
    @Column
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Roles> roles;

    @Column
    private Long onlineshop;
    @Column
    private SellerStatus status;
}
