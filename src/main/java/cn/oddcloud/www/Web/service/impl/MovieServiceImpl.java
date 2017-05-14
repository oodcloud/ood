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

    @Override
    public List<String> getVideoClasses() {
        return movieMapper.selectVideoClasses();
    }

    @Override
    public List<String> getVideoAreas() {
        return movieMapper.selectVideoAreas();
    }

    @Override
    public List<String> getVideoLangs() {
        return movieMapper.selectVideoLangs();
    }

    @Override
    public List<String> getVideoPlayfroms() {
        return movieMapper.selectVideoPlayfroms();
    }

    @Override
    public List<MovieWithMovieClass> getDynamicQueryMovieInVideoData(String mclass, String area, String lang, String playfrom, String level, String hide, String key) {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("mclass",mclass);
        hashMap.put("area",area);
        hashMap.put("lang",lang);
        hashMap.put("playfrom",playfrom);
        hashMap.put("level",level);
        hashMap.put("hide",hide);
        hashMap.put("key",key);

        return movieMapper.getDynamicQueryMovieInVideoData(hashMap);
    }

    @Override
    public int getDynamicQueryMovieMoreInVideoDataPageSize(String mclass, String area, String lang, String playfrom, String level, String hide, String key) {
        HashMap<String,String> hashMap=new HashMap<>();
        if (!"".equals(mclass))
            hashMap.put("mclass",mclass);
        if (!"".equals(area))
            hashMap.put("area",area);
        if (!"".equals(lang))
            hashMap.put("lang",lang);
        if (!"".equals(playfrom))
            hashMap.put("playfrom",playfrom);
        if (!"".equals(level))
            hashMap.put("level",level);
        if (!"".equals(hide))
            hashMap.put("hide",hide);
        if (!"".equals(key))
            hashMap.put("key",key);
        return movieMapper.getDynamicQueryMovieMoreInVideoDataPageSize(hashMap)/15;
    }

    @Override
    public List<MovieWithMovieClass> getDynamicQueryMovieMoreInVideoData(String mclass, String area, String lang, String playfrom, String level, String hide, String key, int pageindex) {
        HashMap<String,Object> hashMap=new HashMap<>();
        if (!"".equals(mclass))
            hashMap.put("mclass",mclass);
        if (!"".equals(area))
            hashMap.put("area",area);
        if (!"".equals(lang))
            hashMap.put("lang",lang);
        if (!"".equals(playfrom))
            hashMap.put("playfrom",playfrom);
        if (!"".equals(level))
            hashMap.put("level",level);
        if (!"".equals(hide))
            hashMap.put("hide",hide);
        if (!"".equals(key))
            hashMap.put("key",key);
        hashMap.put("start", 15*(pageindex-1));

        return movieMapper.getDynamicQueryMovieMoreInVideoData(hashMap);
    }

    @Override
    public List<MovieWithMovieClass> getInitDataMovieVideo() {
        return movieMapper.getInitDataMovieVideo();
    }

    @Override
    public int getInitDataMoreMovieVideoPageSize() {
        return movieMapper.getInitDataMoreMovieVideoPageSize()/15;
    }

    @Override
    public List<MovieWithMovieClass> getInitDataMoreMovieVideo(int start, int end) {
        return movieMapper.getInitDataMoreMovieVideo(start, end);
    }


}
