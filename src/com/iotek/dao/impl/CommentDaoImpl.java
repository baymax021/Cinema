package com.iotek.dao.impl;

import com.iotek.dao.ICommentDao;
import com.iotek.entity.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by baymax on 2017/8/26.
 * No cross no  crown.
 */
public class CommentDaoImpl extends BaseDao implements ICommentDao {
    @Override
    public boolean addComment(Comment comment) {
        String sql = "insert into comment(user_id,ticket_id,movie_id,comment_content,comment_score) values ((select t.user_id from ticket t where t.id = ? ),?,(select s.movie_id from screening s inner join ticket t where s.id = t.screening_id and t.id = ? ),?,?) ";
        List<Object> params = new ArrayList<>();
        params.add(comment.getTicketId());
        params.add(comment.getTicketId());
        params.add(comment.getTicketId());
        params.add(comment.getCommentContent());
        params.add(comment.getCommentScore());
        return update(sql, params);
    }

    @Override
    public boolean delComment(Comment comment) {
        String sql = "delete from comment where id = ? ";
        List<Object> params = new ArrayList<>();
        params.add(comment.getId());
        return update(sql, params);
    }

    @Override
    public Comment getCommentByTicketId(Comment comment) {
        String sql = "select * from comment where ticket_id = ?";
        List<Object> params = new ArrayList<>();
        params.add(comment.getTicketId());
        List<Comment> res = query(sql, params, Comment.class);
        if (res != null && res.size() > 0) {
            return res.get(0);
        }
        return null;
    }

    @Override
    public List<Comment> getCommentByMovieId(Comment comment) {
        String sql = "select * from comment where movie_id = ?";
        List<Object> params = new ArrayList<>();
        params.add(comment.getMovieId());
        List<Comment> res = query(sql, params, Comment.class);
        if (res != null && res.size()>0) {
            return res;
        }
        return null;
    }

    @Override
    public List<Map<Integer, Object>> commentSort() {
        String sql = "select movie_id,avg(comment_score)  from comment GROUP BY movie_id";
        List<Map<Integer, Object>> list = queryTables(sql, null);
        if (list != null && list.size()>0) {
          return list;
        }
        return null;
    }

    @Override
    public List<Comment> getCommentByUserId(Comment comment) {
        String sql = "select * from comment where user_id = ?";
        List<Object> params = new ArrayList<>();
        params.add(comment.getUserId());
        List<Comment> res = query(sql, params, Comment.class);
        if (res!= null && res.size() > 0) {
            return res;
        }
        return null;
    }
}
