package com.gmc_team.e_commerse_platform.models.promotion_types;

import com.gmc_team.e_commerse_platform.models.abstract_class;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TieredPromotionItem")
public class TieredPromotionItem extends abstract_class {
    @Column
    private BigDecimal price;
    @Column
    private Long promotionid;
}
