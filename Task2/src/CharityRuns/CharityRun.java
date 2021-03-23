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
    private RunEntry entry;
    
    private ArrayList<CharityRun> charityRuns;
    private RunEntry entries;
    private int entryCount;
    private HashMap<Integer, CharityRun> comps = new HashMap<>();
    
    public CharityRun(String date,String startTime,RunEntry entry){
        this.date = date;
        this.startTime = startTime;
        this.entry = entry;
//        this.entryCount = entry.size();
//        this.entry = entry;
        
        
    }
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
    public HashMap<Integer, Competitor> getEntries(){
        return entries.getEntries();
    }
    public HashMap<Integer, CharityRun> getRuns(){
        return comps;
    }
    
    
    
    
    
}
