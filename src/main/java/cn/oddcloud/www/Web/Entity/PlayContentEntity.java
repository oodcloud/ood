package cn.oddcloud.www.Web.Entity;

import cn.generator.pojo.MovieWithBLOBs;

import java.util.List;

/**
 * Created by vog1g on 2017/5/10.
 */
public class PlayContentEntity {
   private List<MovieWithBLOBs> movieWithBLOBsList;
   private String videotypename;
   private String videoname;

    public List<MovieWithBLOBs> getMovieWithBLOBsList() {
        return movieWithBLOBsList;
    }

    public void setMovieWithBLOBsList(List<MovieWithBLOBs> movieWithBLOBsList) {
        this.movieWithBLOBsList = movieWithBLOBsList;
    }

    public String getVideotypename() {
        return videotypename;
    }

    public void setVideotypename(String videotypename) {
        this.videotypename = videotypename;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }
}
