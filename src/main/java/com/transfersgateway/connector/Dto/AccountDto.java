package com.transfersgateway.connector.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {
    private String nrb;
    private Double availableFunds;
}
