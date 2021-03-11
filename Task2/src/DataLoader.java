
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
public class DataLoader {
    
   HalfMarathon halfMarathon;
   FiveKmRun fiveKRun;
   ArrayList<FiveKmRun> fiveKruns;
   ArrayList<HalfMarathon> halfMarathonRuns;
   Place place;
   Park park;
   Town town;
   
   DataLoader(){
       fiveKruns = new ArrayList<>();
       halfMarathonRuns = new  ArrayList<>();
       load();
       
   }
   
   private void load(){
         String[][] comp = {{"John", "20"}, {"Smith", "30"}};
         ArrayList<RunEntry> comps = new ArrayList<>();

        

        for (String[] comp1 : comp) {
            String[] split = Arrays.toString(comp1).replaceAll("\\[|\\]", "").split(",");
            
            Random random = new Random();
            int ran =  random.nextInt(100 - 10) + 10;
            comps.add(new RunEntry(ran, (new Competitor(split[0], Integer.parseInt(split[1].trim())))));
            

        }
        for (RunEntry comp1 : comps) {
            System.out.println(comp1);

        }
       
       fiveKruns.add(
               new FiveKmRun(new myDate(2021, 10, 2).getDate(), 
               new myDate(10, 30).getTime(),new Park(" Regens Park", 22), comps));
       
       halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 7, 9).getDate(), 
                            new myDate(14, 30).getTime(), 10, park, Place.PARK, " Hyde Park", comps));
//       halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 10, 22).getDate(), 
//                            new myDate(12, 00).getTime(), 10, town, Place.TOWN, "London"));    
       
       
   }
   public ArrayList<FiveKmRun> getFiveKRuns(){
       return fiveKruns;
   }
   public ArrayList<HalfMarathon> getHalfMarathonRuns(){
       return halfMarathonRuns;
   }
    
}
