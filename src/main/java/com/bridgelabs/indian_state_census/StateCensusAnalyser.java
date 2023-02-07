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
    FileReader fileReader;
    public List<CSVStateCensus> readCSV(File file) throws CustomException, IOException, CsvException {
        //checking extension
        String expectedType = "csv";
        int index = file.toString().lastIndexOf('.');
        String actualType = file.toString().substring(index+1);
        if(file.exists()) {
            fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            //checking header
            String[] header = new CSVReader(new FileReader(file)).readAll().get(0);
            for (String[] row : allData) {
                //checking delimeter is correct
                if(row.length < 2) {
                    throw new CustomException(CustomException.ExceptionType.DELIMETER_INCORRECT, "Oops, it seems the files weren't separated by comma check the delimeter");
                }
                if(!header[0].equals("Code") || !header[1].equals("State") || !header[2].equals("Population") || !header[3].equals("Increase %") || !header[4].equals("Area Km2")
                        || !header[5].equals("Density") || !header[6].equals("Sex-Ratio") || !header[7].equals("Literacy")) {
                    throw new CustomException(CustomException.ExceptionType.HEADER_MISMATCH, "It seems the header is not match, please check the header");
                }
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
        else if(!expectedType.equals(actualType)){
            throw new CustomException(CustomException.ExceptionType.FILE_TYPE_MISMATCH, "Oops!, it seems the file type doesn't match");
        }
        else {
            throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND, "Oops!, it seems the file doesn't exist");
        }
        return censuses;
    }
}