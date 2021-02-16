package com.tenxbanking.simpleservice.repositories;

import com.tenxbanking.simpleservice.db.Bankjpa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankRepository extends PagingAndSortingRepository<Bankjpa, Long> {
}
