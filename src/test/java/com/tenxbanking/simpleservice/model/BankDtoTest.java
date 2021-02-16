package com.tenxbanking.simpleservice.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BankDtoTest extends HelperDtoTest{

    @Autowired
    ObjectMapper objectMapper;
    String jsonString;

//    @Test
    void serializeObject() throws JsonProcessingException {
        BankDto bankDto = bankDto();
        jsonString = objectMapper.writeValueAsString(bankDto);
    }

    @Test
    void deserialize() throws JsonProcessingException {
        BankDto bankDto = objectMapper.readValue(jsonString, BankDto.class);
        //do assertions
    }
}