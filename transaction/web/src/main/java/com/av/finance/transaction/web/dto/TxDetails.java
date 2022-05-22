package com.av.finance.transaction.web.dto;

import com.av.finance.transaction.domain.transaction.TransactionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Value
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class TxDetails {

    @NotNull
    UUID accountId;

    @NonNull
    TransactionType txType;

    @NotNull
    BigDecimal amount;

    String details;
}
