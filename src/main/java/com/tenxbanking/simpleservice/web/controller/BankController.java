package com.tenxbanking.simpleservice.web.controller;

import com.tenxbanking.simpleservice.model.BankDto;
import com.tenxbanking.simpleservice.service.BankService;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

//    public static Logger LOGGER = LoggerFactory.getLogger(BankController.class);

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    private final BankService bankService;

    /**
     * GET MAPPINGS
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<BankDto> getBank(@PathVariable("id") String id){
        return new ResponseEntity<>(BankDto.builder().build(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BankDto> getBankUUID(@PathVariable("uuid") String uuid){
        return new ResponseEntity<>(BankDto.builder().build(), HttpStatus.OK);
    }

    @GetMapping("/{id2}")
    public ResponseEntity<BankDto> getBank2(@PathVariable("id2") String id){
        return new ResponseEntity<>(bankService.getBank(id), HttpStatus.OK);
    }


    /////////////////////////////////
    /**
     * POST MAPPINGS
     */
    @PostMapping
    public ResponseEntity doPost(@RequestBody BankDto dto){
        BankDto bankDto = bankService.save(dto);
        HttpHeaders header = new HttpHeaders();
        header.add("uri-location", "http://localhost:9090/api/v1/bank"+bankDto.getId());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }


    //////////////////
    /**
     * PUT MAPPING
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody BankDto bankDto) {
        bankService.updateBank(id, bankDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    ///////////////////
    /**
     * DELETE
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBank(@PathVariable  String id) {
        log.info("Deleting *****");
        bankService.deleteById(id);
    }


}
