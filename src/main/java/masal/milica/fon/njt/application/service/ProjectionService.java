/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service;

import java.util.List;
import masal.milica.fon.njt.application.entity.Projection;

/**
 *
 * @author Milica
 */
public interface ProjectionService {

    public void save(Projection projection);

    public List<Projection> getAllProjections();

    public Projection findByID(Long projectionID);

    public void delete(Long projectionID);

    public void update(Projection projection);

}
