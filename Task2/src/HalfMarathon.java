
/**
 *
 * @author sohailgsais
 */
public class HalfMarathon extends CharityRun{
    
    private int numOfWaterStations;
    private Park park;
    private Town town;
    private Place place;
    
    
    public HalfMarathon(String date, String startTime,int numOfWaterStations,Park park,Place place) {
        super(date, startTime);
        this.numOfWaterStations = numOfWaterStations;
        this.park = park;
        this.place = place;
    }
    public HalfMarathon(String date, String startTime,int numOfWaterStations,Town town,Place place) {
        super(date, startTime);
        this.numOfWaterStations = numOfWaterStations;
        this.town = town;
        this.place = place;
    }
    
    public int getNumOfWaterStations(){
        return numOfWaterStations;
    }
    public Park getPark(){
        return park;
    }
    public Town getTown(){
        return town;
    }
    public void setPlace(Place place){
        
        this.place = place;
        
    }
    public Place getPlace(){
        return place;
    }
    
    @Override
    public String toString(){
        
        String obj = "";
        if(getPlace() == Place.PARK){
            
         obj = "Half Marathon \nDate - " 
                +  super.getDate() +"\n" + "Time - " 
                +  super.getStartTime() +"\n" 
                + "Water Stations : " + getNumOfWaterStations() + "\n"
                + "Place : " + getPark();
        }else if(getPlace() == Place.TOWN){
         obj = "Half Marathon \nDate - " 
                +  super.getDate() +"\n" + "Time - " 
                +  super.getStartTime() +"\n" 
                + "Water Stations : " + getNumOfWaterStations() + "\n"
                + getTown();
            
        }
        
        
        return obj;
    }
    
    
}
