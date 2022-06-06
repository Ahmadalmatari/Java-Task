package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class KempsRidley extends Turtles{

    public KempsRidley() {
        super("KempsRidley");
    }

    public KempsRidley(int id, String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("KempsRidley", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
