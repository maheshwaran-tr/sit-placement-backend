package com.sit.placementcell.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "proofs")
public class Proofs extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proof_id")
    private Integer proofId;

    @Column(name = "application_id")
    private Integer applicationId;

    @Lob
    @Column(name = "proof", columnDefinition = "LONGBLOB")
    private byte[] proof;
}
