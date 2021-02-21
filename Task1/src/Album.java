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
    private String[] tracks;

    Album(String title, String artist, String year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
//        this.tracks = tracks;

    }

    @Override
    public String toString() {
        
        

        return title+" "+artist+" "+year; 
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
