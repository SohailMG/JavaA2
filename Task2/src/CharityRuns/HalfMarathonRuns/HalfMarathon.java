package CharityRuns.HalfMarathonRuns;


import java.util.ArrayList;
//import CharityRuns.FiveKRuns.
import CharityRuns.CharityRun;
import CharityRuns.Competitor;
import CharityRuns.Place;
import CharityRuns.RunEntry;
import CharityRuns.Venues.Park;
import CharityRuns.Venues.Town;
import CharityRuns.Venues.Venue;
import java.util.HashMap;
/**
 *
 * @author sohailgsais
 */
public class HalfMarathon extends CharityRun {

    private int numOfWaterStations;
    private Park park;
    private Town town;
    private Place place;
    private Venue venue;
    private int entryCount;
    private final int MIN_AGE;

    public HalfMarathon(String date, String startTime, int numOfWaterStations,int changingFacilities, Place place, String venueName,RunEntry entry) {
        super(date, startTime,entry);
        this.numOfWaterStations = numOfWaterStations;        
        this.place = place;
//        this.entryCount = entry.size();
        MIN_AGE = 16;
        venue = new Park(venueName, changingFacilities) {
            @Override
            public void place(Place place) {
                this.place = place;

            }
        };
    }

    public HalfMarathon(String date, String startTime, int numOfWaterStations, Place place, String venueName,RunEntry entry) {
        super(date, startTime,entry);
        this.numOfWaterStations = numOfWaterStations;
        this.place = place;
        MIN_AGE = 16;
        venue = new Town(venueName) {
            @Override
            public void place(Place place) {
                this.place = place;

            }
        };
    }

    public int getNumOfWaterStations() {
        return numOfWaterStations;
    }

    public Park getPark() {
        return park;
    }

    public Town getTown() {
        return town;
    }

    public void setPlace(Place place) {

        this.place = place;

    }

    public Place getPlace() {
        return place;
    }

    public Venue getVenue() {
        return venue;
    }

    public int getCount() {
        return entryCount;
    }
    public HashMap<Integer, Competitor> getCompName(){
        return super.getEntries();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String eventData = String.format("%2s %2s %-10s %2s %-6s %2s  %3s", "Half Marathon","|",super.getDate(), "|", super.getStartTime(),"|",getPlace());

        sb.append(eventData);
        return sb.toString();
    }

}
