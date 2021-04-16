/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns.presentation;

import CharityRuns.Coordinator;
import CharityRuns.RunEntry;
import CharityRuns.CharityRun;
import CharityRuns.FiveKRuns.FiveKmRun;
import CharityRuns.HalfMarathonRuns.HalfMarathon;
import CharityRuns.Place;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sohailgsais
 */
public class Display {

    private Coordinator coord;
    private RunEntry r;
    private CharityRun runs;
    final String FIVEK = "Five K";
    final String HALFM = "HalfMarathon";

    public Display(Coordinator coord) {

        this.coord = coord;

    }

    public void displaySelected(int selection) {

        switch (selection) {

            case 1:
                displayAllHalfMarathonRuns();

                break;
            case 2:
                displayAllFiveKmRuns();
                break;
            case 3:
                listVenuEvents(selection);
                break;
            case 4:
                listVenuEvents(selection);
                break;
            case 5:
                displaySearches();
                break;
            default:
                break ;

        }

    }

    public void displaySearches() {
        Scanner searchStr = new Scanner(System.in);
        System.out.print("Enter Competitor Name > ");
        String search = searchStr.nextLine().toLowerCase();
        System.out.println("\n\tSearches Found\n");
        coord.getAllRuns().forEach((event) -> {
            RunEntry entry = event.getRunEntries();
            String compName = entry.getCompetitor().getName().toLowerCase();
            if (compName.contains(search)) {

                System.out.println("+-------------+-----------------------");
                System.out.println("| Competitor  : " + entry.getCompetitor().getName());
                System.out.println("| Event Date  : " + event.getDate());
                System.out.println("| Event Num   : " + entry.getEventNum());
                System.out.println("| Event Type  : " + entry.getCompetitor().getEventType());
                System.out.println("+-------------+-----------------------");

            }

        });
    }

    public void listVenuEvents(int v) {
        
        try {

            switch (v) {
                case 3:
                    System.out.println("\nList of all events taking place at a Park\n");
                    listAllVenuEvents(Place.PARK);
                    break;
                case 4:
                    System.out.println("\nList of all events taking place at a Town\n");
                    listAllVenuEvents(Place.TOWN);
                    break;
                default:
                    System.out.println("\nInvalid - choose 3 or 4 \n");
                    break;
            }
        } catch (Exception e) {
            System.out.println("\nSelection must be a Number - 1 or 2 \n");
        }

    }

    public void displayAllHalfMarathonRuns() {
        System.out.println("---+---------------+-------------+---------+--------");
        System.out.println(String.format("%2s %10s %2s %8s %2s %4s %2s ", "No |Event", "|", "Date", "|", "Time", "|", "Place"));
        System.out.println("---+---------------+-------------+---------+--------");
        for (int i = 0; i < coord.getHalfMarathonRuns().size(); i++) {
            System.out.println((i + 1) + "  |" + coord.getHalfMarathonRuns().get(i));

        }
        System.out.println("---+---------------+-------------+---------+--------");
    }

    public void displayAllFiveKmRuns() {
        System.out.println("---+---------------+-------------+---------+--------");
        System.out.println(String.format("%2s %10s %2s %8s %2s %4s %2s ", "No |Event", "|", "Date", "|", "Time", "|", "Place"));
        System.out.println("---+---------------+-------------+---------+--------");
        for (int i = 0; i < coord.getFiveKRuns().size(); i++) {
            System.out.println((i + 1) + "  |" + coord.getFiveKRuns().get(i));
        }
        System.out.println("---+---------------+-------------+---------+--------");
    }

