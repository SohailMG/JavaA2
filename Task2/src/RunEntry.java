
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sohailgsais
 */
public class RunEntry {

    private int eventNumber;
    private Competitor competitor;
    private HashMap<Integer, Competitor[]> entries = new HashMap<>();

    public RunEntry(int eventNumber, Competitor competitor) {
        this.eventNumber = eventNumber;
        this.competitor = competitor;
//        this.entries = new HashMap<>();
//        entries.put(eventNumber, competitor);
    }

    public int getEventNum() {
        return eventNumber;

    }
//    public int getEntryCount(){
//        return competitor.length;
//    }

    public HashMap getEntries() {

        return entries;

    }

    @Override
    public String toString() {
        String obj
                = "Name      :  " + competitor.getName() + "\n"
                + "Age       :  " + competitor.getAge() + "\n"
                + "Entry Num :  " + getEventNum();

        return obj;

    }
}
