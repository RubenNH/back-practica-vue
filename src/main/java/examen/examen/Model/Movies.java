package examen.examen.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Genre genre;
    private int year;
    private String director;

    private Date publishDate;

    @JsonCreator
    public Movies(@JsonProperty("id") int id,
                  @JsonProperty("name") String name,
                  @JsonProperty("genre") Genre genre,
                    @JsonProperty("year") int year,
                    @JsonProperty("director") String director,
                    @JsonProperty("publishDate") Date publishDate) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.publishDate = publishDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    public Movies() {
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }


    public Genre getGenre() {
        return genre;
    }
}
