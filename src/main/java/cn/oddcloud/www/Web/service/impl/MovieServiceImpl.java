package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.MovieMapper;
import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Utils.CommonUtils;
import cn.oddcloud.www.Web.Entity.ImgeAsycnDataShowEnity;
import cn.oddcloud.www.Web.Entity.MovieAopEntity;
import cn.oddcloud.www.Web.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by vog1g on 2017/4/29.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieMapper movieMapper;

    @Override
    public MovieAopEntity add(MovieWithBLOBs movieWithBLOBs) {

        int flag = movieMapper.insert(movieWithBLOBs);
        MovieAopEntity movieAopEntity = new MovieAopEntity();
        movieAopEntity.setMovieWithBLOBs(movieWithBLOBs);
        if (flag == 1) {
            movieAopEntity.setStatus("保存成功！！");
        } else {
            movieAopEntity.setStatus("跳过，可能该数据已经保存到数据库中！");
        }
        return movieAopEntity;
    }

    @Override
    public MovieAopEntity repeatadd(MovieWithBLOBs movieWithBLOBs) {
        MovieAopEntity movieAopEntity = new MovieAopEntity();
        movieAopEntity.setMovieWithBLOBs(movieWithBLOBs);
        movieAopEntity.setStatus("跳过，可能该数据已经保存到数据库中！");
        return movieAopEntity;
    }

    @Override
    public List<MovieWithBLOBs> save(List<MovieWithBLOBs> ts) {

        List<MovieWithBLOBs> bloBss = new ArrayList<>();
        for (int i = 0; i < ts.size(); i++) {
            int flag = movieMapper.insert(ts.get(i));
            if (flag == 1) {
                bloBss.add(ts.get(i));
            }
        }

        return bloBss;
    }

    @Override
    public int selectplayurl(String mPlayurl, String mClass) {
        return movieMapper.selectplayurl(mPlayurl, mClass);
    }

    @Override
    public List<MovieWithBLOBs> selectMoiveOrderByClass(String mClass) {
        return movieMapper.selectMoiveOrderByClass(mClass);
    }

    @Override
    public List<MovieWithBLOBs> selectMoiveOrderByClassMore(String mClass, int page) {
        return movieMapper.selectMoiveOrderByClassMore(mClass, (16 * (page - 1)), 16);
    }

    @Override
    public List<MovieWithBLOBs> AllNotSycnImg() {


        return movieMapper.AllNotSycnImgVideoData();
    }

    @Override
    public ImgeAsycnDataShowEnity UpdataAllNotSycnImgVideoData(MovieWithBLOBs origin,MovieWithBLOBs target) {
        ImgeAsycnDataShowEnity imgeAsycnDataShowEnity=new ImgeAsycnDataShowEnity();
        if (target.getmPic().contains("http://"))//同步失败
        {
            imgeAsycnDataShowEnity.setAsycnImgUrl(CommonUtils.picpath(target.getmPic()));
            imgeAsycnDataShowEnity.setOriginImgUrl(origin.getmPic());
            imgeAsycnDataShowEnity.setStatus("同步失败");
            imgeAsycnDataShowEnity.setTarget(target);
        }else {//同步成功
            movieMapper.UpdataAllNotSycnImgVideoData(target);
            imgeAsycnDataShowEnity.setAsycnImgUrl(target.getmPic());
            imgeAsycnDataShowEnity.setOriginImgUrl(origin.getmPic());
            imgeAsycnDataShowEnity.setStatus("同步成功");
            imgeAsycnDataShowEnity.setTarget(target);
        }

        return imgeAsycnDataShowEnity;
    }


}
