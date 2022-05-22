package com.av.finance.transaction.infrastructure.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TRANSACTIONS")
public class TransactionEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID txId;

    @Column(nullable = false, updatable = false)
    private UUID accountId;

    @Column(nullable = false, updatable = false)
    private String txType;

    @Column(nullable = false, precision = 14, scale = 5)
    private BigDecimal amount;

    private String details;
}
