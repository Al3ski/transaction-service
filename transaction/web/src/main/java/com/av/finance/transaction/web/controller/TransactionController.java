package com.av.finance.transaction.web.controller;

import com.av.finance.transaction.app.service.TransactionService;
import com.av.finance.transaction.web.dto.TxDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createTransaction(@Valid @RequestBody TxDetails txDetails) {
        final UUID txId = transactionService.createTransaction(
                txDetails.getAccountId(), txDetails.getTxType(),
                txDetails.getAmount(), txDetails.getDetails()
        );
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(txId)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
