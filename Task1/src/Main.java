
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";
        ArrayList<String> albumsData = new ArrayList<>();
        ArrayList<String> albumsTracks = new ArrayList<>();
        ArrayList<Album> albums = new ArrayList<>();

        File albumsFile = new File(dataFile);
        try {
            Scanner filereader = new Scanner(albumsFile);
            String line;
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

            storeAlbums(albumsData, albums, albumsTracks);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        boolean activeMenu = true;
        while (activeMenu) {
            System.out.println("");
            System.out.println(
                    "List albums.........1\n"
                    + "Select album........2\n"
                    + "Search titles.......3\n"
                    + "Exit................0");
            System.out.println("");
            System.out.print("Choose Option >" );
            Scanner s = new Scanner(System.in);
            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println("");
                    tableTemplate();
                    albums.forEach((album) -> {
                        System.out.println(album.toString(option));
                    });
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    try {
                        System.out.println("Select Rank [1-20]>");
                        Scanner rank = new Scanner(System.in);
                        int rankInput = rank.nextInt();
                        if(rankInput > 0 && rankInput <= 20){
                        
                        System.out.println(albums.get(rankInput - 1).toString(option));
                        }else{
                            System.out.println( rankInput + " is Out of range");
                        }

                    } catch (Exception e) {
                        System.out.println("\n" + "Rank must be an integer");
                        
                    }

                    break;
                case 3:
                    System.out.println("Enter Search Word or Phrase  > ");
                    Scanner search = new Scanner(System.in);
                    String searchStr = search.nextLine().toLowerCase();
                    int matchCount = 0;
                    System.out.println("Matches");
                    
//                    looping through array of album objects
                    for (int i = 0; i < albums.size(); i++) {
//                        storing tracks of albums objects into an array
                        String[] Albumtracks = albums.get(i).getTracks();
                        //looping through tracks containing search string
                        for (int j = 0; j < Albumtracks.length; j++) {
                            String lcStr = Albumtracks[j].toLowerCase();

                            if (lcStr.contains(searchStr)) {
                                
                                System.out.println( "\t\t" +  " Match [ " + ++matchCount + " ]");
                                System.out.println("--------------------------------------------------");
                                System.out.println("| Artist      | " + albums.get(i).getArtist());
                                System.out.println("|-------------|");
                                System.out.println("| Album Title | " + albums.get(i).getTitle());
                                System.out.println("|-------------|");
                                System.out.println("| Track Found | " + "[No. " + (j + 1) + "] -- " + Albumtracks[j]);
                                System.out.println("--------------------------------------------------");
                            }

                        }
                    }
                    break;
                case 0:
                    activeMenu = false;
                    break;
                default:
                    System.out.println("\n" + "Out of range" + "\n");
                    break;
            }
        }
    }

    /**
     *
     * iterates through array of tracks, concatenates all tracks separated by
     * dash and adds :: as separator, then stores each section of tracks into an
     * array
     *
     * @param albumsTracks
     * @param rank
     * @return array of tracks separated by ::
     */
    public static String[] splitTracks(ArrayList<String> albumsTracks, int rank) {
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

        String[] splited = trs[rank].split("::");
        return splited;
    }

    public static void storeAlbums(ArrayList<String> albumsData, ArrayList<Album> albums, ArrayList<String> albumsTracks) {
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
            String[] alTracks = splitTracks(albumsTracks, i);
            albums.add(new Album(ranking, title, artist, year, sales, alTracks));

        }
    }

    public static void tableTemplate() {
        String headerTitles;
        String headerBorders;
        headerTitles = String.format("%2s %4s %25s %25s %5s %20s %5s %1s %5s", "Rank", "|", "Title", "|", "Artist", "|", "Year", "|", "Sales");
        headerBorders = String.format("%s", "-------------------------------------------------------------------------------------------------------");
        System.out.println(headerBorders);
        System.out.println(headerTitles);
        System.out.println(headerBorders);
    }
}
