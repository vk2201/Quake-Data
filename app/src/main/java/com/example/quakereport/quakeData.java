package com.example.quakereport;

public class quakeData {
    private String mMagnitude;
    private String mLocation;
    private String mDateTime;


    public quakeData(String mag , String location , String dateTime ){
        this.mMagnitude = mag;
        this.mDateTime=dateTime;
        this.mLocation=location;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDateTime() {
        return mDateTime;
    }
}

