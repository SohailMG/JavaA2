
import java.util.ArrayList;



/**
 *
 * @author sohailgsais
 */
public class FiveKmRun extends CharityRun{
    
    Park park;
    public FiveKmRun(String date, String startTime,Park park,ArrayList<RunEntry> entry) {
        super(date, startTime,entry);
        this.park = park;
    }
   
    public Park getPark(){
        return park;
    }
    @Override
    public String toString(){
       String obj = "FIVE k \nDate - " 
               +  super.getDate() +"\n" 
               + "Time - " +  super.getStartTime() 
               + "\n" + "Park :"+  getPark() ;
       
       
       return obj;
       
   }
    
    
    
}
