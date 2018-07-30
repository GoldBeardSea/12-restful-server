package server;

import model.Song;
import model.SongStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongHTML {


    @GetMapping
    public String allSong(Model model) {
        Collection<Song> songs = SongStorage.songs.values();
        List<Song> songList = new ArrayList<>(songs);

        model.addAttribute("songs", songs);
        return "allSongs";
    }

    @GetMapping("/new")
    public String createSong() {
        return "createSong";
    }

    @GetMapping("/{id}/edit")
    public String editSong(
            @PathVariable("id") int id,
            Model model
    ) {
        Song songEditor = SongStorage.songs.get(id);

        model.addAttribute("id", songEditor.id);
        model.addAttribute("name", songEditor.name);
        model.addAttribute("artist", songEditor.artist);
        model.addAttribute("album", songEditor.album);
        model.addAttribute("releaseYear", songEditor.releaseYear);

        return "editSong";
    }
}
