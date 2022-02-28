package com.stack_calculator.exceptions;

public class InvalidNameParamException extends BaseException {

    public InvalidNameParamException() {
        super("Отсутсвует указанный параметр");
    }
    public InvalidNameParamException(String message) {
        super(message);
    }
}
