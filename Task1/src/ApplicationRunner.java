
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";
        ArrayList<String> albumsData = new ArrayList<>();
        ArrayList<String> albumsTracks = new ArrayList<>();
        ArrayList<String> trk = new ArrayList<>();
        HashMap<Integer, String> tracks = new HashMap<>();
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

            storeAlbums(albumsData, albums,albumsTracks);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

//        showTrackList(albumsTracks, tracks, 0);
//        System.out.println(Arrays.toString(splited));
//        for (String tr : trs) {
//            System.out.println(tr);
//
//        }
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
                    System.out.println("");
                    tableHeaders();
                    albums.forEach((album) -> {
                        System.out.println(album.toString(option));
                    });
                    break;
                case 2:
                    System.out.println("Select Rank [1-20]>");
                    Scanner rank = new Scanner(System.in);
                    int rankInput = rank.nextInt();
                    System.out.println(albums.get(rankInput - 1).toString(option));
                    showTrackList(albumsTracks,  rankInput - 1);
                    break;
                case 3:
                    break;
                case 0:
                    activeMenu = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static String[] showTrackList(ArrayList<String> albumsTracks,  int rank) {
        String[] trs = splitTracks(albumsTracks);
        String[] splited = trs[rank].split("::");
        return splited;
    }

    /**
     *
     * iterates through array of tracks, concatenates all tracks separated
     * by dash and adds :: as separator, then stores each section of tracks
     * into an array
     * @param albumsTracks
     * @return array of tracks separated by :: 
     */
    public static String[] splitTracks(ArrayList<String> albumsTracks) {
        int x = 0;
        int MAX_TRACKS = 20;
        String[] trs = new String[MAX_TRACKS];
        String s = "";
        for (int i = 0; i < albumsTracks.size(); i++) {
            if (albumsTracks.get(i).contains("--")) {
                trs[x] = s;
                x++;
                s = "";
            } else {
                s = s.concat(albumsTracks.get(i)).concat("::");
            }

        }
        return trs;
    }

    public static void storeAlbums(ArrayList<String> albumsData, ArrayList<Album> albums,ArrayList<String>albumsTracks) {
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
            String[] alTracks =  showTrackList(albumsTracks, i);
            albums.add(new Album(ranking, title, artist, year, sales,alTracks));

        }
    }

//    public static void listAlbums(ArrayList<Album> albums) {
//        tableHeaders();
//        for (int i = 0; i < albums.size(); i++) {
//            System.out.println(albums.get(i));
//
//        }
//    }

    public static void tableHeaders() {
        String headerTitles;
        String headerBorders;
        headerTitles = String.format("%2s %2s %25s %25s %5s %20s %5s %1s %5s", "Rank", "|", "Title", "|", "Artist", "|", "Year", "|", "Sales");
        headerBorders = String.format("%s", "----------------------------------------------------------------------------------------------------------------");
        System.out.println(headerBorders);
        System.out.println(headerTitles);
        System.out.println(headerBorders);
    }
}
