

/**
 *
 * @author sohailgsais
 */
public class FiveKmRun extends CharityRun{
    
    public FiveKmRun(String date, String startTime) {
        super(date, startTime);
    }
    
    @Override
    
    
   public String toString(){
       String obj = "FIVE k \nDate - " +  super.getDate() +"\n" + "Time - " +  super.getStartTime() ;
       
       
       return obj;
       
   }
    
    
    
}
