package examen.examen.Repository;

import examen.examen.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
