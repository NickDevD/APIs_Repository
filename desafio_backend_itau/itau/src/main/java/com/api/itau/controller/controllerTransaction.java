package com.api.itau.controller;

import com.api.itau.dto.TransactionDTO;
import com.api.itau.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi")
public class controllerTransaction {

    private final TransactionService service;

    public controllerTransaction(TransactionService service){
        this.service = service;
    }

    @PostMapping("/transactions")
    public ResponseEntity<Void> trasnsaction(@RequestBody TransactionDTO dto){
        service.addTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(){
        service.clearTransaction();
        return ResponseEntity.ok().build();
    }
}
