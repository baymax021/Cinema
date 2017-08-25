package com.iotek.biz;

import com.iotek.entity.Movie;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IMovieBiz {
    //���ӵ�Ӱ
    boolean addMoive(Movie movie);

    //    ���µ�Ӱ��Ϣ
    boolean updateMovie(Movie movie);

    //�鿴���е�Ӱ
    List<Movie> allMovies();
    //    ����Ӱid ���ҵ�Ӱ
    Movie getMovieById(int id);

    //�����ֲ鿴��Ӱ
    Movie showMovieByName(String name);

    //    �����Ͳ鿴��Ӱ
    List<Movie> getMoiveByType(String str);

    //�鿴�Ѿ���ӳ���ĵ�Ӱ
    List<Movie> getMovieShowed();

    //    �����ָߵ����в鿴��Ӱ
    List<Movie> getMovieSort();


}
