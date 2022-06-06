package com.av.finance.transaction.infrastructure.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface TransactionDao extends CrudRepository<TransactionEntity, UUID> {

    List<TransactionEntity> findAllByAccountId(UUID accountId);

    List<TransactionEntity> findAllByAccountIdIn(List<UUID> accountIds);
}
