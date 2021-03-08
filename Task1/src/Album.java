
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sohailgsais
 */
public class Album {

    private String title;
    private String artist;
    private String year;
    private String sales;
    private int ranking;
    private String[] tracks;

    public Album() {
    }

    Album(int ranking, String title, String artist, String year, String sales, String[] tracks) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;
        this.ranking = ranking;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public String[] getTracks() {

        return tracks;
    }
    public int getRank(){
        return ranking;
    }
    public String getSales(){
        return sales;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        String obj;
                String headerBorder = " |-------------------------------------------------------------------------------------------------------|";
                String headerTitles = String.format("%6s %2s %-80s %-1s %-2s %1s %1s", "|Rank", "|", "Title", "|", "Mins", "|", "Secs |");
                String albumInfo
                        =
                        "\t\t -------------------------[ALBUM]------------------------\n"
                        +"\t\t |Title   | " + title + "\n"
                        +"\t\t |--------|\n" 
                        +"\t\t |Artist  | " + artist + "\n"
                        +"\t\t |--------|\n"
                        +"\t\t |Year    | " + year + "\n"
                        +"\t\t |--------|\n"
                        +"\t\t |Sales   | " + sales + "\n"
                        +"\t\t --------------------------------------------------------\n"
                        ;
                str.append(albumInfo).append("\n\t\t\t\t\t[Track List]\n");
                str.append(headerBorder).append("\n").append(headerTitles).append("\n").append(headerBorder).append("\n");
                int x = 0;
                for (String track : tracks) {
                    String temp = track.replaceAll("\\)", "");
                    String[] tracksTokens = temp.split("\\(|\\:");
                    str.append(String.format("%2s %2s %3s %-80s %-1s %-2s %3s %1s %3s ",
                            "|" , (x + 1), "|", tracksTokens[0], "|", tracksTokens[1], "|", tracksTokens[2],"|"));
                    str.append("\n");
                    x++;

                }
                str.append(headerBorder).append("\n");
                obj = str.toString();
        return obj;
    }

}
