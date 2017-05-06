package cn.oddcloud.www.Web.service;

import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieWithBLOBs;

import java.util.List;

/**
 * Created by vog1g on 2017/4/29.
 */
public interface MovieService {
     void add(MovieWithBLOBs movie);
     void save(List<MovieWithBLOBs> ts);
     int selectplayurl(String mPlayurl,String mClass);
}
