package com.gmc_team.e_commerse_platform.models.promotion_types;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@SuperBuilder
@Table(name = "ByeN_GetNFree")
public class ByeN_GetNFree extends Promotion {
    @Column
    private Integer productshouldbye;
    @Column
    private Integer freeproductwillget;

    @ElementCollection
    private List<Long> targetproduct;

//    applic to the same product ,like bye 2 t-shirt get the third for free
}
