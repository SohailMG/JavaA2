
/**
 *
 * @author sohailgsais
 */
public abstract class CharityRun {
    
    private String date;
    private String startTime;
    private RunEntry entry;
    
    public CharityRun(String date,String startTime){
        this.date = date;
        this.startTime = startTime;
    }
    
    
    
    public String getDate(){
        return date;
    }
    public String getStartTime(){
        return startTime;
    }
    
    
    
}
