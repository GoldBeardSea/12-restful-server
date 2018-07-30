package server;
import com.google.gson.Gson;
import model.Song;
import model.SongStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("api/songs")
public class SongsAPI {

    @PostMapping
    public ModelAndView createSong(
            @RequestParam("name") String name,
            @RequestParam("artist") String artist,
            @RequestParam("album") String album,
            @RequestParam("releaseYear") int releaseYear) {

        Song newSong = new Song(name, artist, album, releaseYear);
        SongStorage.songs.put(newSong.id, newSong);

        return new ModelAndView("redirect:/songs");
    }

    @GetMapping
    @ResponseBody
    public List<Song> getAllSongs() {
        Collection<Song> allSongs = SongStorage.songs.values();
        return new ArrayList<>(allSongs);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Song showOneSong(@PathVariable("id") int id) {
        Song oneSong = SongStorage.songs.get(id);
        return oneSong;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ModelAndView updateSong(
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        Song updateSong = gson.fromJson(body, Song.class);

        Song songs = SongStorage.songs.get(id);
        songs.name = updateSong.name;
        songs.artist = updateSong.artist;
        songs.album = updateSong.album;
        songs.releaseYear = updateSong.releaseYear;

        return new ModelAndView("redirect:/songs");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Song deleteSong(@PathVariable("id") int id) {
        Song deleteSong = SongStorage.songs.get(id);
        SongStorage.songs.remove(id);
        return deleteSong;
    }
}