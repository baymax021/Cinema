package com.iotek.dao;

import com.iotek.entity.Movie;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IMovieDao {
    //    ���ӵ�Ӱ��Ϣ
    boolean addMovie(Movie movie);

    //    ���µ�Ӱ��Ϣ
    boolean updateMovie(Movie movie, int n);

    //    ����Ӱid ���ҵ�Ӱ
    Movie getMovieById(int id);

    //    ������������Ӱ
    Movie getMovieByName(String str);

    //    �����ؼ��ֲ鿴��ص�Ӱ
    List<Movie> getMoiveByKeyword(String str);

    //    �鿴���е�Ӱ
    List<Movie> allMovies();

    // �鿴ָ�����͵ĵ�Ӱ
    List<Movie> getMoiveByType(String type);

    //    ����Ӱ���ֲ�ѯ
    List<Movie> getMoiveSort(String str);

}
