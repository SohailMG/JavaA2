/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns;

import CharityRuns.DataLoader.DAO;
import CharityRuns.DataLoader.DataLoader;
import CharityRuns.FiveKRuns.FiveKmRun;
import CharityRuns.HalfMarathonRuns.HalfMarathon;
import java.util.ArrayList;

/**
 *
 * @author sohailgsais
 */
public class Coordinator {

    private DAO dao;

    public Coordinator() {

         dao = new DataLoader();
    }
    
    public ArrayList<FiveKmRun> getFiveKRuns(){
        return dao.getFiveKRuns();
    }
    public ArrayList<HalfMarathon> getHalfMarathonRuns(){
        return dao.getHalfMarathonRuns();
    }
    public ArrayList<RunEntry> getComps(){
        return dao.getComps();
    }
    public ArrayList<CharityRun> getAllRuns(){
        return dao.getAllRuns();
    }

}
