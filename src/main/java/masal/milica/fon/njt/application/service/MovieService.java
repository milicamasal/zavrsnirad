/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service;

import java.util.List;
import masal.milica.fon.njt.application.entity.Movie;

/**
 *
 * @author Milica
 */
public interface MovieService {

    public void save(Movie movie);

    public List<Movie> getAllMovies();

    public Object findByID(Long movieID);

    public void delete(Long movieID);
}
