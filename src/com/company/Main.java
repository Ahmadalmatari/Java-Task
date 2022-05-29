package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static Scanner s = new Scanner(System.in);

    static List<Turtles> turtles = new ArrayList<>();

    static int index = 1;

    public static void main(String[] args) throws ParseException {


        while (true) {
            System.out.println("Please Chose An Option :\n" + "----------------------------------------------------------------");
            System.out.println("1. New Record               2. View Exist records");
            System.out.println("3. Edit Record              4. Delete Record");
            System.out.println("5. Search For A Record      6. Generate A Summary");
            final String function = s.next();

            functionalities(function);
        }
    }

    public static void functionalities(String function) throws ParseException {


        switch (function) {
            case "1":
                System.out.println("Enter A New Record ");
                System.out.println("Please Enter The Specie: ");
                String specie = s.next();
                System.out.println("Please Enter The Wight In KG: ");
                double wight = s.nextDouble();
                System.out.println("Please Enter The Length In CM: ");
                double length = s.nextDouble();
                System.out.println("Please Enter The Number Of Working Flippers: ");
                int numberOfWorkingFlippers = s.nextInt();
                System.out.println("Please Enter The Time Of the Sampling Event: ");
                String timeOfSampling = s.next();
                System.out.println("Please Enter The Date Of the Sampling Event: ");
                String dateOfSampling = s.next();
                System.out.println("Please Enter The Location Of the Sampling Event: ");
                String location = s.next();
                Date dateTimeOfSampling = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateOfSampling + " " + timeOfSampling);
                Turtles turtle = new Turtles(index, specie, wight, length, numberOfWorkingFlippers, dateTimeOfSampling, location);
                turtles.add(turtle);
                System.out.println("************************************************************* \n" + turtle + "\n *************************************************************");
                index++;
                break;

            case "2":

                System.out.println();
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println("Existing Records");
                    System.out.println(turtles);
                }
                break;

            case "3":
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println(turtles);
                    System.out.println("Please Enter ID Of The Record You Want To Edit: ");
                    int i = s.nextInt();
                    Turtles t = findTurtle(i);
                    if (t != null) {

                        while (true) {
                            System.out.println(t);
                            System.out.println("\n ************************************************************* \nPlease Chose A Field To Edit:\n" + "----------------------------------------------------------------");
                            System.out.println("1. Specie                   2. Wight ");
                            System.out.println("3. Length                   4. Number Of Working Flippers");
                            System.out.println("5. Time Of Sampling event   6. Date Of Sampling event");
                            System.out.println("7. Location Of Sampling event");
                            final String e = s.next();
                            switch (e) {
                                case "1":
                                    System.out.println("The Old Value Was :: " + t.specie);
                                    System.out.println("Please Enter The New Value ::");
                                    t.specie = s.next();
                                    System.out.println("*************************************************************");
                                    break;
                                case "2":
                                    System.out.println("The Old Value Was :: " + t.wight);
                                    System.out.println("Please Enter The New Value ::");
                                    t.wight = s.nextDouble();
                                    System.out.println("*************************************************************");
                                    break;
                                case "3":
                                    System.out.println("The Old Value Was :: " + t.length);
                                    System.out.println("Please Enter The New Value ::");
                                    t.length = s.nextDouble();
                                    System.out.println("*************************************************************");
                                    break;
                                case "4":
                                    System.out.println("The Old Value Was :: " + t.numberOfWorkingFlippers);
                                    System.out.println("Please Enter The New Value ::");
                                    t.numberOfWorkingFlippers = s.nextInt();
                                    System.out.println("*************************************************************");
                                    break;
                                case "5":
                                    SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
                                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                                    System.out.println("The Old Value Was :: " + timeFormatter.format(t.dateTimeOfSample));
                                    System.out.println("Please Enter The New Value ::");
                                    String newTime = s.next();
                                    t.dateTimeOfSample = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateFormatter.format(t.dateTimeOfSample) + " " + newTime);
                                    System.out.println("*************************************************************");
                                    break;
                                case "6":
                                    SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
                                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                    System.out.println("The Old Value Was :: " + df.format(t.dateTimeOfSample));
                                    System.out.println("Please Enter The New Value ::");
                                    String newDate = s.next();
                                    t.dateTimeOfSample = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(newDate + " " + tf.format(t.dateTimeOfSample));
                                    System.out.println("*************************************************************");
                                    break;
                                case "7":
                                    System.out.println("The Old Value Was :: " + t.location);
                                    System.out.println("Please Enter The New Value ::");
                                    t.specie = s.next();
                                    System.out.println("*************************************************************");
                                    break;
                                default:
                                    System.out.println("Invalid input !!");
                                    break;
                            }
                        }
                    } else
                        System.out.println("Record Not Found !!");
                }
                break;

            case "4":
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println(turtles);
                    System.out.println("Please Enter ID Of The Record You Want To Delete: ");
                    int idDelete = s.nextInt();
                    Turtles turtleToDelete = findTurtle(idDelete);
                    if (turtleToDelete != null) {
                        turtles.remove(turtleToDelete);
                        System.out.println("Record Deleted Successfully");
                    } else
                        System.out.println("Record Not Found !!");
                }
                break;

            case "5":
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println(turtles);
                    System.out.println("Please Enter ID Of The Record You Want To Search: ");
                    int idSearch = s.nextInt();
                    Turtles turtleToSearch = findTurtle(idSearch);
                    if (turtleToSearch != null) {
                        System.out.println(idSearch);
                    } else
                        System.out.println("Record Not Found !!");
                }
                break;


            case "6":
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                }else if (turtles.size() == 1){
                    System.out.println("There Is Only One Record !!");
                    System.out.println(turtles + "\n" + "*************************************************************");
                }
                else {
                        System.out.println("\n ************************************************************* \nPlease Chose The Suitable Way To Display:\n" + "----------------------------------------------------------------");
                        System.out.println("1. Location                   2. Date ");
                        final String sortBy = s.next();
                        switch (sortBy) {
                            case "1":
                                turtles.sort(Comparator.comparing(Turtles::getLocation));
                                System.out.println(turtles);
                                break;
                            case "2":
                                turtles.sort(Comparator.comparing(Turtles::getDateTimeOfSample));
                                System.out.println(turtles);
                                break;
                            default:
                                System.out.println("Invalid input !!");
                                break;
                        }

                }
                break;

            default:
                System.out.println("Invalid input !!");
                break;
        }

    }

    public static Turtles findTurtle(int id) {
        for (Turtles t : turtles
        ) {
            if (id == t.id)
                return t;
        }
        return null;
    }

}
