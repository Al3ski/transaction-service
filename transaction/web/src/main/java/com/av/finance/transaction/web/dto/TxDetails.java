package com.av.finance.transaction.web.dto;

import com.av.finance.transaction.domain.transaction.TransactionType;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Value
public class TxDetails {

    @NotNull
    UUID accountId;

    @NonNull
    TransactionType txType;

    @NotNull
    BigDecimal amount;

    String details;
}
