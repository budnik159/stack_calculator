package com.stack_calculator.exceptions;

public class ForbiddenOperationException extends BaseException {

    public ForbiddenOperationException() {
        super("Запрещенная операция");
    }

    public ForbiddenOperationException(String message) {
        super(message);
    }


}
