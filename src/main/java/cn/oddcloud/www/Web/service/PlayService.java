package cn.oddcloud.www.Web.service;

import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieDiscuss;
import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Parse.YoukuParseEnitity;
import cn.oddcloud.www.Web.Entity.PlayContentEntity;

import java.util.List;

/**
 * Created by vog1g on 2017/5/9.
 */
public interface PlayService {
    List<YoukuParseEnitity.SegsBean> getPlayRealUrl(String url);
    PlayContentEntity getOtherPlayMessage(String url);
    List<MovieDiscuss> getMovieDiscuss(String url);
}
