package model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDTO {
    private String title;
    private String release_date;
    private int artist_id;
}
