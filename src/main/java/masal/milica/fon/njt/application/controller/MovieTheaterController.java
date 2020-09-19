/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.controller;

import java.util.List;
import javax.validation.Valid;
import masal.milica.fon.njt.application.entity.MovieTheater;
import masal.milica.fon.njt.application.service.MovieTheaterService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Milica
 */
@Controller
@RequestMapping(value = "/movietheater")
public class MovieTheaterController {

    private final MovieTheaterService movieTheaterService;

    @Autowired
    public MovieTheaterController(MovieTheaterService movieTheaterService) {
        this.movieTheaterService = movieTheaterService;
    }

    @GetMapping(value = "/add")
    public String addMovieTheater() {
        return "movietheater/add";
    }

    @GetMapping(value = "/all")
    public String allMovieTheaters(Model model) {
        model.addAttribute("message", "All movie theaters");
        return "movietheater/all";
    }

    @PostMapping(value = "/save")
    public String save(@Validated @ModelAttribute(name = "movieTheater") MovieTheater movieTheater, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("movieTheater", movieTheater);
            return "movietheater/add";
        } else {
            movieTheaterService.save(movieTheater);
            redirectAttributes.addFlashAttribute("message", "Movie theater is saved");
            return "redirect:/movietheater/add";
        }
    }

    @RequestMapping(value = "/{movieTheaterID}/update")
    public String update(@PathVariable(name = "movieTheaterID") Long movieTheaterID, @ModelAttribute(name = "movieTheater") MovieTheater mt, Model model, RedirectAttributes redirectAttributes) {
        movieTheaterService.update(mt);
        redirectAttributes.addFlashAttribute("message", "Movie theater is updated!");
        return "redirect:/movietheater/{movieTheaterID}/view";
    }

    @ModelAttribute(name = "movieTheater")
    private MovieTheater getMovieTheater() {
        return new MovieTheater("", "");
    }

    @ModelAttribute(name = "movieTheaters")
    private List<MovieTheater> getAllMovieTheaters() {
        return movieTheaterService.getAll();
    }

    @GetMapping(value = "/{movieTheaterID}/view")
    public String view(@PathVariable(name = "movieTheaterID") Long movieTheaterID, Model model) {
        model.addAttribute("message", "Movie theater " + movieTheaterID + "!");
        MovieTheater mt = movieTheaterService.findByID(movieTheaterID);
        model.addAttribute("movieTheater", mt);
        return "movietheater/view";
    }

    @GetMapping(value = "/{movieTheaterID}/delete")
    public String delete(@PathVariable(name = "movieTheaterID") Long movieTheaterID, Model model) {
        movieTheaterService.delete(movieTheaterID);
        model.addAttribute("message", "Movie theater " + movieTheaterID + " is deleted!");
        return "redirect:/movietheater/all";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
