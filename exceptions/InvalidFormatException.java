package com.stack_calculator.exceptions;

public class InvalidFormatException extends BaseException{
    public InvalidFormatException(String message) {
        super(message);
    }

    public InvalidFormatException() {
        super("Тип указанного значения параметра не является double");
    }
}
