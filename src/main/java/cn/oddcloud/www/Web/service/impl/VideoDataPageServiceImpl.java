package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.MovieMapper;
import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;
import cn.oddcloud.www.Web.Entity.UpdataLevelEntity;
import cn.oddcloud.www.Web.Entity.UpdataSortEntity;
import cn.oddcloud.www.Web.service.VideoDataPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 对应后台的视频数据页面
 * Created by vog1g on 2017/5/14.
 */
@Service
public class VideoDataPageServiceImpl implements VideoDataPageService{
    @Resource
    private MovieMapper movieMapper;
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
    //批量删除
    @Override
    public int DeleteVideoDatas(int[] mids) {


        return movieMapper.DeleteVideoDatas(mids);
    }
    //批量更新推荐
    @Override
    public int UpdataLevelVideoDatas(int[] mids, String level) {
        List<UpdataLevelEntity> levelEntities=new ArrayList<>();
        UpdataLevelEntity updataLevelEntity=null;
        for (int i = 0; i < mids.length; i++) {
            updataLevelEntity=new UpdataLevelEntity();
            updataLevelEntity.setLevel(level);
            updataLevelEntity.setMid(mids[i]);
            levelEntities.add(updataLevelEntity);
        }

        return movieMapper.UpdataLevelVideoDatas(levelEntities);
    }
    //批量更新分类
    @Override
    public int UpdataSortVideoDatas(int[] mids, String msort) {
        List<UpdataSortEntity> levelEntities=new ArrayList<>();
        UpdataSortEntity updataSortEntity=null;
        for (int i = 0; i < mids.length; i++) {
            updataSortEntity=new UpdataSortEntity();
            updataSortEntity.setMclass(msort);
            updataSortEntity.setMid(mids[i]);
            levelEntities.add(updataSortEntity);
        }

        return movieMapper.UpdataSortVideoDatas(levelEntities);
    }

    //修改单个视频数据信息
    @Override
    public int UpdataVideoData(MovieWithBLOBs movieWithBLOBs) {
        return movieMapper.updateByPrimaryKeySelective(movieWithBLOBs);
    }
    //删除单个视频
    @Override
    public int DeleteVideoData(int mid) {
        return movieMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public MovieWithBLOBs selectMovieById(int mid) {
        return movieMapper.selectByPrimaryKey(mid);
    }
}
