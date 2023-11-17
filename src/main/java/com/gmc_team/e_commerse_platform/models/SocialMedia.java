package com.gmc_team.e_commerse_platform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SocialMedia")
public class SocialMedia extends abstract_class{
    @Column
    private String facebook;
    @Column
    private String Telegram;
    @Column
    private String instagram;
    @Column
    private String youtub;
    @Column
    private String linkedin;
}
