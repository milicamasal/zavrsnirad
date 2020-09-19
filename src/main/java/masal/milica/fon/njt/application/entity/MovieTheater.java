/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Milica
 */
@Entity
@Table(name = "movietheater")
public class MovieTheater implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieTheaterID;
    @NotNull(message = "is required")
    @Size(min = 2, message = "is required")
    private String name;

    @NotNull(message = "is required")
    @Size(min = 2, message = "is required")
    private String adress;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "movietheater_id", referencedColumnName = "movieTheaterID")
    private List<Projection> projections;
    
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "movietheater_id", referencedColumnName = "movieTheaterID")
    private List<User> users;
    
    public Long getMovieTheaterID() {
        return movieTheaterID;
    }

    public MovieTheater(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public void setMovieTheaterID(Long movieTheaterID) {
        this.movieTheaterID = movieTheaterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public MovieTheater(Long movieTheaterID, String name, String adress) {
        this.movieTheaterID = movieTheaterID;
        this.name = name;
        this.adress = adress;
    }

    public MovieTheater() {
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }


}
