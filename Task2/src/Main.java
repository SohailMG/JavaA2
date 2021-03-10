
public class Main {

    public static void main(String[] args) {

        FiveKmRun fiveKRun = new FiveKmRun(new myDate(1998, 10, 02).getDate(), new myDate(10, 30).getTime());
        FiveKmRun fiveKRun2 = new FiveKmRun(new myDate(2020, 02, 10).getDate(), new myDate(14, 30).getTime());
        HalfMarathon halfMarathon
                = new HalfMarathon(
                        new myDate(2021, 9, 9).getDate(),
                        new myDate(10, 30).getTime(),
                        10);

        System.out.println(halfMarathon);
        System.out.println(fiveKRun);
        
        Town town = new Town("Harrow");
        Park park = new Park("Hyde Park", 10);
        
        System.out.println(town);
        System.out.println(park);

    }

}
