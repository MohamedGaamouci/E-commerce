package com.gmc_team.e_commerse_platform.models.promotion_types;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TieredPromotion")
public class TieredPromotion extends Promotion{
    private List<TieredPromotionItem> tiers;
    //condition price -- the reward (promotion || gift)


}
