package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class LeatherBack extends Turtles{

    public LeatherBack() {
        super("LeatherBack");
    }

    public LeatherBack(int id, String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("LeatherBack", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
