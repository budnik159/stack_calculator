package com.stack_calculator.operations;

import com.stack_calculator.Context;
import com.stack_calculator.exceptions.BaseException;
import com.stack_calculator.exceptions.InvalidStackSizeException;
import java.util.ArrayList;

public class MultiplicationCommand extends BaseOperation {

    @Override
    public Context command(Context context, ArrayList<String> params) throws BaseException {

        if (context.stack.size() < 2){
            throw new InvalidStackSizeException();
        }
        double firstValue = context.stack.pop();
        double secondValue = context.stack.pop();
        context.stack.push(firstValue*secondValue);
        return context;
    }
}
