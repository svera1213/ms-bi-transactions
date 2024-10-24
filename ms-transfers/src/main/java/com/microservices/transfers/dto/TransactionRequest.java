package com.microservices.transfers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private Long originAccountId;
    private Long destinationAccountId;
    private Double amount;
}
