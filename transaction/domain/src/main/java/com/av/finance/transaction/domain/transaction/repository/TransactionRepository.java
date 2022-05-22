package com.av.finance.transaction.domain.transaction.repository;

import com.av.finance.transaction.domain.transaction.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository {

    Transaction retrieve(UUID txId);

    List<Transaction> retrieveByAccount(UUID accountId);

    List<Transaction> retrieveByAccounts(List<UUID> accountIds);

    void save(Transaction transaction);
}
