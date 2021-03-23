package CharityRuns.DataLoader;

import CharityRuns.Competitor;
import CharityRuns.CharityRun;
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
    CharityRun charityRun;
    
    ArrayList<FiveKmRun> fiveKruns;
    ArrayList<HalfMarathon> halfMarathonRuns;
    ArrayList<CharityRuns.CharityRun> runs ;
    ArrayList<RunEntry> comps;
    Place place;
    Park park;
    Town town;

    public DataLoader() {
        fiveKruns = new ArrayList<>();
        halfMarathonRuns = new ArrayList<>();
        runs = new ArrayList<>();
        load();

    }

    @Override
    public void load() {

        RunEntry entry1 = new RunEntry(1221, new Competitor("James", 20, "HalfMarathon", "Alexandra"));
        RunEntry entry2 = new RunEntry(1231, new Competitor("Jane", 18, "HalfMarathon", "Hyde Park"));
        RunEntry entry3 = new RunEntry(1241, new Competitor("Sarah", 22, "Five K", "Kings Park"));
        RunEntry entry4 = new RunEntry(1261, new Competitor("Jane", 19, "Five K", "Sandy Shores"));
        RunEntry entry5 = new RunEntry(1211, new Competitor("Jordan", 24, "Five K", "Hyde Park"));

        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 7, 9).getDate(), new myDate(14, 30).getTime(), 10, 30, Place.PARK, " Hyde Park", entry1));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 10, 3).getDate(), new myDate(13, 40).getTime(), 9, 14, Place.PARK, " Kings Park", entry2 ));

        fiveKruns.add(new FiveKmRun(new myDate(2021, 8, 31).getDate(), new myDate(17, 55).getTime(), new Park("Alexandra", 3), entry4));
        fiveKruns.add(new FiveKmRun(new myDate(2021, 4, 4).getDate(), new myDate(14, 55).getTime(), new Park("Sandy Shore", 20), entry5));
        
        fiveKruns.forEach((fiveKrun) -> {
            runs.add(fiveKrun);
        });
        halfMarathonRuns.forEach((halfM) -> {
            runs.add(halfM);
        });
    }
    

    @Override
    public ArrayList<FiveKmRun> getFiveKRuns() {
        return fiveKruns;
    }

    @Override
    public ArrayList<HalfMarathon> getHalfMarathonRuns() {
        return halfMarathonRuns;
    }
    @Override
    public ArrayList<CharityRun> getAllRuns() {
        return runs;
    }

    @Override
    public ArrayList<RunEntry> getComps() {
        return comps;
    }

}
