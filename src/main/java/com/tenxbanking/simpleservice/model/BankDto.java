package com.tenxbanking.simpleservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class BankDto {

    private String id;

    private UUID uuid;

    private String name;

    //
//    private BigInteger money;
}
