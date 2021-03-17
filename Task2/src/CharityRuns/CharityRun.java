package CharityRuns;


import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * HAS: DATE - TIME 
 * @author sohailgsais
 */
public abstract class CharityRun {
    
    private String date;
    private String startTime;
    private ArrayList<RunEntry> entry;
    private ArrayList<CharityRun> charityRuns;
    private RunEntry entries;
    private int entryCount;
    
    public CharityRun(String date,String startTime,ArrayList<RunEntry> entry){
        this.date = date;
        this.startTime = startTime;
        this.entryCount = entry.size();
        
    }
    public ArrayList<CharityRun> getCharityRuns(){
        
        return charityRuns;
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
    public HashMap<Integer, Competitor> getEntries(){
        return entries.getEntries();
    }
    
    
    
    
    
}
