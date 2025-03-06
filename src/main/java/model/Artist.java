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
public class Artist {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int artist_id;
    @Column(name="name")
    private String name;
    @Column(name="genre_id")
    private String genre_id;
    @Column(name="birthdate")
    private String birthdate;
    @Column(name="real_name")
    private String real_name;
    @Column(name="description")
    private String description;
    @Column(name="country")
    private String country;
}

