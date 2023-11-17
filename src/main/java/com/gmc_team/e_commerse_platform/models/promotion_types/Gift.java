package com.gmc_team.e_commerse_platform.models.promotion_types;

import com.gmc_team.e_commerse_platform.models.Images;
import com.gmc_team.e_commerse_platform.models.abstract_class;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Gift_with_purchase")
@SuperBuilder
public class Gift extends abstract_class {
    @Column
    private String giftname;
    @Column
    private String description;

    @ManyToMany
    private List<num_product_condition> products;
    @ManyToMany
    private List<Images> giftimages;

    @Column
    private Long onlineshop;

    public Gift() {
        super();
    }
}

