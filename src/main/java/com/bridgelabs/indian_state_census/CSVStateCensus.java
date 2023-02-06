package com.bridgelabs.indian_state_census;

public class CSVStateCensus {
    private int sNo;
    private String state;
    private long population;
    private double increase;
    private long area;
    private int density;
    private int sexRatio;
    private double literacy;

    public CSVStateCensus(int sNo, String state, long population, double increase, long area, int density, int sexRatio, double literacy) {
        this.sNo = sNo;
        this.state = state;
        this.population = population;
        this.increase = increase;
        this.area = area;
        this.density = density;
        this.sexRatio = sexRatio;
        this.literacy = literacy;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getIncrease() {
        return increase;
    }

    public void setIncrease(double increase) {
        this.increase = increase;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public int getSexRatio() {
        return sexRatio;
    }

    public void setSexRatio(int sexRatio) {
        this.sexRatio = sexRatio;
    }

    public double getLiteracy() {
        return literacy;
    }

    public void setLiteracy(double literacy) {
        this.literacy = literacy;
    }
    public String toString() {
        return "S.No: "+sNo+", State: "+state+", Population: "+population+", Increase(%) : "+increase
                +", Area(Km2): "+area+", Density: "+density+" Sex Ratio: "+sexRatio+", Literacy: "+literacy;
    }
}
