package com.av.finance.transaction.infrastructure.persistance;

import com.av.finance.transaction.domain.transaction.Transaction;
import com.av.finance.transaction.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionDao transactionDao;
    private final TransactionMapper mapper;

    @Override
    public Transaction retrieve(UUID txId) {
        final TransactionEntity entity = transactionDao.findById(txId).orElse(null);
        final Transaction transaction = mapper.toTransaction(entity);
        log.debug("Found transaction: {} for tx: {}", transaction, txId);
        return transaction;
    }

    @Override
    public List<Transaction> retrieveByAccount(UUID accountId) {
        final List<TransactionEntity> entities = transactionDao.findAllByAccountId(accountId);
        final List<Transaction> transactions = mapper.toTransactions(entities);
        log.debug("Found transactions: {} for account: {}", transactions, accountId);
        return transactions;
    }

    @Override
    public List<Transaction> retrieveByAccounts(List<UUID> accountIds) {
        final List<TransactionEntity> entities = transactionDao.findAllByAccountIdIn(accountIds);
        final List<Transaction> transactions = mapper.toTransactions(entities);
        log.debug("Found transactions: {} for accounts: {}", transactions, accountIds);
        return transactions;
    }

    @Override
    public void save(Transaction transaction) {
        transactionDao.save(mapper.toEntity(transaction));
        log.debug("Transaction: {} successfully created", transaction);
    }
}
