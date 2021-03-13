package MainApplication;


import CharityRuns.Competitor;
import CharityRuns.Coordinator;
import CharityRuns.RunEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import CharityRuns.presentation.Display;


public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

    
        Coordinator coord = new Coordinator();
        Display display = new Display(coord);
        

//        try {          
            display.displayUI();       
//        } catch (Exception e) {
//        }
    }

}
