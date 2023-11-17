package com.gmc_team.e_commerse_platform.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Variation")
public class Variation extends abstract_class{

    @Column
    private String name;

    @Column
    private Long onlineshop;

    @OneToMany(cascade = {CascadeType.REMOVE})
    @JsonManagedReference
    private List<Variation_option> variationoption;


}
