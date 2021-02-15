package com.tenxbanking.simpleservice.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BankPageList extends PageImpl<BankDto> {

    public BankPageList(List<BankDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BankPageList(List<BankDto> content) {
        super(content);
    }
}
