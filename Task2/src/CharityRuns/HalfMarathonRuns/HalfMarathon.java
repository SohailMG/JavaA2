package CharityRuns.HalfMarathonRuns;



import CharityRuns.CharityRun;
import CharityRuns.Place;
import CharityRuns.RunEntry;
import CharityRuns.Venues.Park;
import CharityRuns.Venues.Town;
import CharityRuns.Venues.Venue;
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

    /**
     * constructor for half marathon runs taking place at a park
     * @param date date of the event
     * @param startTime start time of the event
     * @param numOfWaterStations integer
     * @param changingFacilities integer
     * @param place enumerator of place either 
     * @param venueName string name of the venue
     * @param entry entry for the event
     */
    public HalfMarathon(String date, String startTime, int numOfWaterStations,int changingFacilities, Place place, String venueName,RunEntry entry) {
        super(date, startTime,entry);
        this.numOfWaterStations = numOfWaterStations;        
        this.place = place;        
        venue = new Park(venueName, changingFacilities) {
            @Override
            public void place(Place place) {
                this.place = place;

            }
        };
    }
    /**
     * constructor for half m runs taking place at a town
     * @param date
     * @param startTime
     * @param numOfWaterStations
     * @param place
     * @param venueName
     * @param entry 
     */
    public HalfMarathon(String date, String startTime, int numOfWaterStations, Place place, String venueName,RunEntry entry) {
        super(date, startTime,entry);
        this.numOfWaterStations = numOfWaterStations;
        this.place = place;
        
        venue = new Town(venueName) {
            @Override
            public void place(Place place) {
                this.place = place;

            }
        };
    }
    
    // GETTERS
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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String eventData = String.format("%2s %2s %-10s %2s %-6s %2s  %3s", "Half Marathon","|",super.getDate(), "|", super.getStartTime(),"|",getPlace());

        sb.append(eventData);
        return sb.toString();
    }

}
