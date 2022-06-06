package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class FlatBack extends Turtles{

    public FlatBack() {
        super("FlatBack");
    }

    public FlatBack(String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("FlatBack", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
