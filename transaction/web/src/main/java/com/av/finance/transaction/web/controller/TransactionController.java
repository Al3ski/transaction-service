package com.av.finance.transaction.web.controller;

import com.av.finance.transaction.app.service.TransactionService;
import com.av.finance.transaction.domain.transaction.Transaction;
import com.av.finance.transaction.web.dto.TxDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Transaction", description = "Transactions related APIs")
@AllArgsConstructor
@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Operation(
            summary = "Get transactions by account IDs",
            description = "Return transactions list for provided account IDs"
    )
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getTransactionsForAccounts(@Valid
                                                                        @RequestParam(name = "account_id")
                                                                        @NotNull List<UUID> accountIds) {
        final List<Transaction> transactions = transactionService.retrieveByAccounts(accountIds);
        return ResponseEntity.ok(transactions);
    }

    @Operation(
            summary = "Create transaction by input details",
            description = "Return location of the newly created transaction"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    headers = @Header(
                            name = "location",
                            description = "Link to newly created transaction",
                            schema = @Schema(type = "string")
                    ))
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
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
