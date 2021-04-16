package MainApplication;

import CharityRuns.Coordinator;
import CharityRuns.presentation.Display;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Coordinator coord = new Coordinator();
        Display display = new Display(coord);
        Scanner selectedEvent = new Scanner(System.in);
        while (true) {
            try {
                int eventType = displayMenu();
                // displaying the selected option
                display.displaySelected(eventType);

                //displaying details of selected event
                if (eventType == 1 || eventType == 2) {
                    display.displaySelectedEvenet(selectedEvent.nextInt() - 1, eventType);
                } else if (eventType == 0) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("\n WARNING -  Invalid Selection  \n");
            }
        }
    }

    public static int displayMenu() {
        System.out.println("\tCHARITY RUNS");
        System.out.println("Half Marathon.........(1");
        System.out.println("Five Km Run...........(2");
        System.out.println("Show Park Events......(3");
        System.out.println("Show Town Events......(4");
        System.out.println("Search Competitor.....(5");
        System.out.println("Exit..................(0");
        System.out.println("........................");
        System.out.println("Select an Event   >");
        Scanner selection = new Scanner(System.in);
        return selection.nextInt();
    }

}
