/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masal.milica.fon.njt.application.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import masal.milica.fon.njt.application.entity.Genre;
import masal.milica.fon.njt.application.entity.Movie;
import masal.milica.fon.njt.application.service.GenreService;
import masal.milica.fon.njt.application.service.MovieService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Milica
 */
@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;

    @Autowired
    public MovieController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @GetMapping(value = "/add")
    public String addMovie() {
        return "movie/add";
    }

    @GetMapping(value = "/all")
    public String allMovies(Model model) {
        model.addAttribute("message", "All movies!");

        return "movie/all";
    }

    @ModelAttribute(value = "movie")
    private Movie getMovie() {
        return new Movie();
    }

    @ModelAttribute(name = "Allgenres")
    private List<Genre> getAllGenres() {
        return genreService.getAll();
    }

    @ModelAttribute(name = "movies")
    private List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping(value = "/save")
    public String save(HttpServletRequest servletRequest, @Validated @ModelAttribute(name = "movie") Movie movie, BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        MultipartFile files = movie.getImages();

        String filename;
        if (files != null) {
            filename = files.getOriginalFilename();
            File imageDi = new File(servletRequest.getServletContext().getRealPath("/WEB-INF/"), "image");
            imageDi.mkdirs();

            File imageFile = new File(imageDi, filename);
            try {

                imageFile.createNewFile();
                files.transferTo(imageFile);
                movie.setImageURL(filename);

            } catch (IOException ex) {
                Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (result.hasErrors()) {
            model.addAttribute("message", "An error occurred during saving project");
            model.addAttribute("movie", movie);
            return "movie/add";
        } else {
            movie.setCreatedByUser(request.getUserPrincipal().getName());
            movieService.save(movie);
            redirectAttributes.addFlashAttribute("message", "An error occurred during saving movie");
            return "redirect:/movie/add";
        }
    }

    @GetMapping(value = "/{movieid}/view")
    public ModelAndView view(@PathVariable(name = "movieid") Long movieid) {
        ModelAndView modelAndView = new ModelAndView("movie/view");
        modelAndView.addObject("message", "Movie " + movieid + "!");
        Movie movie = (Movie) movieService.findByID(movieid);
        movie.getGenres().size();
        modelAndView.addObject("movie", movie);
        modelAndView.addObject("genres", movie.getGenres());

        return modelAndView;
    }

    @RequestMapping(value = "/{movieid}/delete")
    public String delete(@PathVariable(name = "movieid") Long movieid, Model model) {
        movieService.delete(movieid);
        model.addAttribute("message", "Movie " + movieid + " is deleted!");
        return "redirect:/movie/all";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
