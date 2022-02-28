package com.stack_calculator;

import com.stack_calculator.operations.BaseOperation;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class FactoryOperationTest {

    private static Logger log = Logger.getLogger(FactoryOperationTest.class.getName());

    Context context1 = new Context();
    Context context2 = new Context();

    @Before
    public void fillContext(){
        context1.stack.push(1.0);
        context1.stack.push(2.0);

        context2.stack.push(10.0);

        try{
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("../logging.properties"));
        }catch(IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }

    // В стеке два числа. Вызов операции сложения
    @Test
    public void AdditionCommandTest1(){
        try {
            FactoryOperation factoryOperation = new FactoryOperation();
            BaseOperation addOperation = factoryOperation.create("+");
            addOperation.command(context1, null);
            assertEquals(3.0, context1.stack.peek(), 0);
        } catch (Exception e) {
            log.log(Level.INFO, "Exception : ", e);
        }
    }

    // В стеке одно число. Вызов операции сложения
    @Test
    public void AdditionCommandTest2(){
        try {
            FactoryOperation factoryOperation = new FactoryOperation();
            BaseOperation addOperation = factoryOperation.create("+");
            addOperation.command(context2, null);
        } catch (Exception e) {
            assertEquals("Для выполнения операции необходимо большее кол-во элементов, содержащихся в стеке", e.getMessage());
            log.log(Level.INFO, "Exception : ", e);
        }
    }

    // Присвоение значения типа double одному параметру
    @Test
    public void defineCommandTest1(){
        try {
            FactoryOperation factoryOperation = new FactoryOperation();
            BaseOperation addOperation = factoryOperation.create("DEFINE");
            ArrayList<String> param = new ArrayList(Arrays.asList("a", "1.0"));
            addOperation.command(context1, param);
            assertEquals(1.0, context1.map.get("a"), 0);
        } catch (Exception e) {
            log.log(Level.INFO, "Exception : ", e);
        }
    }

    // Присвоение значения типа String одному параметру
    @Test
    public void defineCommandTest2(){
        ArrayList<String> param = new ArrayList(Arrays.asList("a", "c"));
        try {
            FactoryOperation factoryOperation = new FactoryOperation();
            BaseOperation addOperation = factoryOperation.create("DEFINE");
            addOperation.command(context1, param);

        } catch (Exception e) {
            assertEquals("Тип указанного значения параметра " +  param.get(0) + " не является double", e.getMessage());
            log.log(Level.INFO, "Exception : ", e);
        }
    }



}