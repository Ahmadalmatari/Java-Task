package com.company;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
                initiateNewRecord();
                break;

            case "2":
                System.out.println();
                turtles = getAllRecords();
                assert turtles != null;
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println("Existing Records");
                    System.out.println(turtles);
                }

                break;

            case "3":
                turtles = getAllRecords();
                assert turtles != null;
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println("Existing Records");
                    updateRecord(turtles);
                }
                break;

            case "4":
                turtles = getAllRecords();
                assert turtles != null;
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println(turtles);
                    System.out.println("Please Enter ID Of The Record You Want To Delete: ");
                    int idDelete = s.nextInt();
                    Turtles turtleToDelete = findTurtle(idDelete);
                    if (turtleToDelete != null) {
                        deleteRecord(turtleToDelete.getId());
                        System.out.println("Record Deleted Successfully");
                    } else
                        System.out.println("Record Not Found !!");
                }
                break;

            case "5":
                turtles = getAllRecords();
                assert turtles != null;
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println("Please Enter ID Of The Record You Want To Search: ");
                    int idSearch = s.nextInt();
                    Turtles turtleToSearch = findTurtle(idSearch);
                    if (turtleToSearch != null) {
                        System.out.println(turtleToSearch);
                    } else
                        System.out.println("Record Not Found !!");
                }
                break;


            case "6":
                turtles = getAllRecords();
                assert turtles != null;
                if (turtles.isEmpty()) {
                    System.out.println("There Is No Records !!\n" + "*************************************************************");
                } else {
                    System.out.println("\n ************************************************************* \nPlease Chose The Suitable Way To Display:\n" + "----------------------------------------------------------------");
                    System.out.println("1. Location                   2. Date ");
                    final String reportBy = s.next();
                    switch (reportBy) {
                        case "1":
                            getRecordsReportByLocation(turtles);
                            break;
                        case "2":
                            getRecordsReportByDate(turtles);
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
        return Objects.requireNonNull(getAllRecords()).stream().filter(turtle -> id == turtle.getId()).findAny().orElse(null);
    }

    public static void initiateNewRecord() {

        Turtles turtle = null;
        boolean check;

        System.out.println("Enter A New Record ");
        do {

            check = true;
            System.out.println("Please Chose The Specie: ");
            System.out.println("1. FlatBack                 2. Green ");
            System.out.println("3. HawksBill                4. KempsRidley");
            System.out.println("5. LeatherBack              6. LoggerHead");
            System.out.println("7. OliveRidley");

            String specie = s.next();
            switch (specie) {
                case "1":
                    turtle = new FlatBack();
                    break;

                case "2":
                    turtle = new Green();
                    break;

                case "3":
                    turtle = new HawksBill();
                    break;

                case "4":
                    turtle = new KempsRidley();
                    break;

                case "5":
                    turtle = new LeatherBack();
                    break;

                case "6":
                    turtle = new LoggerHead();
                    break;

                case "7":
                    turtle = new OliveRidley();
                    break;

                default:
                    System.out.println("Invalid input !!");
                    check = false;
                    break;
            }
        } while (!check);

        System.out.println("Please Enter The Wight In KG: ");
        double wight = s.nextDouble();
        System.out.println("Please Enter The Length In CM: ");
        double length = s.nextDouble();
        System.out.println("Please Enter The Number Of Working Flippers: ");
        int numberOfWorkingFlippers = s.nextInt();
        System.out.println("Please Enter The Location Of the Sampling Event: ");
        String location = s.next();
        turtle.setWight(wight);
        turtle.setLength(length);
        turtle.setNumberOfWorkingFlippers(numberOfWorkingFlippers);
        turtle.setDateTimeOfSample(LocalDateTime.now());
        turtle.setLocation(location);
        addNewRecord(turtle);
        System.out.println("************************************************************* \n" + turtle + "\n *************************************************************");
        index++;
    }

    public static Connection connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/NationalAquarium", "root", "");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static List<Turtles> getAllRecords() {
        try {
            Connection con = connectToDB();
            assert con != null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from turtles");

            List<Turtles> turtles = new ArrayList<>();
            Turtles t;
            while (rs.next()) {
                t = new Turtles();
                t.setId(rs.getInt("id"));
                t.setSpecie(rs.getString("specie"));
                t.setWight(rs.getDouble("wight"));
                t.setLength(rs.getDouble("length"));
                t.setNumberOfWorkingFlippers(rs.getInt("number_of_working_flippers"));
                t.setDateTimeOfSample(rs.getTimestamp("date_time_of_sample").toLocalDateTime());
                t.setLocation(rs.getString("location"));
                turtles.add(t);
            }


            con.close();
            return turtles;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void addNewRecord(Turtles turtle) {
        try {
            Connection con = connectToDB();
            assert con != null;
            PreparedStatement preparedStmt = con.prepareStatement("insert into turtles values (null ,'" + turtle.getSpecie() + "' , '" + turtle.getWight() + "' , '" + turtle.getLength() + "' , '" + turtle.getNumberOfWorkingFlippers() + "' , '" + turtle.getDateTimeOfSample() + "' , '" + turtle.getLocation() + "')");
            preparedStmt.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateRecord(List<Turtles> turtles) {
        if (turtles.isEmpty()) {
            System.out.println("There Is No Records !!\n" + "*************************************************************");
        } else {
            System.out.println(turtles);
            System.out.println("\nPlease Enter ID Of The Record You Want To Edit: ");
            int i = s.nextInt();
            Turtles turtle = findTurtle(i);
            if (turtle != null) {
                try {
                    Connection con = connectToDB();
                    assert con != null;
                    PreparedStatement stmt;


                    while (true) {
                        System.out.println(turtle);
                        System.out.println("\n ************************************************************* \nPlease Chose A Field To Edit:\n" + "----------------------------------------------------------------");
                        System.out.println("1. Specie                       2. Wight ");
                        System.out.println("3. Length                       4. Number Of Working Flippers");
                        System.out.println("5. DateTime Of Sampling event   6. Location Of Sampling event");
                        final String e = s.next();
                        switch (e) {
                            case "1":
                                System.out.println("The Old Value Was :: " + turtle.getSpecie());
                                System.out.println("Please Chose The New Value ::");
                                boolean check;
                                do {

                                    check = true;
                                    System.out.println("Please Chose The Specie: ");
                                    System.out.println("1. FlatBack                 2. Green ");
                                    System.out.println("3. HawksBill                4. KempsRidley");
                                    System.out.println("5. LeatherBack              6. LoggerHead");
                                    System.out.println("7. OliveRidley");

                                    String specie = s.next();
                                    switch (specie) {
                                        case "1":
                                            turtle.setSpecie("FlatBack");
                                            stmt = con.prepareStatement("update turtles set specie='FlatBack' where id = ?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        case "2":
                                            turtle.setSpecie("Green");
                                            stmt = con.prepareStatement("update turtles set specie='Green' where id = ?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        case "3":
                                            turtle.setSpecie("HawksBill");
                                            stmt = con.prepareStatement("update turtles set specie='HawksBill' where id =?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        case "4":
                                            turtle.setSpecie("KempsRidley");
                                            stmt = con.prepareStatement("update turtles set specie='KempsRidley' where id =?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        case "5":
                                            turtle.setSpecie("LeatherBack");
                                            stmt = con.prepareStatement("update turtles set specie='LeatherBack' where id =?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        case "6":
                                            turtle.setSpecie("LoggerHead");
                                            stmt = con.prepareStatement("update turtles set specie='LoggerHead' where id =?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        case "7":
                                            turtle.setSpecie("OliveRidley");
                                            stmt = con.prepareStatement("update turtles set specie='OliveRidley' where id =?");
                                            stmt.setInt(1, i);
                                            stmt.execute();
                                            break;

                                        default:
                                            System.out.println("Invalid input !!");
                                            check = false;
                                            break;
                                    }
                                } while (!check);
                                con.close();
                                System.out.println("*************************************************************");
                                break;
                            case "2":
                                System.out.println("The Old Value Was :: " + turtle.getWight());
                                System.out.println("Please Enter The New Value ::");
                                turtle.setWight(s.nextDouble());
                                stmt = con.prepareStatement("update turtles set wight=? where id =?");
                                stmt.setDouble(1, turtle.getWight());
                                stmt.setInt(2, i);
                                stmt.execute();
                                System.out.println("*************************************************************");
                                break;
                            case "3":
                                System.out.println("The Old Value Was :: " + turtle.getLength());
                                System.out.println("Please Enter The New Value ::");
                                turtle.setLength(s.nextDouble());
                                stmt = con.prepareStatement("update turtles set length=? where id =?");
                                stmt.setDouble(1, turtle.getLength());
                                stmt.setInt(2, i);
                                stmt.execute();
                                System.out.println("*************************************************************");
                                break;
                            case "4":
                                System.out.println("The Old Value Was :: " + turtle.getNumberOfWorkingFlippers());
                                System.out.println("Please Enter The New Value ::");
                                turtle.setNumberOfWorkingFlippers(s.nextInt());
                                stmt = con.prepareStatement("update turtles set number_of_working_flippers=? where id =?");
                                stmt.setDouble(1, turtle.getNumberOfWorkingFlippers());
                                stmt.setInt(2, i);
                                stmt.execute();
                                System.out.println("*************************************************************");
                                break;
                            case "5":
                                System.out.println("The Old Value Was :: " + turtle.getDateTimeOfSample());
                                turtle.setDateTimeOfSample(LocalDateTime.now());
                                stmt = con.prepareStatement("update turtles set date_time_of_sample=? where id =?");
                                stmt.setDate(1, (Date) Date.from(turtle.getDateTimeOfSample().atZone(ZoneId.systemDefault()).toInstant()));
                                stmt.setInt(2, i);
                                stmt.execute();
                                System.out.println("*************************************************************");
                                break;
                            case "6":
                                System.out.println("The Old Value Was :: " + turtle.getLocation());
                                System.out.println("Please Enter The New Value ::");
                                turtle.setLocation(s.next());
                                stmt = con.prepareStatement("update turtles set location=? where id =?");
                                stmt.setString(1, turtle.getLocation());
                                stmt.setInt(2, i);
                                stmt.execute();
                                System.out.println("*************************************************************");
                                break;
                            case "7":

                            default:
                                System.out.println("Invalid input !!");
                                break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else
                System.out.println("Record Not Found !!");
        }
    }

    public static void deleteRecord(int id) {
        try {
            Connection con = connectToDB();
            assert con != null;
            PreparedStatement stmt = con.prepareStatement("delete from turtles where id =?");
            stmt.setInt(1, id);
            stmt.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getRecordsReportByLocation(List<Turtles> turtles) {

        System.out.println("Please Enter location ");
        String location = s.next();

        turtles.stream().filter(s -> s.getLocation().equals(location)).collect(Collectors.toList()).forEach(System.out::println
        );
    }

    public static void getRecordsReportByDate(List <Turtles> turtles) {

        System.out.println("Please Enter First date");
        String d1 = s.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse(d1, formatter);
        System.out.println("Please Enter Second date");
        String d2 = s.next();
        LocalDateTime dateTime2 = LocalDateTime.parse(d2, formatter);


        turtles.stream().filter(s -> s.getDateTimeOfSample().isAfter(dateTime1)
                && s.getDateTimeOfSample().isBefore(dateTime2)).collect(Collectors.toList()).forEach(System.out::println
        );
    }

}

