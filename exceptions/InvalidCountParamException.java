package com.stack_calculator.exceptions;

public class InvalidCountParamException extends BaseException{
    public InvalidCountParamException(String message) {
        super(message);
    }

    public InvalidCountParamException() {
        super("В стеке недостаточно элементов для выполнения операции");
    }
}
