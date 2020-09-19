/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service.impl;

import java.util.List;
import java.util.Optional;
import masal.milica.fon.njt.application.entity.Projection;
import masal.milica.fon.njt.application.repository.ProjectionRepository;
import masal.milica.fon.njt.application.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;

    @Autowired
    public ProjectionServiceImpl(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    @Override
    public void save(Projection projection) {
        projectionRepository.save(projection);
    }

    @Override
    public List<Projection> getAllProjections() {
        return projectionRepository.findAll();
    }

    @Override
    public Projection findByID(Long projectionID) {
        Optional<Projection> p = projectionRepository.findById(projectionID);
        return p.get();
    }

    @Override
    public void delete(Long projectionID) {
        projectionRepository.deleteById(projectionID);
    }

    @Override
    public void update(Projection projection) {
        projectionRepository.update(projection.getMovieID(), projection.getDate(), projection.getTime(), projection.getScreen(), projection.getTheater(), projection.getProjectionID());
    }

}
