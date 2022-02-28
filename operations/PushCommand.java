package com.stack_calculator.operations;

import com.stack_calculator.Context;
import com.stack_calculator.exceptions.BaseException;
import com.stack_calculator.exceptions.InvalidFormatException;

import java.util.ArrayList;

public class PushCommand extends BaseOperation {

    @Override
    public Context command(Context context, ArrayList<String> params) throws BaseException {
        Double value = context.map.getOrDefault(params.get(0), null);
        if (value == null) {
            try {
                value = Double.parseDouble(params.get(0));
            } catch (NumberFormatException e) {
                throw new InvalidFormatException("Тип указанного значения не является double");
            }
        }
        context.stack.push(value);
        return context;
    }
}
