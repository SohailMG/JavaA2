package CharityRuns;


import java.util.ArrayList;
import java.util.HashMap;


/**
 * Top level base class 
 * 
 * @author sohailgsais
 */
public abstract class CharityRun {
    
    private String date;
    private String startTime;
    private RunEntry entry;
    
    private ArrayList<CharityRun> charityRuns;
    private int entryCount;
    
    // delcaring charity run constructor
    public CharityRun(String date,String startTime,RunEntry entry){
        this.date = date;
        this.startTime = startTime;
        this.entry = entry;
        
        
    }
    // getters
    public ArrayList<CharityRun> getCharityRuns(){
        
        return charityRuns;
    }
    public RunEntry getRunEntries(){
        return entry;
    }
    
    public String getDate(){
        return date;
    }
    public String getStartTime(){
        return startTime;
    }
    public int getEntryCount(){
        return entryCount;
    }
    
    
    
    
}
