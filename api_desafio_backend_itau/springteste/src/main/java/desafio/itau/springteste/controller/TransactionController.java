package desafio.itau.springteste.controller;

import desafio.itau.springteste.dto.TransactionRequest;
import desafio.itau.springteste.model.Transaction;
import desafio.itau.springteste.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    public final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
        if (request.getDatahora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(new Transaction(request.getValor(), request.getDatahora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTransaction() {
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }

}
