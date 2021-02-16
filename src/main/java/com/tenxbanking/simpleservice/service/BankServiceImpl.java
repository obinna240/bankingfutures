package com.tenxbanking.simpleservice.service;

import com.tenxbanking.simpleservice.model.BankDto;
import com.tenxbanking.simpleservice.repositories.BankRepository;
import com.tenxbanking.simpleservice.web.controller.exception.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service

public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    //we can use conditional caching
    //@Cacheable(cacheNames = "bankListCache")
    //ZOE RESPOND DIFFERENTLY TO FOOD
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankDto getBank(String id) {

        bankRepository.findById(Long.parseLong(id)).orElseThrow(NotFoundException::new);
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
