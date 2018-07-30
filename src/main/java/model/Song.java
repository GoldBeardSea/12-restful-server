package model;

public class Song {
    private static int REF_ID = 10100;

    public int id;
    public String name;
    public String artist;
    public int releaseYear;
    public String album;

    public Song (String name, String artist, String album, int releaseYear) {
        this.id = REF_ID++;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return name + " by " + artist + " from the album " + album + " and was released first in " + releaseYear;
    }

}
