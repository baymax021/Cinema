package com.iotek.biz;

import com.iotek.entity.Movie;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IMovieBiz {
    //增加电影
    boolean addMoive(Movie movie);

    //    更新电影信息
    boolean updateMovie(Movie movie);

    //查看所有电影
    List<Movie> allMovies();
    //    按电影id 查找电影
    Movie getMovieById(int id);

    //按名字查看电影
    Movie showMovieByName(String name);

    //    按类型查看电影
    List<Movie> getMoiveByType(String str);

    //查看已经上映过的电影
    List<Movie> getMovieShowed();

    //    按评分高低排行查看电影
    List<Movie> getMovieSort();


}
