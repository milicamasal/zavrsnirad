/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service;

import java.util.List;
import masal.milica.fon.njt.application.entity.MovieTheater;

/**
 *
 * @author Milica
 */
public interface MovieTheaterService {

    public void save(MovieTheater movieTheater);

    public List<MovieTheater> getAll();

    public MovieTheater findByID(Long movieTheaterID);

    public void delete(Long movieTheaterID);

    public void update(MovieTheater movieTheater);
    
}
