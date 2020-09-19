/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service.impl;

import java.util.List;
import masal.milica.fon.njt.application.entity.Genre;
import masal.milica.fon.njt.application.repository.GenreRepository;
import masal.milica.fon.njt.application.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository g) {
        genreRepository = g;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll().subList(0, 12);
    }

}
