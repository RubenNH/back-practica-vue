package examen.examen.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Genre genre;
    private int year;

    @JsonCreator
    public Movies(@JsonProperty("id") int id,
                  @JsonProperty("name") String name,
                  @JsonProperty("genre") Genre genre,
                  @JsonProperty("year") int year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
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


    public Movies() {
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", year=" + year +
                '}';
    }


    public Genre getGenre() {
        return genre;
    }
}
