package com.bridgelabs.indian_state_census;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateCensusAnalyser {
    CSVStateCensus census;
    List<CSVStateCensus> censuses = new ArrayList<>();

    public List<CSVStateCensus> readCSV(File file) throws CustomException, IOException, CsvException {
        String expectedType = "csv";
        int index = file.toString().lastIndexOf('.');
        String actualType = file.toString().substring(index+1);
        try {
            if(file.exists()) {
                FileReader fileReader = new FileReader(file);
                CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
                List<String[]> allData = csvReader.readAll();
                for (String[] row : allData) {
                    int sNo = Integer.parseInt(row[0]);
                    String state = row[1];
                    long population = Long.parseLong(row[2]);
                    double increase = Double.parseDouble(row[3]);
                    long area = Long.parseLong(row[4]);
                    int density = Integer.parseInt(row[5]);
                    int sexRatio = Integer.parseInt(row[6]);
                    double literacy = Double.parseDouble(row[7]);
                    census = new CSVStateCensus(sNo, state, population, increase, area, density, sexRatio, literacy);
                    censuses.add(census);
                }
            }
            if(!expectedType.equals(actualType)){
                throw new CustomException(CustomException.ExceptionType.FILE_TYPE_MISMATCH, "Oops!, it seems the file type doesn't match");
            }
            else {
                throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND, "Oops!, it seems the file doesn't exist");
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }
        return censuses;
    }
}
