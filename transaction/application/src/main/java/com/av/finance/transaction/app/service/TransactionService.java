package com.av.finance.transaction.app.service;

import com.av.finance.transaction.domain.transaction.Transaction;
import com.av.finance.transaction.domain.transaction.TransactionType;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    Transaction retrieve(UUID txId);

    List<Transaction> retrieveByAccount(UUID accountId);

    List<Transaction> retrieveByAccounts(List<UUID> accountIds);

    UUID createTransaction(UUID accountId, TransactionType type, BigDecimal initialCredit, String details);
}
