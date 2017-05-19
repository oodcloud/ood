package cn.oddcloud.www.Web.service;

import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;

import java.util.List;

/**
 * Created by vog1g on 2017/4/29.
 */
public interface MovieService {
     int add(MovieWithBLOBs movie);
     void save(List<MovieWithBLOBs> ts);
     int selectplayurl(String mPlayurl,String mClass);
     List<MovieWithBLOBs> selectMoiveOrderByClass(String mClass);
     List<MovieWithBLOBs> selectMoiveOrderByClassMore(String mClass,int page);
}
