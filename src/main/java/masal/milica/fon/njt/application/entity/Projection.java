/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Milica 
 */
@Entity
@Table(name = "projection")
public class Projection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectionID;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @NotNull(message = "is required")
    private Movie movieID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "is required")
    @Future(message = "must be date from the future")
    private Date date;
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    @NotNull(message = "is required")
    private Date time;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String screen;
    @ManyToOne
    @JoinColumn(name = "movietheater_id")
//    @NotNull(message = "is required")
    private MovieTheater theater;

    private String createdByUser;

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MovieTheater getTheater() {
        return theater;
    }

    public void setTheater(MovieTheater theater) {
        this.theater = theater;
    }

    public Long getProjectionID() {
        return projectionID;
    }

    public void setProjectionID(Long projectionID) {
        this.projectionID = projectionID;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
