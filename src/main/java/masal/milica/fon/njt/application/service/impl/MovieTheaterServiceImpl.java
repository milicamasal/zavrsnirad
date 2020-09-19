/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service.impl;

import java.util.List;
import java.util.Optional;
import masal.milica.fon.njt.application.entity.MovieTheater;
import masal.milica.fon.njt.application.repository.MovieTheaterRepository;
import masal.milica.fon.njt.application.service.MovieTheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class MovieTheaterServiceImpl implements MovieTheaterService {

    private final MovieTheaterRepository movieTheaterRepository;

    @Autowired
    public MovieTheaterServiceImpl(MovieTheaterRepository movieTheaterRepository) {
        this.movieTheaterRepository = movieTheaterRepository;
    }

    @Override
    public void save(MovieTheater movieTheater) {
        movieTheaterRepository.save(movieTheater);
    }

    @Override
    public List<MovieTheater> getAll() {
        return movieTheaterRepository.findAll();
    }

    @Override
    public MovieTheater findByID(Long movieTheaterID) {

        Optional<MovieTheater> m = movieTheaterRepository.findById(movieTheaterID);
        return m.get();
    }

    @Override
    public void delete(Long movieTheaterID) {
        movieTheaterRepository.deleteById(movieTheaterID);
    }

    @Override
    public void update(MovieTheater movieTheater) {
        movieTheaterRepository.update(movieTheater.getName(), movieTheater.getAdress(), movieTheater.getMovieTheaterID());
    }

}
