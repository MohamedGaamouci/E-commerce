package com.gmc_team.e_commerse_platform.models.promotion_types;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Loyalty_programs")
@SuperBuilder
public class Loyalty_programs extends Promotion {
//    This promotion rewards customers for their loyalty by offering them discounts, points, or other benefits.
    @Column
    private Float pointsPerDollarSpent; // 1 dollar = ? point;
    @Column
    private Integer redemptionRate; // the number of point that will give the reward
    @OneToMany
    private List<Gift> reward;
    @Column
    private Long promotion;//contain the promotion id ,to make it dynamic container
}
