package org.springframework.guru.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String director;
    @Column(unique = true)
    private String ticketCode;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Songs> songs;

    public Movie() {
    }

    public Movie(String title, String director, String ticketCode) {
        this.title = title;
        this.director = director;
        this.ticketCode = ticketCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Set<Songs> getSongs() {
        return songs;
    }

    public void setSongs(Set<Songs> songs) {
        this.songs = songs;
    }
}
