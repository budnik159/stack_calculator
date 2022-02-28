package com.stack_calculator.operations;
import com.stack_calculator.Context;
import com.stack_calculator.exceptions.BaseException;
import com.stack_calculator.exceptions.ForbiddenOperationException;
import com.stack_calculator.exceptions.InvalidStackSizeException;

import java.util.ArrayList;

public class SquareRootCommand extends BaseOperation {
    @Override
    public Context command(Context context,  ArrayList<String> params) throws BaseException {

        if(context.stack.empty()){
            throw new InvalidStackSizeException("В стеке нет элементов");
        }

        double value = context.stack.pop();
        if (value < 0) {
            throw new ForbiddenOperationException("Извлечение корня из отрицательного числа запрещено");
        }

        context.stack.push(Math.sqrt(value));
        return context;
    }
}
