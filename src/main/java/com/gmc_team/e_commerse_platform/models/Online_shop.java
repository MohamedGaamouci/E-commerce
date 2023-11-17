package com.gmc_team.e_commerse_platform.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "online_shop")

public class Online_shop extends abstract_class{

    @Column
    private String storename;
    @OneToOne
    private Sellers storeowner;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Sellers> employees;
    @Enumerated(EnumType.STRING)
    private Store_status storestatus;

    @OneToMany
    private List<Descriptions> storedescriptions;

    @OneToMany
    private List<Online_shop_review> onlineshopreviews;

    @ManyToMany
    private List<Payment_method> paymentMehtods;

    @Column
    private String anotherspecialty;
    @Column
    private Float rating;
    @Enumerated(EnumType.STRING)
    private Specialities speciality;

    @ManyToMany
    private List<Customers> storecustomers;

    @OneToOne
    private SocialMedia media;

//    @Column
//    private Boolean referralprogram;



}
