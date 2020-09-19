/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Milica
 */
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long movieid;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "is required")
    @Past(message = ("must be date from the past"))
    private Date releasedDate;

    @OneToMany(fetch =FetchType.LAZY,cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "movie_id", referencedColumnName = "movieid")
    private List<Projection> projections;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genreId"))
    @NotNull(message = "is required")
    @Size(min = 1, message = "You must select genre")
    private List<Genre> genres;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String director;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String writer;
    @NotNull(message = "is required")
    @Min(value = 1, message = "must bre greater than zero")
    private Long duration;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String synopsis;
    private String imageURL;
    private String createdByUser;

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }


    @Transient
    private MultipartFile images;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Movie(Long movieid, String title, Date releasedDate, List<Projection> projections, List<Genre> genres, String director, String writer, Long duration, String synopsis, MultipartFile images) {
        this.movieid = movieid;
        this.title = title;
        this.releasedDate = releasedDate;
        this.projections = projections;
        this.genres = genres;
        this.director = director;
        this.writer = writer;
        this.duration = duration;
        this.synopsis = synopsis;
        this.images = images;
    }

    public MultipartFile getImages() {
        return images;
    }

    public void setImages(MultipartFile images) {
        this.images = images;
    }

    public Movie() {
        projections = new ArrayList<>();
        genres = new ArrayList<>();
    }

    public Long getMovieid() {
        return movieid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieid=" + movieid + ", title=" + title + ", releasedDate=" + releasedDate + ", projections=" + projections + ", genres=" + genres + ", director=" + director + ", writer=" + writer + ", duration=" + duration + ", synopsis=" + synopsis + " }";
    }

}
