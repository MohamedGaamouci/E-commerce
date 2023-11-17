package com.gmc_team.e_commerse_platform.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
public class abstract_class implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract_class() {
    }

    @CreatedDate
    @Column(name = "creation_Date", nullable = false, updatable = false)
    private Instant creationDate;
    @LastModifiedDate
    @Column(name = "last_Modified_Date")
    private Instant lastModifiedDate;




}
