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
import masal.milica.fon.njt.application.service.MovieTheaterService;
import masal.milica.fon.njt.application.service.ProjectionService;
import masal.milica.fon.njt.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/projection")
public class ProjectionController {

    private final ProjectionService projectionService;
    private final MovieService movieService;
    private final MovieTheaterService movieTheaterService;
    private final UserService userService;

    @Autowired
    public ProjectionController(ProjectionService projectionService, MovieService movieService, MovieTheaterService movieTheaterService, UserService userService) {
        this.projectionService = projectionService;
        this.movieService = movieService;
        this.movieTheaterService = movieTheaterService;
        this.userService = userService;
    }

    @GetMapping(value = "/add")
    public String addProjection() {

        return "projection/add";
    }

    @GetMapping(value = "/all")
    public String allProjections(Model model, HttpServletRequest request) {
        if (request.getUserPrincipal() != null) {
            String user = request.getUserPrincipal().getName();
            User us = userService.findByUsername(user);
            MovieTheater movieTheater = us.getTheater();
            model.addAttribute("message", "All projections!");
            List<Projection> all = projectionService.getAllProjections();
            List<Projection> projections = new ArrayList();
            for (Projection p : all) {
                if (p.getTheater().getName().equals(us.getTheater().getName())) {
                    projections.add(p);
                }
            }
            model.addAttribute("projections", projections);
        } else {
            model.addAttribute("projections", projectionService.getAllProjections());
        }
        return "projection/all";
    }

    @PostMapping(value = "/save")
    public String save(@Validated @ModelAttribute(name = "projection") Projection projection, BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("projection", projection);
            return "projection/add";
        } else {
            projection.setCreatedByUser(request.getUserPrincipal().getName());

            projectionService.save(projection);
            redirectAttributes.addFlashAttribute("message", "Projection is saved");
            return "redirect:/projection/add";
        }
    }

    @ModelAttribute(value = "projection")
    private Projection getProjection(HttpServletRequest request) {
        String user = request.getUserPrincipal().getName();
        User us = userService.findByUsername(user);
        MovieTheater movieTheater = us.getTheater();
        Projection p = new Projection();
        p.setTheater(movieTheater);
        return p;
    }

    @ModelAttribute(value = "allmovies")
    private List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @ModelAttribute(value = "alltheaters")
    private List<MovieTheater> getMovieThearers() {
        return movieTheaterService.getAll();
    }

    @RequestMapping(value = "/{projectionID}/update")
    public String update(@PathVariable(name = "projectionID") Long movieTheaterID, @ModelAttribute(name = "projection") Projection projection, Model model, RedirectAttributes redirectAttributes) {
        projectionService.update(projection);
        redirectAttributes.addFlashAttribute("message", "Projection is updated");
        return "redirect:/projection/{projectionID}/view";
    }

    @GetMapping(value = "/{projectionID}/view")
    public ModelAndView view(@PathVariable(name = "projectionID") Long projectionID) {
        ModelAndView modelAndView = new ModelAndView("projection/view");
        modelAndView.addObject("message", "Projection " + projectionID + "!");
        Projection projection = projectionService.findByID(projectionID);
        modelAndView.addObject("projection", projection);

        return modelAndView;
    }

    @GetMapping(value = "/{projectionID}/delete")
    public String delete(@PathVariable(name = "projectionID") Long projectionID, Model model) {
        projectionService.delete(projectionID);
        model.addAttribute("message", "projection " + projectionID + " is deleted!");
        return "redirect:/projection/all";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
