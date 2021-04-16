package CharityRuns;


import java.util.HashMap;

/**
 * run entry containing the event number as well
 * as a competitor object
 * @author sohailgsais
 */
public class RunEntry {

    private int eventNumber;
    private Competitor competitor;
    private HashMap<Integer, Competitor> entries = new HashMap<>();

    public RunEntry(int eventNumber, Competitor competitor) {
        this.eventNumber = eventNumber;
        this.competitor = competitor;
        entries.put(eventNumber, competitor);
    }

    public int getEventNum() {
        return eventNumber;

    }
    public Competitor getCompetitor(){
        return competitor;
    }

    public HashMap<Integer, Competitor> getEntries() {

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
