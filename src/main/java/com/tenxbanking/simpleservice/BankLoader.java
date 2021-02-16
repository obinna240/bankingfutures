package com.tenxbanking.simpleservice;

import com.tenxbanking.simpleservice.db.Bankjpa;
import com.tenxbanking.simpleservice.repositories.BankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BankLoader implements CommandLineRunner {

    private final BankRepository bankRepository;

    public BankLoader(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBanks();
    }

    private void loadBanks(){
        if(bankRepository.count() == 0) {
            bankRepository.save(Bankjpa.builder()
                    .numOfClients(10)
                    .fcaNumber(10000L)
                    .worth(BigDecimal.TEN)
                    .build());
        }
    }


}
