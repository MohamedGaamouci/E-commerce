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
@Table(name = "descriptions")
public class Descriptions extends abstract_class{
    @Column
    private String title;
    @Column(length = 1024 )
    private String description;

    @Column
    private Long onlineshop;

}
