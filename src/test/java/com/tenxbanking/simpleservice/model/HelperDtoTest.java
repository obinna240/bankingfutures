package com.tenxbanking.simpleservice.model;

import java.time.LocalDate;
import java.util.UUID;

public class HelperDtoTest {

    BankDto bankDto(){
        return BankDto.builder()
                .name("dummy bank")
                .id("12345")
                .facNum(123456789L)
                .uuid(UUID.randomUUID())
                .localDate(LocalDate.now())
                .build();
    }
}
