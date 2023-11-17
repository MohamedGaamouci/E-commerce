package com.gmc_team.e_commerse_platform.models.promotion_types;

import com.gmc_team.e_commerse_platform.models.abstract_class;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "num_product_condition")
public class num_product_condition extends abstract_class {
    @Column
    private Long productitemid;
    @Column
    private Integer qte;
}
