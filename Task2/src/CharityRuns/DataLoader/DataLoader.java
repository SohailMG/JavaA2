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
public class DataLoader implements DAO {

    HalfMarathon halfMarathon;
    FiveKmRun fiveKRun;
    ArrayList<FiveKmRun> fiveKruns;
    ArrayList<HalfMarathon> halfMarathonRuns;
    Place place;
    Park park;
    Town town;

    public DataLoader() {
        fiveKruns = new ArrayList<>();
        halfMarathonRuns = new ArrayList<>();
        load();

    }

    @Override
    public void load() {
        String[][] event1 = {{"John", "19", "HalfMarathon"}, {"Smith", "30", "HalfMarathon"}};
        String[][] event2 = {{"Sam", "20", "FiveKmRun"}, {"Holy", "19", "FiveKmRun"}, {"Sarah", "30", "FiveKmRun"}};
        ArrayList<RunEntry> comps = new ArrayList<>();

        addCompetitors(event1, comps);
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 7, 9).getDate(), new myDate(14, 30).getTime(), 10, 30, Place.PARK, " Hyde Park", comps));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 10, 3).getDate(), new myDate(13, 40).getTime(), 9, 14, Place.PARK, " Kings Park", comps));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 11, 10).getDate(), new myDate(12, 00).getTime(), 20, Place.TOWN, " Shordich", comps));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 9, 10).getDate(), new myDate(16, 30).getTime(), 12, Place.TOWN, " Ealing", comps));

        comps.clear();
        addCompetitors(event2, comps);
        fiveKruns.add(new FiveKmRun(new myDate(2021, 8, 31).getDate(), new myDate(17, 55).getTime(), new Park("Alexandra", 3), comps));
        fiveKruns.add(new FiveKmRun(new myDate(2021, 4, 4).getDate(), new myDate(14, 55).getTime(), new Park("Sandy Shore", 20), comps));

    }

    public void addCompetitors(String[][] comp, ArrayList<RunEntry> comps) {
        for (String[] comp1 : comp) {
            String[] split = Arrays.toString(comp1).replaceAll("\\[|\\]", "").split(",");

            Random random = new Random();
            int ran = random.nextInt(100 - 10) + 10;

            
            if (split[2].contains("HalfMarathon")) {

                if (Integer.parseInt(split[1].trim()) < 16) {
                    System.out.println("\nALERT! - [" + split[0] + "]" + " was denied entry to " + split[2] + " must be 16+ \n");
                } else {
                    comps.add(new RunEntry(ran, (new Competitor(split[0], Integer.parseInt(split[1].trim()), split[2]))));
                }

            } else {

                comps.add(new RunEntry(ran, (new Competitor(split[0], Integer.parseInt(split[1].trim()), split[2]))));
            }

        }
    }

    @Override
    public ArrayList<FiveKmRun> getFiveKRuns() {
        return fiveKruns;
    }

    @Override
    public ArrayList<HalfMarathon> getHalfMarathonRuns() {
        return halfMarathonRuns;
    }

}
