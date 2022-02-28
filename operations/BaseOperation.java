package com.stack_calculator.operations;

import com.stack_calculator.Context;
import com.stack_calculator.exceptions.BaseException;

import java.util.ArrayList;

public abstract class BaseOperation {

    abstract public Context command(Context context, ArrayList<String> params) throws BaseException;
}
