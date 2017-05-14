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
     List<String> getVideoClasses();
     List<String> getVideoAreas();
     List<String> getVideoLangs();
     List<String> getVideoPlayfroms();
     //    后台中视频数据项中的上部分的动态查询
     List<MovieWithMovieClass>  getDynamicQueryMovieInVideoData(String mclass, String area, String lang, String playfrom, String level, String hide, String key);
     //获取其查询的数量为了设置分页的数量
     int getDynamicQueryMovieMoreInVideoDataPageSize(String mclass, String area, String lang, String playfrom, String level, String hide, String key);
     //    后台中视频数据项中的上部分的动态查询的分页操作
     List<MovieWithMovieClass> getDynamicQueryMovieMoreInVideoData(String mclass, String area, String lang, String playfrom, String level, String hide, String key, int pageindex);


     //    初始化后台视频数据中的最初加载页面
     List<MovieWithMovieClass> getInitDataMovieVideo();
     //获取其查询的数量为了设置分页的数量
     int getInitDataMoreMovieVideoPageSize();
     //    初始化后台视频数据中的最初加载页面的分页操作
     List<MovieWithMovieClass> getInitDataMoreMovieVideo(int start, int end);


}
