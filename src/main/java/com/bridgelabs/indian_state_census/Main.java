package com.bridgelabs.indian_state_census;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
    File file1 = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\HeaderMismatch.csv");
    File file2 = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\StateCode.csv");
    Scanner scanner = new Scanner(System.in);
    CSVStateCensus census;
    List<CSVStateCensus> censuses = new ArrayList<>();
    CSVStates csvStates;
    List<CSVStates> states = new ArrayList<>();
    public void menu() throws CsvException, IOException, CustomException {
        System.out.println("Menu 1. Read from CSV file and print 2. Load CSV States code 3. Print data from csv file 4. Print State code 5. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                censuses = stateCensusAnalyser.readCSV(file1);
                menu();
                break;
            case 2:
                states = stateCensusAnalyser.readeStateCSV(file2);
                menu();
                break;
            case 3:
                for(CSVStateCensus values : censuses) {
                    System.out.println(values);
                }
                menu();
                break;
            case 4:
                for(CSVStates values: states) {
                    System.out.println(values);
                }
                menu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid option");
                menu();
                break;
        }
    }
    public static void main(String[] args) throws CsvException, IOException, CustomException {
        System.out.println("Welcome to Indian state census analyser program");
        Main main = new Main();
        main.menu();
    }
}