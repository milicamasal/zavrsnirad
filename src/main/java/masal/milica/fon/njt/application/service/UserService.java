/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.service;

import masal.milica.fon.njt.application.entity.User;

/**
 *
 * @author Milica
 */
public interface UserService {

    User findByUsername(String username);
}
