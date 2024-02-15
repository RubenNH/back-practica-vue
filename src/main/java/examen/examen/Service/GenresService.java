package examen.examen.Service;
import examen.examen.Model.Genre;
import examen.examen.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenresService {

    @Autowired
    private GenreRepository repo;

    public List<Genre> getAllGenres(){
        return repo.findAll();
    }

    public Genre saveGenre(Genre bean){
        return repo.save(bean);
    }
}
