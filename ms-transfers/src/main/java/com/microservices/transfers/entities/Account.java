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
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_national_id")
    private Long userNationalId;

    private String type;
    private Double balance = 0.0;
    private String status;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "created_at_offset")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "updated_at_offset")
    private OffsetDateTime updatedAt;

    @Column(name = "is_enabled", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isEnabled;
}
