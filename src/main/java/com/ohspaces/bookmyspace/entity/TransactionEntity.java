package com.ohspaces.bookmyspace.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "transaction")
@Entity
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private Long txnId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(referencedColumnName = "mem_id", name = "mem_id")
    private MembershipEntity membership;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(referencedColumnName = "user_id", name = "user_id")
    private UserEntity user;


    @Column(name = "amount")
    private Double amount;

    @Column(name = "txn_ref_id")
    private String txnRefId;

    @Column(name = "is_success")
    private Boolean isSuccess;

    @Column(name = "is_failure")
    private Boolean isFailure;

    @Column(name = "failed_resp")
    private String failedResp;

    @Column(name = "failed_code")
    private String failedCode;

    @Column(name = "txn_ref_time")
    private Timestamp txnRefTime;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "update_by")
    private String updateBy;
}
