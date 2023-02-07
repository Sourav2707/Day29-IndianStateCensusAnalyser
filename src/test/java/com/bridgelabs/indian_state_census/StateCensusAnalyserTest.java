package com.bridgelabs.indian_state_census;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StateCensusAnalyserTest {
    List<CSVStateCensus> expectedList;
    List<CSVStateCensus> actualList;
    @Test
    void readCSVCheckingRecordMatches() throws IOException, CsvException, CustomException {
        File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\StateCensusData.csv");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        actualList = stateCensusAnalyser.readCSV(actualFile);
        int actual = actualList.size();
        int expected = 35;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void readCSVTestingFILE_Not_FOUNDException() throws IOException, CsvException, CustomException {
            try {
                File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\StateCensus.csv");
                StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
                stateCensusAnalyser.readCSV(actualFile);
            }
            catch (CustomException e) {
             String message = e.getMessage();
                Assertions.assertEquals("Oops!, it seems the file doesn't exist", message);
            }
    }
    @Test
    void readCSVTestingFILE_TYPE_MISMATCHException() throws IOException, CsvException, CustomException {
        try {
            File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\StateCensus.pdf");
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.readCSV(actualFile);
        }
        catch (CustomException e) {
            String message = e.getMessage();
            Assertions.assertEquals("Oops!, it seems the file type doesn't match", message);
        }
    }
    @Test
    void readCSVTestingDELIMETER_INCORRECTException() throws IOException, CsvException, CustomException {
        try {
            File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\DelimeterIncorrectData.csv");
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.readCSV(actualFile);
        }
        catch (CustomException e) {
            String message = e.getMessage();
            Assertions.assertEquals("Oops, it seems the files weren't separated by comman check the delimeter", message);
        }
    }
    @Test
    void readCSVTestingHEADER_MISMATCHException() throws IOException, CsvException, CustomException {
        try {
            File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\HeaderMismatch.csv");
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.readCSV(actualFile);
        }
        catch (CustomException e) {
            String message = e.getMessage();
            Assertions.assertEquals("It seems the header is not match, please check the header", message);
        }
    }
}