package CharityRuns.FiveKRuns;

import java.util.ArrayList;
import CharityRuns.CharityRun;
import CharityRuns.RunEntry;
import CharityRuns.Venues.Park;

/**
 *
 * @author sohailgsais
 */
public class FiveKmRun extends CharityRun {

    Park park;
    ArrayList<RunEntry> entry;

    /**
     * Constructor of Five k runs
     * @param date  date of runs
     * @param startTime start time of runs
     * @param park park object
     * @param entry entry object
     */
    public FiveKmRun(String date, String startTime, Park park, RunEntry entry) {
        super(date, startTime, entry);
        this.park = park;
    }
    /**
     * gets the park object of the specified run object
     * @return 
     */
    public Park getPark() {
        return park;
    }

    @Override
    public String toString() {

        String eventData = String.format("%2s %4s %-10s %2s %-6s %2s  %3s",
                "Five Km Run", "|", super.getDate(), "|", super.getStartTime(), "|", "PARK");

        return eventData;

    }

}
