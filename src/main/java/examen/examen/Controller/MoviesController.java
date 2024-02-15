package examen.examen.Controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import examen.examen.Model.Genre;
import examen.examen.Model.Movies;
import examen.examen.Service.GenresService;
import examen.examen.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MoviesController {

    @Autowired
    MoviesService moviesService;

    @Autowired
    GenresService genresService;

    @PostMapping("/movies")
    public Movies addMovie(@RequestBody Movies movie) {
        return moviesService.saveMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movies> getMovies() {
        return moviesService.getAllMovies();
    }

    @PostMapping("/genres")
    public Genre addGenre(@RequestBody Genre genre) {
        return genresService.saveGenre(genre);
    }

    @GetMapping("/genres")
    public List<Genre> getGenres() {
        return genresService.getAllGenres();
    }

    // Método para eliminar una película existente
    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable Long id) {
        moviesService.deleteMovie(id);
        return "Movie with ID " + id + " deleted";
    }

    @PutMapping("/movies/{id}")
    public String updateMovie(@PathVariable Long id, @RequestBody Movies updatedMovie) {
        Movies movie = moviesService.getMovieById(id);
        movie.setName(updatedMovie.getName());
        movie.setYear(updatedMovie.getYear());
        movie.setGenre(updatedMovie.getGenre());
        moviesService.saveMovie(movie);
        return "Movie with ID " + id + " updated";
    }

}
