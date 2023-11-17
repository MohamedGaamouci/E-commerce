package com.gmc_team.e_commerse_platform.models;


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
@Table(name = "online_shop_review")
public class Online_shop_review extends abstract_class{

    @Column
    private Integer storerating;
    @Column
    private String comment;
    @Column
    private Long customersid;

    @Column
    private Long onlineshop;
}
