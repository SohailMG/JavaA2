/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohailgsais
 */
public class RunEntry {
    
    private int eventNumber;
    private Competitor[] competitor;
    
    public RunEntry(int eventNumber,Competitor[] competitor){
        this.eventNumber = eventNumber;
        this.competitor = competitor;
    }
    
    public int getEventNum(){
        return eventNumber;
                
    }
    public int getEntryCount(){
        return competitor.length;
    }
    
    @Override
    public String toString(){
        String obj=
                    "Entry Count :" ;
        
        return obj;
        
    }
}
