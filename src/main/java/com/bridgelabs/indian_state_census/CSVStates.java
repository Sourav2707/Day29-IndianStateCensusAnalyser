package com.bridgelabs.indian_state_census;

public class CSVStates {
    private int code;
    private String state;
    private String stateCode;

    public CSVStates(int code, String state, String stateCode) {
        this.code = code;
        this.state = state;
        this.stateCode = stateCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStatecode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String toString() {
        return "SNo: "+code+", State: "+state+", StateCode: "+stateCode;
    }
}
