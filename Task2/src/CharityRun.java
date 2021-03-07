
/**
 *
 * @author sohailgsais
 */
public abstract class CharityRun {
    
    private myDate date;
    private myDate startTime;
    
    public CharityRun(myDate date,myDate startTime){
        this.date = date;
        this.startTime = startTime;
    }
    
    public myDate getDate(){
        return date;
    }
    public myDate getStartTime(){
        return startTime;
    }
    
}
