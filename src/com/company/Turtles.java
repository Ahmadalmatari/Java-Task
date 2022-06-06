package com.company;

import java.time.LocalDateTime;

public class Turtles {

    private int id;
    private String specie;
    private double wight;
    private double length;
    private int numberOfWorkingFlippers;
    private LocalDateTime dateTimeOfSample;
    private String location;

    public Turtles() {

    }

    public Turtles(String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        this.specie = specie;
        this.wight = wight;
        this.length = length;
        this.numberOfWorkingFlippers = numberOfWorkingFlippers;
        this.dateTimeOfSample = dateTimeOfSample;
        this.location = location;
    }

    public Turtles(String specie) {
        this.specie = specie;
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

    public LocalDateTime getDateTimeOfSample() {
        return dateTimeOfSample;
    }

    public void setDateTimeOfSample(LocalDateTime dateTimeOfSample) {
        this.dateTimeOfSample = dateTimeOfSample;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
