package model;

import java.util.HashMap;
import java.util.Map;

public class SongStorage {

    public static Map<Integer, Song> songs;

    static {
        songs = new HashMap<>();
        Song leafHouse = new Song("Leaf House", "Animal Collective", "Sun Tongs", 2004);
        Song bigDeal = new Song("Big Deal", "Black Dice", "Big Deal (Single)", 2016);
        Song anyAndEvery = new Song("Any and Every", "Excepter", "Debt Dept.", 2008);

        songs.put(leafHouse.id, leafHouse);
        songs.put(bigDeal.id, bigDeal);
        songs.put(anyAndEvery.id, anyAndEvery);

    }
}
