
/**
 *
 * @author sohailgsais
 */
public class HalfMarathon extends CharityRun{
    
    private int numOfWaterStations;
    
    public HalfMarathon(String date, String startTime,int numOfWaterStations) {
        super(date, startTime);
        this.numOfWaterStations = numOfWaterStations;
    }
    
    public int getNumOfWaterStations(){
        return numOfWaterStations;
    }
    
    @Override
    public String toString(){
        String obj = "Half Marathon \nDate - " +  super.getDate() +"\n" + "Time - " +  super.getStartTime() +"\n" + "Water Stations : " + getNumOfWaterStations();
        
        return obj;
    }
    
}
