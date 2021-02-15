package com.tenxbanking.simpleservice.service;

import com.tenxbanking.simpleservice.model.BankDto;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Override
    public BankDto getBank(String id) {
        return null;
    }

    @Override
    public BankDto save(BankDto bankDto) {
        return null;
    }

    @Override
    public void updateBank(String id, BankDto bankDto) {

    }

    @Override
    public void deleteById(String id) {

    }
}
