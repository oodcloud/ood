package cn.oddcloud.www.Web.service;

import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vog1g on 2017/5/14.
 */

public interface VideoDataPageService {



    List<String> getVideoClasses();
    List<String> getVideoAreas();
    List<String> getVideoLangs();
    List<String> getVideoPlayfroms();
    //    后台中视频数据项中的上部分的动态查询
    List<MovieWithMovieClass> getDynamicQueryMovieInVideoData(String mclass, String area, String lang, String playfrom, String level, String hide, String key);
    //获取其查询的数量为了设置分页的数量
    int getDynamicQueryMovieMoreInVideoDataPageSize(String mclass, String area, String lang, String playfrom, String level, String hide, String key);
    //    后台中视频数据项中的上部分的动态查询的分页操作
    List<MovieWithMovieClass> getDynamicQueryMovieMoreInVideoData(String mclass, String area, String lang, String playfrom, String level, String hide, String key, int pageindex);

   //批量删除
    int  DeleteVideoDatas(int[] mids);

    //批量更新推荐
    int  UpdataLevelVideoDatas(int[] mids,String level);

    //批量更新分类
    int  UpdataSortVideoDatas(int[] mids,String msort);
    //修改单个视频数据信息
     int UpdataVideoData(MovieWithBLOBs movieWithBLOBs);
     //删除单个视频
     int DeleteVideoData(int mid);

     MovieWithBLOBs selectMovieById(int mid);

}
