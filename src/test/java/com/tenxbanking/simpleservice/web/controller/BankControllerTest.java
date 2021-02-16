package com.tenxbanking.simpleservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenxbanking.simpleservice.model.BankDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

//we use the webmvc test slice here to bring in the web configuration
@WebMvcTest(BankController.class)
class BankControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private static String API = "/api/v1/bank";
    String id = "1234";
    BankDto bank;

    @BeforeEach
    void init(){
        bank.builder()
                .id("1")
                .name("testBank")
                .build();
    }

//    get with body
//    mockMvc.perform(post(API+"/"+id).accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.id", is(1)));

    @Test
    void getBank() throws Exception {
        mockMvc.perform(get(API+"/"+id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void doPost() throws Exception {
        mockMvc.perform(post(API+"/"+id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bank)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    void update() {

    }

    @Test
    void deleteBank() {
    }
}