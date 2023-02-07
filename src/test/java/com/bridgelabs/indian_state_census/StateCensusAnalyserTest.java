package com.bridgelabs.indian_state_census;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StateCensusAnalyserTest {
    List<CSVStateCensus> expectedList;
    List<CSVStateCensus> actualList;
    @org.junit.jupiter.api.Test
    void readCSV() throws IOException, CsvException {
        File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\StateCensusData.csv");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        actualList = stateCensusAnalyser.readCSV(actualFile);
        int actual = actualList.size();
        int expected = 35;
        Assertions.assertEquals(actual, expected);
    }
}