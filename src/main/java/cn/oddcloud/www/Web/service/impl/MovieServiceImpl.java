package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.MovieMapper;
import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;
import cn.oddcloud.www.Web.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by vog1g on 2017/4/29.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieMapper movieMapper;
    @Override
    public int add(MovieWithBLOBs movieWithBLOBs) {
      return   movieMapper.insert(movieWithBLOBs);

    }

    @Override
    public void save(List<MovieWithBLOBs> ts) {
        for (int i = 0; i < ts.size(); i++) {
            movieMapper.insert(ts.get(i));
        }

    }

    @Override
    public int selectplayurl(String mPlayurl,String mClass) {
       return movieMapper.selectplayurl(mPlayurl,mClass);
    }

    @Override
    public List<MovieWithBLOBs> selectMoiveOrderByClass(String mClass) {
        return movieMapper.selectMoiveOrderByClass(mClass);
    }

    @Override
    public List<MovieWithBLOBs> selectMoiveOrderByClassMore(String mClass, int page) {
        return movieMapper.selectMoiveOrderByClassMore(mClass,(16*(page-1)),16);
    }






}
