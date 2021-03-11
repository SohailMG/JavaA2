
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        int numOfRuns;
        DataLoader loader = new DataLoader();
        ArrayList<FiveKmRun> fiveKruns ;
        ArrayList<HalfMarathon> halfMarathonRuns;

        fiveKruns = loader.getFiveKRuns();
        halfMarathonRuns = loader.getHalfMarathonRuns();

        numOfRuns = fiveKruns.size() + halfMarathonRuns.size();

        try {

            for (int i = 0; i < numOfRuns; i++) {
                System.out.println(halfMarathonRuns.get(i));
                System.out.println("");
                System.out.println(fiveKruns.get(i));

            }
        } catch (Exception e) {
        }
        String[][] comp = {{"John", "20"}, {"Smith", "30"}};
        ArrayList<RunEntry> comps = new ArrayList<>();

        

        for (String[] comp1 : comp) {
            String[] split = Arrays.toString(comp1).replaceAll("\\[|\\]", "").split(",");
            
            Random random = new Random();
            int ran =  random.nextInt(100 - 10) + 10;
            comps.add(new RunEntry(ran, (new Competitor(split[0], Integer.parseInt(split[1].trim())))));
            

        }
        for (RunEntry comp1 : comps) {
//            System.out.println(comp1);

        }
//        System.out.println(RunEntry);
//        System.out.println(comps.get(0).toString());
//        Competitor c1 = new Competitor("John", 20);
//        Competitor c2 = new Competitor("Tom", 22);
//        Competitor[] entries = {c1, c2};
//        
//        
//        RunEntry entry = new RunEntry(1234, entries);
//        RunEntry entry2 = new RunEntry(1234, entries);
//        entry.getEntries();

//        System.out.println(entry.getEntries());
//        System.out.println(entry2.getEventNum());
    }

}
