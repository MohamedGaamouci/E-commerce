package com.gmc_team.e_commerse_platform.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Variation_option")
public class Variation_option extends abstract_class {

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Variation variation;
    @Column
    private String optionvalue;

    @Column
    private Long onlineshop;


}
