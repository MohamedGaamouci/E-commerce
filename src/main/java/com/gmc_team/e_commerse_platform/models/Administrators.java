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
@Table(name = "Administrators")
public class Administrators extends abstract_class{
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column(name = "username")
    private String username;
    @Column
    private String email;
    @OneToOne
    private Address address;

    @Column
    private Gender gender;
    @Column
    private Instant birth_day;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Roles> roles;
}
