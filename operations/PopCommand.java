package com.stack_calculator.operations;

import com.stack_calculator.Context;
import com.stack_calculator.exceptions.BaseException;
import com.stack_calculator.exceptions.InvalidStackSizeException;

import java.util.ArrayList;

public class PopCommand extends BaseOperation {
    @Override
    public Context command(Context context, ArrayList<String> params) throws BaseException {

        if(context.stack.empty()){
            throw new InvalidStackSizeException("В стеке нет элементов");
        }
       context.stack.pop();
       return context;
    }
}
