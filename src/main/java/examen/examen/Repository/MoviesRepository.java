package examen.examen.Repository;

import examen.examen.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository  extends JpaRepository<Movies, Long> {

}
