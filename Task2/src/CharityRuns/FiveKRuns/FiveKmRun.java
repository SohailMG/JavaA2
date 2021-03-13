/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns.FiveKRuns;

import java.util.ArrayList;
import CharityRuns.CharityRun;
import CharityRuns.RunEntry;
import CharityRuns.Venues.Park;

/**
 *
 * @author sohailgsais
 */
public class FiveKmRun extends CharityRun{
    
    Park park;
    
    
    public FiveKmRun(String date, String startTime,Park park,ArrayList<RunEntry> entry) {
        super(date, startTime,entry);
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
               + "\n" + "Park : "+  getPark() + "\n"
               + "Entry Count : " + super.getEntryCount()
               
               ;
       
       
       return obj;
       
   }
    
    
    
}
