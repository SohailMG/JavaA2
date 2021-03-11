

/**
 *
 * @author sohailgsais
 */
public class FiveKmRun extends CharityRun{
    
    Park park;
    public FiveKmRun(String date, String startTime,Park park) {
        super(date, startTime);
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
               + "\n" +  getPark() ;
       
       
       return obj;
       
   }
    
    
    
}
