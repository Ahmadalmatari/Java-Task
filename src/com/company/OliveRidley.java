package com.company;

import java.time.LocalDateTime;
import java.util.Date;

public class OliveRidley extends Turtles{

    public OliveRidley() {
        super("OliveRidley");
    }

    public OliveRidley(int id, String specie, double wight, double length, int numberOfWorkingFlippers, LocalDateTime dateTimeOfSample, String location) {
        super("OliveRidley", wight, length, numberOfWorkingFlippers, dateTimeOfSample, location);
    }
}
