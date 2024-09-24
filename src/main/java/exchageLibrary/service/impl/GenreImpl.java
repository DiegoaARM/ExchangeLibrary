package exchageLibrary.service.impl;

import exchageLibrary.model.dao.GenreDao;
import exchageLibrary.model.entity.Genre;
import exchageLibrary.service.IGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreImpl implements IGenre {

    @Autowired
    private GenreDao genreDao;

    @Override
    @Transactional(readOnly = true)
    public Genre findById(Integer id) {
        return genreDao.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public List<Genre> findAll() {
        Iterable<Genre> genresIterable = genreDao.findAll();
        List<Genre> genresList = new ArrayList<>();
        genresIterable.forEach(genresList::add);
        return genresList;
    }

}
