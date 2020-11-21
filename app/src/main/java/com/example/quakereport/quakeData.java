package com.example.quakereport;

public class quakeData {
    private double mMagnitude;
    private String mLocation;
    private long mDateTime;


    public quakeData(double mag , String location , long dateTime ){
        this.mMagnitude = mag;
        this.mDateTime=dateTime;
        this.mLocation=location;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmDateTime() {
        return mDateTime;
    }
}

