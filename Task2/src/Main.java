
public class Main {

    public static void main(String[] args) {
        Park park = new Park("Hyde Park", 10);
        Town town = new Town("Harrow");
        
   

        FiveKmRun fiveKRun = new FiveKmRun(new myDate(1998, 10, 02).getDate(), new myDate(10, 30).getTime(),park);
        
        HalfMarathon halfMarathon
                = new HalfMarathon(
                        new myDate(2021, 9, 9).getDate(),
                        new myDate(10, 30).getTime(),
                        10,park,Place.PARK);
        HalfMarathon halfMarathon2
                = new HalfMarathon(
                        new myDate(2021, 9, 9).getDate(),
                        new myDate(10, 30).getTime(),
                        10,town,Place.TOWN);

//        System.out.println(halfMarathon.toString());
//        System.out.println("");
//        System.out.println(halfMarathon2.toString());
        
        Competitor c1 = new Competitor("John", 20);
        Competitor c2 = new Competitor("Tom", 22);
        Competitor[] entries = {c1,c2} ;
        
        
        RunEntry entry = new RunEntry(1234, entries);
        
        System.out.println(entry.getEntryCount());

    }

}
