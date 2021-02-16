package com.tenxbanking.simpleservice.client;

import com.tenxbanking.simpleservice.model.BankDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //brings up the entire context
class BankClientTest {

    @Autowired
    BankClient bankClient;
    String dummyId = "12345";

    @Test
    void getBankDtoById() {
        BankDto dto = bankClient.getBankDtoById(dummyId);
        assertNotNull(dto);
    }

    @Test
    void getBankDtoPostObject() {
        BankDto bankDto = BankDto.builder().id(dummyId).build();
        URI uri = bankClient.doPost(bankDto);
        assertNotNull(uri);
    }
}