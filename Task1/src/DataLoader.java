
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * dataloader class that parses through the file and stores each 
 * album object into an array list
 */
/**
 *
 * @author sohailgsais
 */
public class DataLoader {

    private String dataFile;
    private ArrayList<String> albumsData;
    private ArrayList<String> albumsTracks;

    DataLoader() {
        this.dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";
        this.albumsData = new ArrayList<>();
        this.albumsTracks = new ArrayList<>();
        
        load();
    }
    /**
     * loops through dataset file and splits each album line
     * by the given delim then stores into an array. stores album
     * tracks into separate array
     */
    private void load() {
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

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    // GETTERS
    public ArrayList<String> getAlbumsData() {

        return albumsData;
    }

    public ArrayList<String> getAlbumsTracks() {

        return albumsTracks;
    }

}
