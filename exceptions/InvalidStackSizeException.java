package com.stack_calculator.exceptions;

public class InvalidStackSizeException extends BaseException{
    public InvalidStackSizeException(String message) {
        super(message);
    }

    public InvalidStackSizeException() {
        super("Для выполнения операции необходимо большее кол-во элементов, содержащихся в стеке");
    }

}
