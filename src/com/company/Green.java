package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class Green extends Turtles{

    public Green() {
        super("Green");
    }

    public Green(int id, String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("Green", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
