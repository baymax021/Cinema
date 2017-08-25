package com.iotek.dao.impl;

import com.iotek.dao.IMovieDao;
import com.iotek.entity.Movie;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class MovieDaoImpl extends BaseDao implements IMovieDao {
    @Override
    public boolean addMovie(Movie movie) {
        String s = "insert into movie(movie_name,movie_type,movie_price,movie_caption) values (?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(movie.getMovieName());
        params.add(movie.getMovieType());
        params.add(movie.getMoviePrice());
        params.add(movie.getMovieCaption());
        return update(s, params);
    }

    @Override
    public boolean updateMovie(Movie movie, int n) {
        String s;
        List<Object> params = new ArrayList<>();
        switch (n) {
            case 1:
                s = "UPDATE movie SET movie_price = ? WHERE movie_name =?";
                params.add(movie.getMoviePrice());
                params.add(movie.getMovieName());
                return update(s, params);
            case 2:
                s = "UPDATE movie SET movie_type = ? WHERE movie_name =?";
                params.add(movie.getMovieType());
                params.add(movie.getMovieName());
                return update(s, params);
            case 3:
                s = "UPDATE movie SET movie_caption = ? WHERE movie_name =?";
                params.add(movie.getMovieCaption());
                params.add(movie.getMovieName());
                return update(s, params);
            default:
                break;
        }
        return false;
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "select * from movie where movie.id = ?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Movie> result = query(sql, params, Movie.class);
        if (result != null && result.size()> 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public Movie getMovieByName(String name) {
        String sql = "select * from movie where movie_name = ?";
        List<Object> params = new ArrayList<>();
        params.add(name);
        List<Movie> result = query(sql, params, Movie.class);
        if (result != null) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<Movie> getMoiveByKeyword(String str) {
        String sql = "select * from movie where movie_name like '%?%'";
        List<Object> params = new ArrayList<>();
        params.add(str);
        List<Movie> result = query(sql, params, Movie.class);
        return result.size() > 0 ? result : null;
    }

    @Override
    public List<Movie> allMovies() {
        String sql = "select * from movie ";
        List<Movie> result = query(sql, null, Movie.class);
        return result;
    }

    @Override
    public List<Movie> getMoiveByType(String type) {
        String sql = "select * from movie where movie_type = ?";
        List<Object> params = new ArrayList<>();
        params.add(type);
        List<Movie> result = query(sql, params, Movie.class);
        if (result != null) {
            return result;
        }
        return  null;
    }

    @Override
    public List<Movie> getMoiveSort(String str) {
        String sql = "select * from movie inner join comment where commnet.movie_id = movie.id  movie_type = ?";

        return null;
    }
}
