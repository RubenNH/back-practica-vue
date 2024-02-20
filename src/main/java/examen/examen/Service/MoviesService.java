package examen.examen.Service;

import examen.examen.Model.Movies;
import examen.examen.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repo;

    public Movies saveMovie(Movies bean){
        return repo.save(bean);
    }

    public List<Movies> getAllMovies(){
        return repo.findAll();
    }

    public Page<Movies> PageOfMovies(Pageable page){
        return repo.findAll(page);
    }

    public void deleteMovie(long id){
        repo.deleteById(id);
    }

    public Movies getMovieById(long id){
        return repo.findById(id).get();
    }

    //use search quare findByNameContainingAndYearBetweenAndGenreNameContainingAndPublishDateBetween
    public List<Movies> searchMovies(String name, Integer year1, Integer year2, String director, String genre, String publishDate) {
        //pass String to Date
        Date publishDateDate = new Date();
        if(publishDate != null){
            publishDateDate = new Date(publishDate);
        }else{
            publishDateDate = null;
        }

        System.out.println("name: " + name);
        return repo.findByNameContainingAndYearBetweenAndDirectorContainingAndGenreNameContainingAndPublishDateLessThanEqualOrderByPublishDate(name, year1, year2, director, genre, publishDateDate);
    }

}

