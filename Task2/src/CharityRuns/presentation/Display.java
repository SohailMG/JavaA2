/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns.presentation;

import CharityRuns.Coordinator;

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
                    System.out.println(String.format("%2s %10s %2s %8s %2s %4s %2s %1s %3s %1s %3s", "No |Event","|","Date", "|", "Time", "|", "Water Stations", "|", "Entry Count","|","Place"));
                    System.out.println("---+---------------+-------------+---------+----------------+----------------------");
                for (int i = 0; i < coord.getHalfMarathonRuns().size(); i++) {
                    System.out.println((i + 1) + "  |" + coord.getHalfMarathonRuns().get(i));
                    
                }
                break;
            case 2:
                for (int i = 0; i < coord.getFiveKRuns().size(); i++) {
                    System.out.println(coord.getFiveKRuns().get(i));
                    System.out.println("");
                }
                break;
            default:
                System.out.println("Invalid");
                break;

        }

    }
    public void displaySelectedEvenet(int eventNum){
        
        System.out.println("Venue       : " + coord.getHalfMarathonRuns().get(eventNum).getVenue().getName());
        System.out.println("Entry Count : " + coord.getHalfMarathonRuns().get(eventNum).getEntryCount());
    }

}
