package warsito.musicweblibrary.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALBUM_ID")
    private Long id;

    @NotBlank
    @Size(min = 1, max = 40, message = "size of album name: 1 to 40")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    private String genre;
    private LocalDate release;

    @Enumerated
    private Rate rate;
}