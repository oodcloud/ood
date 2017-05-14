package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.MovieMapper;
import cn.generator.pojo.MovieDiscuss;
import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Parse.YoukuParseApi;

import cn.oddcloud.www.Utils.TypeUtils;
import cn.oddcloud.www.Web.Entity.PlayContentEntity;
import cn.oddcloud.www.Web.service.PlayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vog1g on 2017/5/9.
 */
@Service
public class PlayServiceImpl implements PlayService{
    @Resource
    private MovieMapper movieMapper;

    @Resource
    private YoukuParseApi youkuParseApi;

    @Override
    public String getPlayRealUrl(String url) {


        return  youkuParseApi.parsevidhd0mp4(url);
    }

    @Override
    public PlayContentEntity getOtherPlayMessage(String url) {

//        获取其播放页的视频title和与这个相关的视频信息；
        List<MovieWithBLOBs>  movieWithBLOBsList= movieMapper.selectplayorderbyurl(url);
        String videotype=movieWithBLOBsList.get(0).getmClass();//视频类型
        String videoname=  movieWithBLOBsList.get(0).getmName();//视频名字
        String videotypename= TypeUtils.getType(videotype);
        List<MovieWithBLOBs>   otherVideos= movieMapper.selectRandByClass(videotype);
        PlayContentEntity playContentEntity=new PlayContentEntity();
        playContentEntity.setMovieWithBLOBsList(otherVideos);
        playContentEntity.setVideoname(videoname);
        playContentEntity.setVideotypename(videotypename);
        return playContentEntity;
    }

    @Override
    public List<MovieDiscuss> getMovieDiscuss(String url) {
        return null;
    }
}
