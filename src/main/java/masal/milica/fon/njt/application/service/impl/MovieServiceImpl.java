/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service.impl;

import java.util.List;
import java.util.Optional;
import masal.milica.fon.njt.application.entity.Movie;
import masal.milica.fon.njt.application.repository.MovieRepository;
import masal.milica.fon.njt.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository1) {
        movieRepository = movieRepository1;
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Object findByID(Long movieID) {
        Optional<Movie> m = movieRepository.findById(movieID);
        m.get().getGenres().size();
        return m.get();
    }

    @Override
    public void delete(Long movieID) {
        movieRepository.deleteById(movieID);
    }

}
