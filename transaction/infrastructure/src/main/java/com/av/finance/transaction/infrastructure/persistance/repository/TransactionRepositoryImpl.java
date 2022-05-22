package com.av.finance.transaction.infrastructure.persistance.repository;

import com.av.finance.transaction.domain.transaction.Transaction;
import com.av.finance.transaction.domain.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public Transaction retrieve(UUID txId) {
        return null;
    }

    @Override
    public List<Transaction> retrieveByAccount(UUID accountId) {
        return null;
    }

    @Override
    public void save(Transaction transaction) {

    }
}
