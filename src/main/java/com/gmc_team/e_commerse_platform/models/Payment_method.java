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
@Table(name = "Customer_payment_mehtod")
public class Payment_method extends abstract_class {

    @Column
    private String provider;

    @Column
    @Enumerated(EnumType.STRING)
    private Payment_type paymenttype;

    @Column
    private Boolean isdefault;


}
