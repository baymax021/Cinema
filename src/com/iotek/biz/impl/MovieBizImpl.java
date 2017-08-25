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
        System.out.println("�������Ӱ���ͣ�");
        movie.setMovieType(Input.inputText());
        System.out.println("�������Ӱ���֣�");
        movie.setMovieName(Input.inputText());
        System.out.println("�������Ӱ�۸�");
        movie.setMoviePrice(BigDecimal.valueOf(Input.inputPrice()));
        System.out.println("�������Ӱ��飺");
        movie.setMovieCaption(Input.inputCommnet());
        if (movieDao.addMovie(movie)) {
            System.out.println("���ӳɹ�");
            return true;
        } else {
            System.out.println("����ʧ��");
            return false;
        }
    }

    @Override
    public boolean updateMovie(Movie movie) {
//        ����֮ǰ����������е�Ӱ
        for (Movie movie1 :  movieDao.allMovies()) {
            System.out.println(movie1);
        }
        System.out.println("������Ҫ������Ϣ�ĵ�Ӱ���֣�");
        String s ;
        while (true) {
            s = Input.inputText();
            if (movieDao.getMovieByName(s) == null) {
                System.out.println("����ĵ�Ӱ��������");
            } else {
                break;
            }
        }
        movie.setMovieName(s);
        while (true) {
            System.out.println("��ѡ��Ҫ���µ����ݣ� 1��ӰƱ�۸� 2����Ӱ���� 3����Ӱ��� 0����������");
            int i = Input.inputInt();
            System.out.println("��������º�����ݣ�");
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
                    System.out.println("���½���");
                    return true;
            }
            if (movieDao.updateMovie(movie, i)) {
                System.out.println("���³ɹ�");
            } else {
                System.out.println("����ʧ��");
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
