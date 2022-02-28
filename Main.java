package com.stack_calculator;

import com.stack_calculator.operations.BaseOperation;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static String getAdditionalInfo(ArrayList<String> params) {

        switch (params.size()) {
           case 1:
                return " для параметра '" + params.get(0) + "' выполнена";
            case 2:
                return " для параметра '" + params.get(0) + "' равного " + params.get(1) + " выполнена";
        }

        return "";
    }

    public static void main(String[] args) {

        log.info("Запуск логирования. Логирование ведется в файл application_log.txt");

        try{
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("../logging.properties"));
        }catch(IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        // Теперь запись будет вестись в файл
        log.log(Level.INFO, "Уровень логирования - " + LogManager.getLogManager().getProperty("java.util.logging.FileHandler.level"));
        log.log(Level.INFO, "Начало работы программы");
        Context context = new Context();

        try {
            FactoryOperation factoryOperation = new FactoryOperation();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/stack_calculator/operations.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null ){
                String[] data = line.split(" ");
                String operationName = data[0];
                BaseOperation operation = factoryOperation.create(operationName);
                ArrayList<String> params = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    params.add(data[i]);
                }

                operation.command(context, params);

                log.log(Level.INFO, "Операция " + operationName + getAdditionalInfo(params));
            }
        } catch (Exception e) {
            log.log(Level.INFO, "Exception : ", e);
        }

        log.log(Level.INFO, "Завершение работы программы");

    }
}
