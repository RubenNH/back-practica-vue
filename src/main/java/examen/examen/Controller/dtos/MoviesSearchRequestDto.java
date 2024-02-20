package examen.examen.Controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MoviesSearchRequestDto {
    private String name;
    private Integer year1;
    private Integer year2;
    private String director;
    private String genre;
    private String publishDate;

}
