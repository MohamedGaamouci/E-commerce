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
@Table(name = "Category")
public class Category extends abstract_class{
    @Column
    private String name;
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category parentcategory;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Category> childcats;

    @Column
    private Long onlineshop;
}
