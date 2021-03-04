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

//    @Override
    public String toString(int option) {
        StringBuilder str = new StringBuilder();

        String obj = null;
        if (option == 1) {
            String headerTitles = String.format("%2s %4s %-49s %-1s %-25s %1s %5s %1s %5s",
                    ranking, "|", title, "|", artist, "|", year, "|", sales);
            obj = headerTitles;

        } else if (option == 2) {
            String headerBorder = "------------------------------------------------------------------------------------------------------";
            String headerTitles = String.format("%2s %1s %-80s %-1s %-2s %1s %1s", "Rank", "|", "Title", "|", "Mins", "|", "Secs");
            String albumInfo
                    = "Title  : " + title + "\n"
                    + "Artist : " + artist + "\n"
                    + "Year   : " + year + "\n"
                    + "Sales  : " + sales;
            str.append(albumInfo).append("\n").append("Track List : ").append("\n");
            str.append(headerBorder).append("\n").append(headerTitles).append("\n").append(headerBorder).append("\n");
           
            int x = 0;
            for (String album : tracks) {
                String temp = album.replaceAll("\\)", "");
                String[] tracksTokens = temp.split("\\(|\\:");
                str.append(String.format("%2s %3s %-80s %-1s %-2s %3s %1s",
                        x + 1, "|", tracksTokens[0], "|", tracksTokens[1], "|", tracksTokens[2]));
                str.append("\n");
                x++;
            }

            obj = str.toString();
        }
        return obj;
    }

}
