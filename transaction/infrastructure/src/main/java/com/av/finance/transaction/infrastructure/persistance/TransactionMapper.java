package com.av.finance.transaction.infrastructure.persistance;

import com.av.finance.transaction.domain.transaction.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toTransaction(TransactionEntity entity);

    TransactionEntity toEntity(Transaction transaction);

    List<Transaction> toTransactions(List<TransactionEntity> entities);

    List<TransactionEntity> toEntities(List<Transaction> transactions);
}
