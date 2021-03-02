
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";
        ArrayList<String> albumsData = new ArrayList<>();
        ArrayList<String> albumsTracks = new ArrayList<>();
        ArrayList<String> trk = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> tracks = new HashMap<>();
        ArrayList<Album> albums = new ArrayList<>();

        File albumsFile = new File(dataFile);
        try {
            Scanner filereader = new Scanner(albumsFile);
            String line;
            int index = 0;
            while (filereader.hasNextLine()) {

                line = filereader.nextLine();

                char ch = line.charAt(0);
                char ch2 = line.charAt(1);
                char ch3 = line.charAt(2);

                if (Character.isDigit(ch)) {

                    if (ch2 == ':' || ch3 == ':') {

                        albumsData.add(line);
                    }

                } else {
                    albumsTracks.add(line);

                }

            }

            storeAlbums(albumsData, albums);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        
        boolean activeMenu = true;
        while (activeMenu) {
            System.out.println(
                    "List albums.........1\n"
                    + "Select album........2\n"
                    + "Search titles.......3\n"
                    + "Exit................0");
            System.out.println(">");
            Scanner s = new Scanner(System.in);
            int option = s.nextInt();
            switch (option) {
                case 1:
                    listAlbums(albums);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Select Rank [1-20]>");
                    Scanner rank = new Scanner(System.in);
                    int rankInput = rank.nextInt();
                    System.out.println(albums.get(rankInput - 1));
                    break;
                case 0:
                    activeMenu = false;
                    break;
                default:
                    break;
            }
        }

    }

    public static void storeAlbums(ArrayList<String> albumsData, ArrayList<Album> albums) {
        //loops through each first line and splits : delimted
        for (int i = 0; i < albumsData.size(); i++) {
            String title = "", artist = "", year = "", sales = "";
            int ranking = 0;

            String[] split = albumsData.get(i).split(":");
            // storing title artist year and sales into a class object
            for (String split1 : split) {
                ranking = Integer.parseInt(split[0]);
                title = split[1];
                artist = split[2];
                year = split[3];
                sales = split[4];
            }
            albums.add(new Album(ranking, title, artist, year, sales));

        }
    }

    public static void listAlbums(ArrayList<Album> albums) {
        tableHeaders();
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(albums.get(i));

        }
    }

    public static void tableHeaders() {
        String headerTitles;
        String headerBorders;
        headerTitles = String.format("%2s %2s %25s %25s %5s %20s %5s", "Rank", "|", "Title", "|", "Artist", "|", "Year");
        headerBorders = String.format("%s", "----------------------------------------------------------------------------------------------------------------");
        System.out.println(headerBorders);
        System.out.println(headerTitles);
        System.out.println(headerBorders);
    }
}
