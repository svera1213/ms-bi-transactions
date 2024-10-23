package com.microservices.transfers.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_account_id", referencedColumnName = "id")
    private Account originAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id")
    private Account destinationAccount;

    private Double amount;

    @Column(name = "origin_balance")
    private Double originBalance;

    @Column(name = "origin_new_balance")
    private Double originNewBalance;

    @Column(name = "destination_balance")
    private Double destinationBalance;

    @Column(name = "destination_new_balance")
    private Double destinationNewBalance;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "created_at_offset")
    private OffsetDateTime createdAt;
}
