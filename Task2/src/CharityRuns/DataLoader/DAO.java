
package CharityRuns.DataLoader;


import CharityRuns.CharityRun;
import CharityRuns.FiveKRuns.FiveKmRun;
import CharityRuns.HalfMarathonRuns.HalfMarathon;
import CharityRuns.RunEntry;
import java.util.ArrayList;

/**
 * 
 * @author sohailgsais
 */
public interface DAO {
     public void load();
     public ArrayList<FiveKmRun> getFiveKRuns();
     public ArrayList<HalfMarathon> getHalfMarathonRuns();
     public ArrayList<RunEntry> getComps();
     public ArrayList<CharityRun> getAllRuns();
    
}
