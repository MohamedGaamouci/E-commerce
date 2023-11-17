package com.gmc_team.e_commerse_platform.models;

import com.gmc_team.e_commerse_platform.models.promotion_types.Promotion_Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Promotion_detail")
public class Promotion_detail extends abstract_class{
    @Column
    private Promotion_Type type;
    @Column
    private Long promotion;

}
