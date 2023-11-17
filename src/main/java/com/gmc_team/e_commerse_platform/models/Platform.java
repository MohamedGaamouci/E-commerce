package com.gmc_team.e_commerse_platform.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "root_platform")
public class Platform extends abstract_class{
    @OneToOne
    private Administrators owner;
    @Column
    private String brandname;
    @OneToMany
    private List<Descriptions> Description;

    @OneToMany
    private List<Administrators> administratorsList;
}
