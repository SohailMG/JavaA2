
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        HashMap<Integer, Object> albumsMap = new HashMap<>();
        
        Album album1;
        Album album2;
        Album album3;
        
        Album[] albums = new Album[20];

        try {
            String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";

            File albumsFile = new File(dataFile);
            Scanner filereader = new Scanner(albumsFile);
            ArrayList<String> tracks = new ArrayList<>();
            ArrayList<String> firstLine = new ArrayList<>();

            String line;
            while (filereader.hasNextLine()) {

                line = filereader.nextLine();

                char ch = line.charAt(0);

                if (Character.isDigit(ch)) {
                    firstLine.add(line);
                    
                } else {
                    tracks.add(line);
                    
                    
                    
                }

            }
            
            
            
            for (int i = 0; i < albums.length; i++) {
                String[] parts1 = firstLine.get(0).split(":");
                String title1 = parts1[1];
                String artist1 = parts1[2];
                String year1 = parts1[3];
                
                albums[i]= new Album(title1,artist1,year1);
                
            }
            for (Album album : albums) {
                System.out.println(album);
                
            }
//            System.out.println(tracks.get(0));
//                String[] parts1 = firstLine.get(0).split(":");
//                String title1 = parts1[1];
//                String artist1 = parts1[2];
//                String year1 = parts1[3];
//                album1 = new Album(title1,artist1,year1);
//               
//                String[] parts2 = firstLine.get(1).split(":");
//                String title2 = parts2[1];
//                String artist2 = parts2[2];
//                String year2 = parts2[3];
//                album2 = new Album(title2,artist2,year2);
//               
//                String[] parts3 = firstLine.get(2).split(":");
//                String title3 = parts3[1];
//                String artist3 = parts3[2];
//                String year3 = parts3[3];
//                album3 = new Album(title3,artist3,year3);
//               
//                
//                System.out.println(album3);
//                
//                albumsMap.put(1, album1);
//                albumsMap.put(2, album2);
//                albumsMap.put(3, album3);
//                
//                
//               System.out.println(albumsMap.get(3));
                

        } catch (FileNotFoundException ex) {

        }

    }

}
