package com.iotek.dao;

import com.iotek.entity.Movie;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IMovieDao {
    //    增加电影信息
    boolean addMovie(Movie movie);

    //    更新电影信息
    boolean updateMovie(Movie movie, int n);

    //    按电影id 查找电影
    Movie getMovieById(int id);

    //    按名字搜索电影
    Movie getMovieByName(String str);

    //    搜索关键字查看相关电影
    List<Movie> getMoiveByKeyword(String str);

    //    查看所有电影
    List<Movie> allMovies();

    // 查看指定类型的电影
    List<Movie> getMoiveByType(String type);

    //    按电影评分查询
    List<Movie> getMoiveSort(String str);

}
