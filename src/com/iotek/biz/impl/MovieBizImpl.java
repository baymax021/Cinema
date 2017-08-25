package com.iotek.biz.impl;

import com.iotek.biz.IMovieBiz;
import com.iotek.dao.IMovieDao;
import com.iotek.dao.impl.MovieDaoImpl;
import com.iotek.entity.Movie;
import com.iotek.util.Input;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class MovieBizImpl implements IMovieBiz {
    private IMovieDao movieDao = null;

    public MovieBizImpl() {
        movieDao = new MovieDaoImpl();
    }

    @Override
    public boolean addMoive(Movie movie) {
        System.out.println("请输入电影类型：");
        movie.setMovieType(Input.inputText());
        System.out.println("请输入电影名字：");
        movie.setMovieName(Input.inputText());
        System.out.println("请输入电影价格：");
        movie.setMoviePrice(BigDecimal.valueOf(Input.inputPrice()));
        System.out.println("请输入电影简介：");
        movie.setMovieCaption(Input.inputCommnet());
        if (movieDao.addMovie(movie)) {
            System.out.println("增加成功");
            return true;
        } else {
            System.out.println("增加失败");
            return false;
        }
    }

    @Override
    public boolean updateMovie(Movie movie) {
//        更新之前遍历输出所有电影
        for (Movie movie1 :  movieDao.allMovies()) {
            System.out.println(movie1);
        }
        System.out.println("请输入要更新信息的电影名字：");
        String s ;
        while (true) {
            s = Input.inputText();
            if (movieDao.getMovieByName(s) == null) {
                System.out.println("输入的电影名字有误");
            } else {
                break;
            }
        }
        movie.setMovieName(s);
        while (true) {
            System.out.println("请选择要更新的内容： 1、影票价格 2、电影类型 3、电影简介 0、结束更新");
            int i = Input.inputInt();
            System.out.println("请输入更新后的内容：");
            switch (i) {
                case 1:
                    movie.setMoviePrice(BigDecimal.valueOf(Input.inputPrice()));
                    break;
                case 2:
                    movie.setMovieType(Input.inputText());
                    break;
                case 3:
                    movie.setMovieCaption(Input.inputCommnet());
                    break;
                case 0:
                    System.out.println("更新结束");
                    return true;
            }
            if (movieDao.updateMovie(movie, i)) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        }
    }

    @Override
    public List<Movie> allMovies() {
        return movieDao.allMovies();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public Movie showMovieByName(String name) {
        return movieDao.getMovieByName(name);
    }

    @Override
    public List<Movie> getMoiveByType(String type) {
        return movieDao.getMoiveByType(type);
    }

    @Override
    public List<Movie> getMovieShowed() {
        return null;
    }

    @Override
    public List<Movie> getMovieSort() {
        return null;
    }
}
