/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.repository;

import masal.milica.fon.njt.application.entity.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Milica
 */
@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Long> {

    @Modifying
    @Query("update MovieTheater mt set mt.name = ?1, mt.adress = ?2 where mt.movieTheaterID = ?3")
    void update(String name, String adress, Long movieTheaterID);

}
