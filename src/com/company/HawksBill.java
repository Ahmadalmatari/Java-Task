package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class HawksBill extends Turtles{

    public HawksBill() {
        super("HawksBill");
    }

    public HawksBill(int id, String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("HawksBill", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
