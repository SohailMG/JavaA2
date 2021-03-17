
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//TODO: MAKE LOADER CLASS FOR FILE 
public class Main {

    public static void main(String[] args) {

        // creating a dataloader object 
        DataLoader dataLoader = new DataLoader();
        // declaring an array of album objects
        ArrayList<Album> albums = new ArrayList<>();
        // storing loaded albums and tracks into seperate arrays
        ArrayList<String> albumsData = dataLoader.getAlbumsData();
        ArrayList<String> albumsTracks = dataLoader.getAlbumsTracks();
        // storing albums and tracks into an array of album objects
        storeAlbums(albumsData, albums, albumsTracks);

        // maing program logic
        boolean activeMenu = true;
        while (activeMenu) {
            try {

                displayOptions();
                System.out.print("Choose Option >");
                Scanner menuScanner = new Scanner(System.in);
                int option = menuScanner.nextInt();
                switch (option) {
                    case 1:
                        listAllAlbums(albums);
                        break;
                    case 2:
                        displaySelectedAlbum(albums);
                        break;
                    case 3:
                        System.out.println("Enter Search Word or Phrase  > ");
                        Scanner search = new Scanner(System.in);
                        String searchStr = search.nextLine().toLowerCase();
                        int matchCount = 0;
                        System.out.println("Matches");
                        displaySearchResults(albums, searchStr, matchCount);
                        break;
                    case 0:
                        activeMenu = false;
                        break;
                    default:
                        System.out.println("\n" + option + " is Out of range" + "\n");
                        break;

                }
            } catch (Exception e) {
                System.out.println("\nWARNING! - Invalid option must be between [0-3]\n");
            }
        }
    }

    /**
     * displays the menu of options to the user
     */
    public static void displayOptions() {
        System.out.println("\n"
                + "\t\t+-----------------------+" + "\n"
                + "\t\t|\t" + "OPTIONS" + "\t\t|" + "\n"
                + "\t\t+---------------+-------+" + "\n"
                + "\t\t| List albums   |   1   |\n"
                + "\t\t+---------------+-------|\n"
                + "\t\t| Select album  |   2   |\n"
                + "\t\t+---------------+-------|\n"
                + "\t\t| Search titles |   3   |\n"
                + "\t\t+---------------+-------|\n"
                + "\t\t| Exit          |   0   |\n"
                + "\t\t+---------------+-------+" + "\n"
        );
        System.out.println("");
    }

    /**
     * loops through an arraylist of album objects and outputs their details in
     * a table like format
     *
     * @param albums
     */
    public static void listAllAlbums(ArrayList<Album> albums) {
        System.out.println("");
        tableTemplate();
        albums.forEach((album) -> {
            String headerTitles = String.format("%1s %2s %4s %-49s %-1s %-25s %1s %5s %1s %5s %1s",
                    "|", album.getRank(), "|", album.getTitle(), "|", album.getArtist(), "|", album.getYear(), "|", album.getSales(), "|");
            System.out.println(headerTitles);
        });
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    /**
     * presents user with an option to select an album and displays invokes the
     * toString method to display the selected album object as well as it's
     * track list
     *
     * @param albums
     */
    public static void displaySelectedAlbum(ArrayList<Album> albums) {
        boolean invalidRange = true;
        while (invalidRange) {
            try {
                System.out.println("\nSelect Rank [1-20] >");
                Scanner rank = new Scanner(System.in);
                int rankInput = rank.nextInt();
                if (rankInput > 0 && rankInput <= 20) {
                    System.out.println(albums.get(rankInput - 1).toString());
                    Scanner status = new Scanner(System.in);
                    System.out.println("\nSelect Another Album.........1\n"
                            + "Go Back to Menu..............0\n");
                    int selectAnother = status.nextInt();
                    if (selectAnother == 1) {
                    } else if (selectAnother == 0) {
                        invalidRange = false;
                    }
                } else {
                    System.out.println("\n" + "WARNING! - " + rankInput + " is Out of range");

                }

            } catch (Exception InputMismatchException) {

                System.out.println("\n" + "WARNING! - " + "Rank must be a number between 1 and 20");

            }
        }
    }

    public static void displaySearchResults(ArrayList<Album> albums, String searchStr, int matchCount) {
        //looping through array of album objects
        for (int i = 0; i < albums.size(); i++) {
//storing tracks of albums objects into an array
            String[] Albumtracks = albums.get(i).getTracks();
//looping through tracks containing search string
            for (int j = 0; j < Albumtracks.length; j++) {
                String lcTrack = Albumtracks[j].toLowerCase();
                if (lcTrack.contains(searchStr)) {
                    String foundTrack = lcTrack.replaceAll(searchStr, searchStr.toUpperCase());
                    System.out.println("\t\t+-------------+");
                    System.out.println("\t\t" + "| Match [ " + ++matchCount + " ] |");
                    System.out.println("+-------------+-+-------------+-------------------");
                    System.out.println("| Artist      | " + albums.get(i).getArtist());
                    System.out.println("+-------------+");
                    System.out.println("| Album Title | " + albums.get(i).getTitle());
                    System.out.println("+-------------|");
                    System.out.println("| Track Found | " + "[No. " + (j + 1) + "] -- " + foundTrack);
                    System.out.println("+-------------+-----------------------------------");
                }

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
        int sectionCounter = 0;
        int MAX_TRACKS = 20;
        String[] trs = new String[MAX_TRACKS];
        String s = "";
        for (int i = 0; i < albumsTracks.size(); i++) {
            if (albumsTracks.get(i).contains("--")) {
                trs[sectionCounter] = s;
                sectionCounter++;
                s = "";
            } else {
                s = s.concat(albumsTracks.get(i)).concat("::");
            }

        }

        String[] splitedTrack = trs[rank].split("::");
        return splitedTrack;
    }

    /**
     * loops through an array of albums,splits album content separated by ':'
     * loops through the spitted array and assign a variable to each data set,
     * then creates an array of album objects and stores each album
     *
     * @param albumsData an arraylist of albums without tracks
     * @param albums an arraylist of album objects
     * @param albumsTracks an arraylist of all tracks
     */
    public static void storeAlbums(ArrayList<String> albumsData, ArrayList<Album> albums, ArrayList<String> albumsTracks) {
        //loops through each first line and splits : delimted

        for (int i = 0; i < albumsData.size(); i++) {
            String title = "", artist = "", year = "", sales = "";
            int ranking = 0;
            String[] splitedData = albumsData.get(i).split(":");
            // storing title artist year and sales into a class object
            for (String split1 : splitedData) {
                ranking = Integer.parseInt(splitedData[0]);
                title  = splitedData[1];
                artist = splitedData[2];
                year   = splitedData[3];
                sales  = splitedData[4];
            }
            // calling split tracks and passing it the current rank of the album
            String[] alTracks = splitTracks(albumsTracks, i);
            albums.add(new Album(ranking, title, artist, year, sales, alTracks));
            Collections.sort(albums);

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
