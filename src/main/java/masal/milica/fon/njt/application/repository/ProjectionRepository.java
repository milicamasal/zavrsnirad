/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.repository;

import masal.milica.fon.njt.application.entity.Movie;
import masal.milica.fon.njt.application.entity.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import masal.milica.fon.njt.application.entity.MovieTheater;

/**
 *
 * @author Milica
 */
@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {

    @Modifying
    @Query("update Projection p set p.movieID= ?1, p.date = ?2, p.time = ?3, p.screen=?4, p.theater=?5 where p.projectionID = ?6")
    void update(Movie movie, Date date, Date time, String screen, MovieTheater movieTheater, Long movieTheaterID);

}
