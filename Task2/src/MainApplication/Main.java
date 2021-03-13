package MainApplication;


import CharityRuns.Coordinator;
import CharityRuns.presentation.Display;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {

    
        
        Coordinator coord = new Coordinator();
        Display display = new Display(coord);    

        try { 
            int displayMenu = displayMenu();
            display.displayUI(displayMenu); 
            Scanner selectedEvent = new Scanner(System.in);
            display.displaySelectedEvenet(selectedEvent.nextInt() - 1);
            
        } catch (Exception e) {
        }
    }
    
    public static  int displayMenu(){
        System.out.println("......CHARITY RUNS......");
        System.out.println("Five Km Run...........(1");
        System.out.println("Half Marathon.........(1");
        System.out.println("........................");
        System.out.println("Select an Event   >");
        Scanner selection = new Scanner(System.in);
        return selection.nextInt();
    }

}
