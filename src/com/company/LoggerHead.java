package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class LoggerHead extends Turtles{

    public LoggerHead() {
        super("LoggerHead");
    }

    public LoggerHead(int id, String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("LoggerHead", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
