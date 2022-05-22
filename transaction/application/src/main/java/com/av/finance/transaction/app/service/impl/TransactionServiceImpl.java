package com.av.finance.transaction.app.service.impl;

import com.av.finance.transaction.app.service.TransactionService;
import com.av.finance.transaction.domain.transaction.Transaction;
import com.av.finance.transaction.domain.transaction.TransactionType;
import com.av.finance.transaction.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction retrieve(UUID txId) {
        return transactionRepository.retrieve(txId);
    }

    @Override
    public List<Transaction> retrieveByAccount(UUID accountId) {
        return transactionRepository.retrieveByAccount(accountId);
    }

    @Override
    public List<Transaction> retrieveByAccounts(List<UUID> accountIds) {
        return transactionRepository.retrieveByAccounts(accountIds);
    }

    @Override
    public UUID createTransaction(UUID accountId, TransactionType type, BigDecimal initialCredit, String details) {
        final Transaction transaction = Transaction.create(accountId, type, initialCredit, details);
        transactionRepository.save(transaction);

        return transaction.getTxId();
    }
}
