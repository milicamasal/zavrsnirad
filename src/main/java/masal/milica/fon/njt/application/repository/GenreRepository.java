/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.repository;

import masal.milica.fon.njt.application.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Milica
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
    
}
