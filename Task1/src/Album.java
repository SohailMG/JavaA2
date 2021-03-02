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

    Album(int ranking,String title, String artist, String year, String sales) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;
        this.ranking = ranking;

//        this.tracks = tracks;
    }

    @Override
    public String toString() {

        
//        String line =  "|" + ranking + "\t" + "|"  + title + "\t\t" + "|"+ artist + "\t\t" + "|"+ year + "\t\t" + "|"+ sales + "\n";
        String headerTitles = String.format("%2s %4s %-49s %-1s %-25s %1s %5s",  ranking , "|", title, "|", artist, "|", year);
        String obj
                = "Rank   : " + ranking + "\n"
                + "Title  : " + title + "\n"
                + "Artist : " + artist + "\n"
                + "year   : " + year + "\n"
                + "Sales  : " + sales;

        return headerTitles;
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
        for (String track : tracks) {

        }
        return tracks;
    }

}