    /**
     * list all events with their details in accordance
     * to the given place, either park or town
     * @param place enum of place 
     */
    public void listAllVenuEvents(Place place) {
        if (coord.getHalfMarathonRuns().isEmpty() && coord.getFiveKRuns().isEmpty()) {
            System.out.println("\nThere are no event");
        // listing all events taking place at a park
        } else if (place == Place.PARK) {

            {
                for (int i = 0; i < coord.getFiveKRuns().size(); i++) {
                    FiveKmRun fivekRun = coord.getFiveKRuns().get(i);
                    System.out.println("+-----------------[Five Km ]-------------------");
                    System.out.println("|Venue               : " + fivekRun.getPark().getName());
                    System.out.println("|Changing Facilities : " + fivekRun.getPark().getNumChangingFacilites());
                    System.out.println("|Start Time          : " + fivekRun.getStartTime());
                    System.out.println("|Event Date          : " + fivekRun.getDate());
                    System.out.println("+----------------------------------------------");
                }
                for (int i = 0; i < coord.getHalfMarathonRuns().size(); i++) {
                    HalfMarathon halfMRun = coord.getHalfMarathonRuns().get(i);
                    if (halfMRun.getPlace() == Place.PARK) {

                        System.out.println("+---------------[Half Marathon]----------------");
                        System.out.println("|Venu                : " + halfMRun.getVenue());
                        System.out.println("|Start Time          : " + halfMRun.getStartTime());
                        System.out.println("|Event Date          : " + halfMRun.getDate());
                        System.out.println("|Water Stations      : " + halfMRun.getNumOfWaterStations());
                        System.out.println("+--------------------+-------------------------");
                    }
                }

            }
            // listing all events taking place at a town
        } else {
            for (int i = 0; i < coord.getHalfMarathonRuns().size(); i++) {
                HalfMarathon halfMRun = coord.getHalfMarathonRuns().get(i);
                if (halfMRun.getPlace() == Place.TOWN) {

                    System.out.println("---------------[Half Marathon]----------------");
                    System.out.println("Venu                :" + halfMRun.getVenue());
                    System.out.println("Start Time          : " + halfMRun.getStartTime());
                    System.out.println("Event Date          : " + halfMRun.getDate());
                    System.out.println("Water Stations      : " + halfMRun.getNumOfWaterStations());
                    System.out.println("----------------------------------------------");
                }
            }

        }
    }
    /**
     * displays details of a selected event from a list
     * if the event is a half marathon then it will display the number 
     * of water stations. if the event is five km run then it will
     * display the number of changing facilities
     * @param eventNum index number of the event
     * @param runType type of event either five k or half m
     */
    public void displaySelectedEvenet(int eventNum, int runType) {

        if (runType == 1) {
            HalfMarathon halfMRun = coord.getHalfMarathonRuns().get(eventNum);

            System.out.println("+-------------------------------------------");
            System.out.println("|Venue               :" + halfMRun.getVenue());
            System.out.println("|Entry Count         : " + getEntryCount(halfMRun.getVenue().getName(), HALFM));
            System.out.println("|Water Stations      : " + halfMRun.getNumOfWaterStations());
            System.out.println("+-------------------------------------------");

        } else if (runType == 2) {
            FiveKmRun fiveKmRun = coord.getFiveKRuns().get(eventNum);
            System.out.println("+-------------------------------------------");
            System.out.println("|Venue               : " + fiveKmRun.getPark().getName());
            System.out.println("|Entry Count         : " + getEntryCount(fiveKmRun.getPark().getName(), FIVEK));
            System.out.println("|Changing Facilities : " + fiveKmRun.getPark().getNumChangingFacilites());
            System.out.println("+-------------------------------------------");

        }

    }
    /**
     * takes a venue name and event type and loops though 
     * an array of entries and compares venue's name with
     * selected event's name. increments the counter each
     * iteration where entries match the selected event
     * @param venuName name of venue selected
     * @param eventType type of the event selected
     * @return number of entries for the given event
     */
    public int getEntryCount(String venuName, String eventType) {
        int counter = 0;
        for (int i = 0; i < coord.getAllRuns().size(); i++) {
            String eventName = coord.getAllRuns().get(i).getRunEntries().getCompetitor().geteventName();
            String type = coord.getAllRuns().get(i).getRunEntries().getCompetitor().getEventType();

            if (venuName.contains(eventName) && type.contains(eventType)) {
                counter++;

            }

        }
        return counter;
    }

}
