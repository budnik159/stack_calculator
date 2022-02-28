package com.stack_calculator;

import com.stack_calculator.operations.BaseOperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class FactoryOperation {
    private Properties property = new Properties();
    private final String pathToConfigFile = "src/com/stack_calculator/Config.properties";

    public FactoryOperation() throws IOException {
        FileInputStream fis = new FileInputStream(pathToConfigFile);
        property.load(fis);
    }

    public BaseOperation create(String operation) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (!property.containsKey(operation)) {
            throw new IllegalArgumentException();
        }
        String name = property.getProperty(operation);
        String className = "com.stack_calculator.operations." + name;
        Class c = Class.forName(className);
        BaseOperation oper = (BaseOperation) c.getDeclaredConstructor().newInstance();
        return oper;
    }
}
