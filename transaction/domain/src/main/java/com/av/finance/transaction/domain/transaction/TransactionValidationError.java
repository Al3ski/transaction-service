package com.av.finance.transaction.domain.transaction;

import com.av.finance.transaction.common.BusinessException;

public class TransactionValidationError extends BusinessException {

    public TransactionValidationError(String message) {
        super(message);
    }
}
