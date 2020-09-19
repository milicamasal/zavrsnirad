/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import masal.milica.fon.njt.application.entity.Movie;
import masal.milica.fon.njt.application.entity.MovieTheater;
import masal.milica.fon.njt.application.entity.Projection;
import masal.milica.fon.njt.application.entity.User;
import masal.milica.fon.njt.application.service.MovieService;
import masal.milica.fon.njt.application.service.ProjectionService;
import masal.milica.fon.njt.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final MovieService movieService;
    private final ProjectionService projectionService;
    private final UserService userService;

    @Autowired
    public UserController(MovieService movieService, ProjectionService projectionService, UserService userService) {
        this.movieService = movieService;
        this.projectionService = projectionService;
        this.userService = userService;
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @ModelAttribute(name = "allmovies")
    private List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @ModelAttribute(name = "allprojections")
    private List<Projection> getAllProjections(Model model, HttpServletRequest request) {
        if (request.getUserPrincipal() != null) {
            String user = request.getUserPrincipal().getName();
            User us = userService.findByUsername(user);
            MovieTheater movieTheater = us.getTheater();
            if (movieTheater != null) {
                model.addAttribute("message", "All projections!");
                List<Projection> all = projectionService.getAllProjections();
                List<Projection> projections = new ArrayList();
                for (Projection p : all) {
                    if (p.getTheater().getName().equals(us.getTheater().getName())) {
                        projections.add(p);
                    }
                }
                model.addAttribute("allprojections", projections);
                return projections;
            } else {
                return projectionService.getAllProjections();
            }
        } else {
            return projectionService.getAllProjections();
        }
    }
}
