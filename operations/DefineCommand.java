package com.stack_calculator.operations;
import com.stack_calculator.Context;
import com.stack_calculator.exceptions.BaseException;
import com.stack_calculator.exceptions.ForbiddenOperationException;
import com.stack_calculator.exceptions.InvalidCountParamException;
import com.stack_calculator.exceptions.InvalidFormatException;
import java.util.ArrayList;

public class DefineCommand extends BaseOperation {

    @Override
    public Context command(Context context, ArrayList<String> params) throws BaseException {

        if (params.size() < 2){
            throw new InvalidCountParamException("Не указано значение параметра");
        }

        if (context.map.containsKey(params.get(0))){
            throw new ForbiddenOperationException("Значение параметра '" + params.get(0) + "' уже задано равным " +
                    context.map.get(params.get(0)));
        }

        try {
            double paramValue = Double.parseDouble(params.get(1));
            context.map.put(params.get(0), paramValue);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Тип указанного значения параметра " + params.get(0) + " не является double");
        }

        return null;
    }
}
