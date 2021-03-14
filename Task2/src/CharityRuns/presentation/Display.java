/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns.presentation;

import CharityRuns.Coordinator;
import CharityRuns.FiveKRuns.FiveKmRun;
import CharityRuns.HalfMarathonRuns.HalfMarathon;
import CharityRuns.Place;
import java.util.Scanner;

/**
 *
 * @author sohailgsais
 */
public class Display {

    private Coordinator coord;

    public Display(Coordinator coord) {

        this.coord = coord;

    }

    public void displayUI(int selection) {

        switch (selection) {

            case 1:
                System.out.println("---+---------------+-------------+---------+--------");
                System.out.println(String.format("%2s %10s %2s %8s %2s %4s %2s ", "No |Event", "|", "Date", "|", "Time", "|", "Place"));
                System.out.println("---+---------------+-------------+---------+--------");
                for (int i = 0; i < coord.getHalfMarathonRuns().size(); i++) {
                    System.out.println((i + 1) + "  |" + coord.getHalfMarathonRuns().get(i));

                }
                break;
            case 2:
                System.out.println("---+---------------+-------------+---------+--------");
                System.out.println(String.format("%2s %10s %2s %8s %2s %4s %2s ", "No |Event", "|", "Date", "|", "Time", "|", "Place"));
                System.out.println("---+---------------+-------------+---------+--------");
                for (int i = 0; i < coord.getFiveKRuns().size(); i++) {
                    System.out.println((i + 1) + "  |" + coord.getFiveKRuns().get(i));
                }
                break;
            case 3:
                System.out.println("List all events in:");
                System.out.println("PARK......(1");
                System.out.println("TOWN......(2");
                Scanner venu = new Scanner(System.in);
                int v = venu.nextInt();

                if (v == 1) {
                    if (coord.getHalfMarathonRuns().isEmpty() && coord.getFiveKRuns().isEmpty()) {
                        System.out.println("\nThere are no event");

                    } else {
                        for (int i = 0; i < coord.getFiveKRuns().size(); i++) {
                            FiveKmRun fivekRun = coord.getFiveKRuns().get(i);
                            System.out.println("---------------[FIVE Km RUN]------------------");
                            System.out.println("Venue               : " + fivekRun.getPark().getName());
                            System.out.println("Changing Facilities : " + fivekRun.getPark().getNumChangingFacilites());
                            System.out.println("Start Time          : " + fivekRun.getStartTime());
                            System.out.println("Event Date          : " + fivekRun.getDate());
                            System.out.println("----------------------------------------------");
                        }
                        for (int i = 0; i < coord.getHalfMarathonRuns().size(); i++) {
                            HalfMarathon halfMRun = coord.getHalfMarathonRuns().get(i);
                            if (halfMRun.getPlace() == Place.PARK) {

                                System.out.println("---------------[Half Marathon]----------------");
                                System.out.println("Venu                :" + halfMRun.getVenue());
                                System.out.println("Start Time          : " + halfMRun.getStartTime());
                                System.out.println("Event Date          : " + halfMRun.getDate());
                                System.out.println("Water Stations      : " + halfMRun.getNumOfWaterStations());
                                System.out.println("----------------------------------------------");
                            }

                        }
                    }

                } else {
                }
                break;
            default:
                System.out.println("Invalid");
                break;

        }

    }

    public void displaySelectedEvenet(int eventNum, int runType) {
        
        
        
        
        
        if (runType == 1) {
            HalfMarathon halfMRun = coord.getHalfMarathonRuns().get(eventNum);
            
            System.out.println("Venue               :" + halfMRun.getVenue());
            System.out.println("Entry Count         : " + halfMRun.getEntryCount());
            System.out.println("Water Stations      : " + halfMRun.getNumOfWaterStations());

        } else if (runType == 2) {
            FiveKmRun fiveKmRun = coord.getFiveKRuns().get(eventNum);
            System.out.println("Venue               : " + fiveKmRun.getPark().getName());
            System.out.println("Entry Count         : " + fiveKmRun.getEntryCount());
            System.out.println("Changing Facilities : " + fiveKmRun.getPark().getNumChangingFacilites());

        }

    }

}
