package MainApplication;

import CharityRuns.Coordinator;
import CharityRuns.presentation.Display;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Coordinator coord = new Coordinator();
        Display display = new Display(coord);

        try {
            int eventType = displayMenu();
            display.displayUI(eventType);
            Scanner selectedEvent = new Scanner(System.in);
            System.out.println("Select an Event > ");
            int s = selectedEvent.nextInt();
            
            display.displaySelectedEvenet(s - 1, eventType);

        } catch (Exception e) {
        }
    }

    public static int displayMenu() {
        System.out.println("\tCHARITY RUNS");
        System.out.println("Half Marathon.........(1");
        System.out.println("Five Km Run...........(2");
        System.out.println("Show Venues...........(3");
        System.out.println("Exit..................(0");
        System.out.println("........................");
        System.out.println("Select an Event   >");
        Scanner selection = new Scanner(System.in);
        return selection.nextInt();
    }

}
