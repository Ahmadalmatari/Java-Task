package com.company;

import java.util.Date;

public class Turtles {

    public int id;
    public String specie;
    public double wight;
    public double length;
    public int numberOfWorkingFlippers;
    public Date dateTimeOfSample;
    public String location;

    public Turtles() {

    }

    public Turtles(int id, String specie, double wight, double length, int numberOfWorkingFlippers, Date dateTimeOfSample, String location) {
        this.id = id;
        this.specie = specie;
        this.wight = wight;
        this.length = length;
        this.numberOfWorkingFlippers = numberOfWorkingFlippers;
        this.dateTimeOfSample = dateTimeOfSample;
        this.location = location;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getNumberOfWorkingFlippers() {
        return numberOfWorkingFlippers;
    }

    public void setNumberOfWorkingFlippers(int numberOfWorkingFlippers) {
        this.numberOfWorkingFlippers = numberOfWorkingFlippers;
    }

    public Date getDateTimeOfSample() {
        return dateTimeOfSample;
    }

    public void setDateTimeOfSample(Date dateTimeOfSample) {
        this.dateTimeOfSample = dateTimeOfSample;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "\nTurtle ::\n" +
                "Id : " + id + "   ---------------------   " +
                ", Specie :" + specie + '\n' +
                "Wight In KG :" + wight + "   ---------------------   " +
                ", Length In CM:" + length + '\n' +
                "Number Of Working Flippers :" + numberOfWorkingFlippers + "   ---------------------   " +
                ", DateTime Of The Sample :" + dateTimeOfSample + '\n' +
                "Location Of The Sample :" + location ;
    }
}
