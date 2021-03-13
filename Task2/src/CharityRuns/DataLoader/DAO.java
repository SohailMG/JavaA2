/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns.DataLoader;


import CharityRuns.FiveKRuns.FiveKmRun;
import CharityRuns.HalfMarathonRuns.HalfMarathon;

import java.util.ArrayList;

/**
 *
 * @author sohailgsais
 */
public interface DAO {
     public void load();
     public ArrayList<FiveKmRun> getFiveKRuns();
     public ArrayList<HalfMarathon> getHalfMarathonRuns();
    
}
