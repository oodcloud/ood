package cn.oddcloud.www.Web.service;

import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;
import cn.oddcloud.www.Web.Entity.ImgeAsycnDataShowEnity;
import cn.oddcloud.www.Web.Entity.MovieAopEntity;

import java.util.List;

/**
 * Created by vog1g on 2017/4/29.
 */
public interface MovieService {
     MovieAopEntity add(MovieWithBLOBs movie);
     MovieAopEntity repeatadd(MovieWithBLOBs movie);
     List<MovieWithBLOBs> save(List<MovieWithBLOBs> ts);
     int selectplayurl(String mPlayurl,String mClass);
     List<MovieWithBLOBs> selectMoiveOrderByClass(String mClass);
     List<MovieWithBLOBs> selectMoiveOrderByClassMore(String mClass,int page);
     List<MovieWithBLOBs> AllNotSycnImg();
     ImgeAsycnDataShowEnity UpdataAllNotSycnImgVideoData(MovieWithBLOBs origin,MovieWithBLOBs target);
}
