package com.microservices.transfers.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.LocalDateTime;

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

    @Column(name = "account_name")
    private String accountName;
    private Double balance = 0.0;
    private String status = "ACTIVE";

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "is_enabled")
    private Boolean isEnabled = true;
}
