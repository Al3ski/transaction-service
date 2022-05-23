package com.av.finance.transaction.common;

import java.util.StringJoiner;

public class ErrorMessage {

    private final String errorMessage;

    private final String errorCode;

    private String details;

    public ErrorMessage(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ErrorMessage(String errorMessage, String errorCode, String details) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.details = details;
    }
}
