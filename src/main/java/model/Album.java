package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int album_id;
    @Column(name="title")
    private String title;
    @Column(name="release_date")
    private String release_date;
    @Column(name="artist_id")
    private int artist_id;
}
