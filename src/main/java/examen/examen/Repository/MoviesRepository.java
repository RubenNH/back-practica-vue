package examen.examen.Repository;

import examen.examen.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MoviesRepository  extends JpaRepository<Movies, Long> {

    //Dinamic query where its possible to search by name, a range of years, director, genre and by publish date this last is just one date not a range
    //these parameters are optional so, often we will have to use only one of them, but its necesary to conbine them for a more specific search.
    //use this is pain :(
    @Query("SELECT m FROM Movies m WHERE (:name IS NULL OR m.name LIKE %:name%)" +
            "AND (:year1 IS NULL OR m.year BETWEEN :year1 AND :year2)" +
            "AND (:director IS NULL OR m.director LIKE %:director%)" +
            "AND (:genre IS NULL OR m.genre.name LIKE %:genre%)" +
            "AND (:publishDate IS NULL OR m.publishDate <= :publishDate) " +
            "ORDER BY CASE WHEN :publishDate IS NOT NULL THEN m.publishDate END DESC")
    List<Movies> findByNameContainingAndYearBetweenAndDirectorContainingAndGenreNameContainingAndPublishDateLessThanEqualOrderByPublishDate(
            @Param("name") String name,
            @Param("year1") Integer year1,
            @Param("year2") Integer year2,
            @Param("director") String director,
            @Param("genre") String genre,
            @Param("publishDate") Date publishDate
    );

}
