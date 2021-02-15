package com.tenxbanking.simpleservice.service;

import com.tenxbanking.simpleservice.model.BankDto;

public interface BankService {
    BankDto getBank(String id);
    BankDto save(BankDto bankDto);
    void updateBank(String id, BankDto bankDto);
    void deleteById(String id);
}
