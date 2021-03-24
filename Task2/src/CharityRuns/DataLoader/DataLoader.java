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
    ArrayList<CharityRuns.CharityRun> runs;
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

        RunEntry entry1 = new RunEntry(1221, new Competitor("James", 20, "C", "Alexandra"));
        RunEntry entry2 = new RunEntry(1221, new Competitor("Jane", 14, "HalfMarathon", "Hyde Park"));
        RunEntry entry3 = new RunEntry(1241, new Competitor("Sarah", 22, "HalfMarathon", "London"));
        RunEntry entry4 = new RunEntry(1261, new Competitor("Jane", 19, "Five K", "Hyde Park"));
        RunEntry entry5 = new RunEntry(1211, new Competitor("Jordan", 24, "Five K", "Hyde Park"));

        RunEntry[] entries = {entry1, entry2, entry3, entry4, entry5,};
        
        
        validateEntries(entries);
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 7, 9).getDate(), new myDate(14, 30).getTime(), 10, 30, Place.PARK, entry1.getCompetitor().geteventName(), entry1));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 10, 3).getDate(), new myDate(13, 40).getTime(), 9, 14, Place.PARK, entry2.getCompetitor().geteventName(), entry2));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 10, 3).getDate(), new myDate(13, 40).getTime(), 9, 14, Place.TOWN, entry3.getCompetitor().geteventName(), entry3));

        fiveKruns.add(new FiveKmRun(new myDate(2021, 8, 31).getDate(), new myDate(17, 55).getTime(), new Park(entry4.getCompetitor().geteventName(), 3), entry4));
        fiveKruns.add(new FiveKmRun(new myDate(2021, 4, 4).getDate(), new myDate(14, 55).getTime(), new Park(entry5.getCompetitor().geteventName(), 20), entry5));

        fiveKruns.forEach((fiveKrun) -> {
            runs.add(fiveKrun);
        });
        halfMarathonRuns.forEach((halfM) -> {
            runs.add(halfM);
        });
    }

    public void validateEntries(RunEntry[] entries) {
            System.out.println("\n---------------------DENIED ENTRY---------------------------");
        int dublicateEventNum = checkDublicates( entries);
        if (dublicateEventNum > 0) {
            String name = entries[dublicateEventNum].getCompetitor().getName();
            int eventNum = entries[dublicateEventNum].getEventNum();
            
            System.out.println("Name       : " + name);
            System.out.println("Event Num  : " + eventNum);
            System.out.println("Reason     : " + "Event number ["+eventNum+"] already exists ");
            System.out.println("------------------------------------------------------------");
            
        }
        for (RunEntry entry : entries) {
            if (entry.getCompetitor().getEventType().contains("HalfMarathon")) {

                if (entry.getCompetitor().getAge() < 16) {
                    String name = entry.getCompetitor().getName();
                    int age = entry.getCompetitor().getAge();
                    System.out.println("Name       : " + name);
                    System.out.println("Age        : " + age);
                    System.out.println("Reason     : " + "Below the age limit");
                    System.out.println("------------------------------------------------------------\n");

                }
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

    @Override
    public ArrayList<CharityRun> getAllRuns() {
        return runs;
    }

    @Override
    public ArrayList<RunEntry> getComps() {
        return comps;
    }

    public int checkDublicates(RunEntry[] entries) {
        
        for (int j = 0; j < entries.length; j++) {
            for (int k = j + 1; k < entries.length; k++) {
                if (entries[k].getEventNum()== entries[j].getEventNum()) { // or use .equals()
                    
                    return k;
                }
            }
        }
        return -1;
    }

}
