
import java.util.ArrayList;

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

    public HalfMarathon(String date, String startTime, int numOfWaterStations, Park park, Place place, String venueName, ArrayList<RunEntry> entry) {
        super(date, startTime, entry);
        this.numOfWaterStations = numOfWaterStations;
        this.park = park;
        this.place = place;
        this.entryCount = entry.size();
        MIN_AGE = 16;
        venue = new Park(venueName, numOfWaterStations) {
            @Override
            public void place(Place place) {
                this.place = place;

            }
        };
    }

    public HalfMarathon(String date, String startTime, int numOfWaterStations, Town town, Place place, String venueName, ArrayList<RunEntry> entry) {
        super(date, startTime, entry);
        this.numOfWaterStations = numOfWaterStations;
        this.town = town;
        this.place = place;
        this.entryCount = entry.size();
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

    @Override
    public String toString() {

        String obj = "";

        if (getPlace() == Place.PARK) {

            obj = "Half Marathon \nDate - "
                    + super.getDate() + "\n" + "Time - "
                    + super.getStartTime() + "\n"
                    + "Water Stations : " + getNumOfWaterStations() + "\n"
                    + getPlace() + " :" + getVenue()
                    + "Count : " + getCount();
        } else if (getPlace() == Place.TOWN) {
            obj = "Half Marathon \nDate - "
                    + super.getDate() + "\n" + "Time - "
                    + super.getStartTime() + "\n"
                    + "Water Stations : " + getNumOfWaterStations() + "\n"
                    + getPlace() + " :" + getVenue()
                    + "Count : " + getCount();
        }

        return obj;
    }

}
