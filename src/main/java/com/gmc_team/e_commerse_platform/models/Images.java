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
@Table(name = "Images")
public class Images extends abstract_class{
    @Column
    private String title;

    @Column
    private String URL;

    @Column
    private Long onlineshop;
}
