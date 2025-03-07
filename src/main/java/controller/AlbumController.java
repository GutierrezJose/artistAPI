package controller;

import model.Album;
import model.DTO.AlbumDTO;
import model.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Integer id) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            return ResponseEntity.ok(album.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Album> deleteAlbum(@PathVariable Integer id) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            albumRepository.delete(album.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Integer id, @RequestBody AlbumDTO updates) {
        Optional<Album> albumOptional = albumRepository.findById(id);
        if (albumOptional.isPresent()) {
            Album albumToUpdate = albumOptional.get();
            albumToUpdate.setTitle(updates.getTitle());
            albumToUpdate.setRelease_date(updates.getRelease_date());
            albumToUpdate.setArtist_id(updates.getArtist_id());
            albumRepository.save(albumToUpdate);
            return ResponseEntity.ok(albumToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
