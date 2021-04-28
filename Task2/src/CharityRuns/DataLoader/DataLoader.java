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

/**
 * data loader class that loads all data needed
 * into a data structure 
 * @author sohailgsais
 */
public class DataLoader implements DAO {

    HalfMarathon halfMarathon;
    FiveKmRun fiveKRun;
    CharityRun charityRun;
    final String HALFM = "HalfMarathon";
    final String FIVEK = "Five K";
    final int MINAGE = 16;

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
        // creating entries for each event
        RunEntry entry1 = new RunEntry(1221, new Competitor("Jane", 20, HALFM,  "Regents Park"));
        RunEntry entry2 = new RunEntry(1221, new Competitor("Jane", 17, HALFM,  "Hyde Park"));
        RunEntry entry3 = new RunEntry(1241, new Competitor("Sarah", 22, HALFM, "London"));
        RunEntry entry4 = new RunEntry(1261, new Competitor("Jane", 19, FIVEK,  "Kings Park"));
        RunEntry entry5 = new RunEntry(1211, new Competitor("Adam", 24, FIVEK, "Hyde Park"));
        RunEntry entry6 = new RunEntry(1313, new Competitor("Jasmin", 20, HALFM, "Hyde Park"));
        RunEntry entry7 = new RunEntry(1411, new Competitor("Alice", 21, FIVEK, "Hyde Park"));

        RunEntry[] entries = {entry1, entry2, entry3, entry4, entry5,entry6,entry7};

        validateEntries(entries);
        checkDubEntry(entries);
        
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 7, 9).getDate(), new myDate(14, 30).getTime(), 10, 30, Place.PARK, entry1.getCompetitor().geteventName(), entry1));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 10, 3).getDate(), new myDate(13, 40).getTime(), 9, 14, Place.PARK, entry2.getCompetitor().geteventName(), entry2));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 12, 4).getDate(), new myDate(12, 30).getTime(), 9, Place.TOWN, entry3.getCompetitor().geteventName(), entry3));
        halfMarathonRuns.add(new HalfMarathon(new myDate(2021, 30, 4).getDate(), new myDate(11, 30).getTime(), 9, Place.PARK, entry3.getCompetitor().geteventName(), entry6));
        System.out.println(halfMarathonRuns.get(2).getPlace());

        fiveKruns.add(new FiveKmRun(new myDate(2021, 8, 31).getDate(), new myDate(17, 55).getTime(), new Park(entry4.getCompetitor().geteventName(), 3), entry4));
        fiveKruns.add(new FiveKmRun(new myDate(2021, 4, 4).getDate(), new myDate(14, 55).getTime(), new Park(entry5.getCompetitor().geteventName(), 20), entry5));
        fiveKruns.add(new FiveKmRun(new myDate(2021, 3, 7).getDate(), new myDate(12, 55).getTime(), new Park(entry5.getCompetitor().geteventName(), 2), entry7));

        fiveKruns.forEach((fiveKrun) -> {
            runs.add(fiveKrun);
        });
        halfMarathonRuns.forEach((halfM) -> {
            runs.add(halfM);
        });
    }
    
    /**
     * validates competitor entries. checking for age limits
     * on half m runs as well as preventing competitor from
     * entering the same event twice
     * @param entries 
     */
    public void validateEntries(RunEntry[] entries) {
        System.out.println("\n---------------------DENY ENTRY---------------------------");
        int dublicateEventNum = validateEventNum(entries);
        if (dublicateEventNum > 0) {
            String name = entries[dublicateEventNum].getCompetitor().getName();
            int eventNum = entries[dublicateEventNum].getEventNum();

            System.out.println("Name        : " + name);
            System.out.println("Event Num   : " + eventNum);
            System.out.println("Reason      : " + "Event number [" + eventNum + "] already exists ");
            System.out.println("------------------------------------------------------------");

        }
        int dubEntries = checkDubEntry(entries);
         if (dubEntries > 0) {
            String name = entries[dublicateEventNum].getCompetitor().getName();
            String eventName = entries[dubEntries].getCompetitor().geteventName();
            System.out.println("Name        : " + name);
            System.out.println("Event Name  : " + eventName);
            System.out.println("Reason      : " + name + " already has entry for " + eventName);
            System.out.println("------------------------------------------------------------");

        }
        for (RunEntry entry : entries) {
            if (entry.getCompetitor().getEventType().contains("HalfMarathon")) {
                if (entry.getCompetitor().getAge() < MINAGE) {
                    String name = entry.getCompetitor().getName();
                    int age = entry.getCompetitor().getAge();
                    System.out.println("Name        : " + name);
                    System.out.println("Age         : " + age);
                    System.out.println("Reason      : " + "Below the age limit");
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
    /**
     * loops through the entries array and checks that there
     * are no competitors same event number
     * @param entries
     * @return 
     */
    public int validateEventNum(RunEntry[] entries) {

        for (int j = 0; j < entries.length; j++) {
            for (int k = j + 1; k < entries.length; k++) {
                if (entries[k].getEventNum() == entries[j].getEventNum()) {

                    return k;
                }
            }
        }
        return -1;
    }
    /**
     *  loops through the entries array and checks that there
     * are no competitors with more than one entry for same event
     * @param entries
     * @return 
     */
    public int checkDubEntry(RunEntry[] entries) {
        for (int j = 0; j < entries.length; j++) {
            for (int k = j + 1; k < entries.length; k++) {
                Competitor currentComp = entries[k].getCompetitor();
                Competitor newComp = entries[j].getCompetitor();
                
                if (currentComp.getName().equals(newComp.getName())) {
                    if (currentComp.geteventName().equals(newComp.geteventName())) {
                        
                        
                    return k;

                    }

                }
            }
        }
        return -1;

    }

}
