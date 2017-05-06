package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.MovieMapper;
import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Web.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vog1g on 2017/4/29.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieMapper movieMapper;
    @Override
    public void add(MovieWithBLOBs movieWithBLOBs) {
        movieMapper.insert(movieWithBLOBs);

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
}
