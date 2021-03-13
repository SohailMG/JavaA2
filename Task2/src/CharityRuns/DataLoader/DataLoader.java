package CharityRuns.DataLoader;


import CharityRuns.Competitor;
import CharityRuns.FiveKRuns.FiveKmRun;
import CharityRuns.HalfMarathonRuns.HalfMarathon;
import CharityRuns.Place;
import CharityRuns.RunEntry;
import CharityRuns.Venues.Park;
import CharityRuns.Venues.Town;
import CharityRuns.myDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohailgsais
 */
public class DataLoader implements DAO{
    
   HalfMarathon halfMarathon;
   FiveKmRun fiveKRun;
   ArrayList<FiveKmRun> fiveKruns;
   ArrayList<HalfMarathon> halfMarathonRuns;
   Place place;
   Park park;
   Town town;
   
   public DataLoader(){
       fiveKruns = new ArrayList<>();
       halfMarathonRuns = new  ArrayList<>();
       load();
       
   }
   @Override
   public void load(){
         String[][] event1 = {{"John", "20"}, {"Smith", "30"}};
         String[][] event2 = {{"Sam", "20"}, {"Holy", "30"}, {"Sarah", "30"}};
         ArrayList<RunEntry> comps = new ArrayList<>();      
         
         
         addCompetitors(event1, comps); 
         halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 7, 9).getDate(),new myDate(14, 30).getTime(), 10, park, Place.PARK, " Hyde Park", comps));
         
         
         comps.clear();
         addCompetitors(event2, comps);      
         fiveKruns.add(new FiveKmRun(new myDate(2021, 8, 31).getDate(), new myDate(17, 55).getTime(), new Park("Alexandra", 3), comps));
   
       
       
   }

    public void addCompetitors(String[][] comp, ArrayList<RunEntry> comps) throws NumberFormatException {
        for (String[] comp1 : comp) {
            String[] split = Arrays.toString(comp1).replaceAll("\\[|\\]", "").split(",");
            
            Random random = new Random();
            int ran =  random.nextInt(100 - 10) + 10;
            comps.add(new RunEntry(ran, (new Competitor(split[0], Integer.parseInt(split[1].trim())))));
            
        }
    }
   @Override
   public ArrayList<FiveKmRun> getFiveKRuns(){
       return fiveKruns;
   }
   @Override
   public ArrayList<HalfMarathon> getHalfMarathonRuns(){
       return halfMarathonRuns;
   }
    
}
