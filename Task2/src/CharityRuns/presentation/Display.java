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
    
    public void displayUI(int selection) {
        
        switch (selection) {
            
            case 1:
                displayAllHalfMarathonRuns();                
                
                break;
            case 2:
                displayAllFiveKmRuns();
                break;
            case 3:
                
                listVenuEvents();
                break;
            case 4:
                displaySearches();

                
                break;
            default:
                System.out.println("Invalid");
                break;
            
        }
        
    }

    public void displaySearches() {
        Scanner searchStr = new Scanner(System.in);
        System.out.print("Enter Competitor Name > ");
        String search = searchStr.nextLine().toLowerCase();
        
        coord.getAllRuns().forEach((event) -> {
            RunEntry entry = event.getRunEntries();
            String compName = entry.getCompetitor().getName().toLowerCase();
            if (compName.contains(search)) {
                
                System.out.println("\n\tSearches Found\n");
                System.out.println("Event Date  : " + event.getDate());
                System.out.println("Event Num   : " + entry.getEventNum());
                System.out.println("Event Type  : " + entry.getCompetitor().getEventType());
                
                
            }
            
        });
    }
    
    public void listVenuEvents() {
        System.out.println("List all events in:");
        System.out.println("PARK......(1");
        System.out.println("TOWN......(2");
        Scanner venu = new Scanner(System.in);
        int v = venu.nextInt();
        
        if (v == 1) {
            listAllVenuEvents(Place.PARK);
            
        } else if (v == 2) {
            listAllVenuEvents(Place.TOWN);
            
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
    
    public void listAllVenuEvents(Place place) {
        if (coord.getHalfMarathonRuns().isEmpty() && coord.getFiveKRuns().isEmpty()) {
            System.out.println("\nThere are no event");
            
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
                        System.out.println("|Venu                :" + halfMRun.getVenue());
                        System.out.println("|Start Time          : " + halfMRun.getStartTime());
                        System.out.println("|Event Date          : " + halfMRun.getDate());
                        System.out.println("|Water Stations      : " + halfMRun.getNumOfWaterStations());
                        System.out.println("+--------------------+-------------------------");
                    }
                }
                
            }
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
    
    public void displaySelectedEvenet(int eventNum, int runType) {
        
        if (runType == 1) {
            HalfMarathon halfMRun = coord.getHalfMarathonRuns().get(eventNum);
            
            System.out.println("+-------------------------------------------");
            System.out.println("|Venue               :" + halfMRun.getVenue());
            System.out.println("|Entry Count         : " + getEntryCount(halfMRun.getVenue().getName(),HALFM));
            System.out.println("|Water Stations      : " + halfMRun.getNumOfWaterStations());
            System.out.println("+-------------------------------------------");
            
        } else if (runType == 2) {
            FiveKmRun fiveKmRun = coord.getFiveKRuns().get(eventNum);
            System.out.println("+-------------------------------------------");
            System.out.println("|Venue               : " + fiveKmRun.getPark().getName());
            System.out.println("|Entry Count         : " + getEntryCount(fiveKmRun.getPark().getName(),FIVEK));
            System.out.println("|Changing Facilities : " + fiveKmRun.getPark().getNumChangingFacilites());
            System.out.println("+-------------------------------------------");
            
        }
        
    }
    public int getEntryCount(String venuName,String eventType){
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
