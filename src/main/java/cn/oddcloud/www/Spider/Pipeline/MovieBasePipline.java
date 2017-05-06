package cn.oddcloud.www.Spider.Pipeline;

import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Spider.Utils.CommonUtils;
import cn.oddcloud.www.Spider.Utils.ConfigProperties;
import cn.oddcloud.www.Spider.Utils.RandomNubHits;
import cn.oddcloud.www.Spider.Utils.SycnImgUtils;
import cn.oddcloud.www.Utils.DateUtils;
import cn.oddcloud.www.Utils.DownloadUtils;
import cn.oddcloud.www.Web.service.MovieService;
import com.alibaba.fastjson.JSON;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by vog1g on 2017/5/2.
 */
public class MovieBasePipline implements Pipeline {

    private MovieService movieService;//保存数据库的公共接口
    private String mName;
    private String mSubname;
    private String mPic;
    private String mPicthumb;
    private String mPicslide;
    private String mStarring;
    private String mDirected;
    private String mTag;
    private String mArea;
    private String mLang;
    private Short mYear;
    private Short mType;
    private String mTypeExpand;
    private String mClass;
    private String mTopic;
    private Boolean mHide;
    private Boolean mLock;
    private Integer mState;
    private Boolean mLevel;
    private Integer mHits;
    private Integer mDayhits;
    private Integer mWeekhits;
    private Integer mMonthhits;
    private Short mDuration;
    private BigDecimal mScore;
    private Integer mAddtime;
    private Integer mTime;
    private String mPlayfrom;
    private String mDownfrom;
    private String mContent;
    private String mPlayurl;
    private String mDownurl;
    String isSycnImgflag;
    String imagespath;

    public MovieService getMovieService() {
        return movieService;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmPlayurl() {
        return mPlayurl;
    }

    public String getmDownurl() {
        return mDownurl;
    }

    public String getmName() {
        return mName;
    }

    public String getmSubname() {
        return mSubname;
    }

    public String getmPic() {
        return mPic;
    }

    public String getmPicthumb() {
        return mPicthumb;
    }

    public String getmPicslide() {
        return mPicslide;
    }

    public String getmStarring() {
        return mStarring;
    }

    public String getmDirected() {
        return mDirected;
    }

    public String getmTag() {
        return mTag;
    }

    public String getmArea() {
        return mArea;
    }

    public String getmLang() {
        return mLang;
    }

    public Short getmYear() {
        return mYear;
    }

    public Short getmType() {
        return mType;
    }

    public String getmTypeExpand() {
        return mTypeExpand;
    }

    public String getmClass() {
        return mClass;
    }

    public String getmTopic() {
        return mTopic;
    }

    public Boolean getmHide() {
        return mHide;
    }

    public Boolean getmLock() {
        return mLock;
    }

    public Integer getmState() {
        return mState;
    }

    public Boolean getmLevel() {
        return mLevel;
    }

    public Integer getmHits() {
        return mHits;
    }

    public Integer getmDayhits() {
        return mDayhits;
    }

    public Integer getmWeekhits() {
        return mWeekhits;
    }

    public Integer getmMonthhits() {
        return mMonthhits;
    }

    public Short getmDuration() {
        return mDuration;
    }

    public BigDecimal getmScore() {
        return mScore;
    }

    public Integer getmAddtime() {
        return mAddtime;
    }

    public Integer getmTime() {
        return mTime;
    }

    public String getmPlayfrom() {
        return mPlayfrom;
    }

    public String getmDownfrom() {
        return mDownfrom;
    }

    public MovieBasePipline() {

    }

    @Override
    public  void process(ResultItems resultItems, Task task) {


        Map<String, Object> data = resultItems.getAll();

        ArrayList<String> titles = (ArrayList<String>) JSON.parseArray((String) data.get("title"), String.class);

        ArrayList<String> images = (ArrayList<String>) JSON.parseArray((String) data.get("images"), String.class);

        ArrayList<String> url = (ArrayList<String>) JSON.parseArray((String) data.get("url"), String.class);
        MovieWithBLOBs movieWithBLOBs = null;
        for (int i = 0; i < titles.size(); i++) {
            movieWithBLOBs = new MovieWithBLOBs();
            movieWithBLOBs.setmName(titles.get(i));
            movieWithBLOBs.setmPic(CommonUtils.picpath(images.get(i)));
            movieWithBLOBs.setmPicslide(getmPicslide());
            movieWithBLOBs.setmPicthumb(getmPicthumb());
            movieWithBLOBs.setmArea("大陆");
            movieWithBLOBs.setmLang("国语");
            movieWithBLOBs.setmYear((short) 2017);
            movieWithBLOBs.setmClass(getmClass());
            movieWithBLOBs.setmAddtime(DateUtils.systemTimeToStamp());
            movieWithBLOBs.setmPlayurl(url.get(i));
            movieWithBLOBs.setmPlayfrom("youku");
            movieWithBLOBs.setmSubname(getmSubname());
            movieWithBLOBs.setmStarring("暂无");
            movieWithBLOBs.setmDirected("暂无");
            movieWithBLOBs.setmTag(getmTag());
            movieWithBLOBs.setmType(getmType());
            movieWithBLOBs.setmTypeExpand(getmTypeExpand());
            movieWithBLOBs.setmTopic(getmTopic());
            movieWithBLOBs.setmHits(RandomNubHits.allHits());
            movieWithBLOBs.setmDayhits(RandomNubHits.dayHits());
            movieWithBLOBs.setmWeekhits(RandomNubHits.weekHits());
            movieWithBLOBs.setmMonthhits(RandomNubHits.monthHits());
            movieWithBLOBs.setmDuration(getmDuration());
            movieWithBLOBs.setmScore(getmScore());
            movieWithBLOBs.setmTime(getmTime());
            movieWithBLOBs.setmDownfrom(getmDownfrom());
            movieWithBLOBs.setmDownurl(getmDownurl());

            //同步图片
            if (isSycnImgflag.equals("true"))
            DownloadUtils.DOWN.imgDownUrl(images.get(i), imagespath);

            //入库检查是否存在相同视频 以playurl标准
            int count = getMovieService().selectplayurl(movieWithBLOBs.getmPlayurl(), movieWithBLOBs.getmClass());
            if (count == 0)
                getMovieService().add(movieWithBLOBs);
        }

    }


    public static class Builder {
        private MovieService movieService;//保存数据库的公共接口

        private String mName;
        private String mSubname;
        private String mPic;
        private String mPicthumb;
        private String mPicslide;
        private String mStarring;
        private String mDirected;
        private String mTag;
        private String mArea;
        private String mLang;
        private Short mYear;
        private Short mType;
        private String mTypeExpand;
        private String mClass;
        private String mTopic;
        private Boolean mHide;
        private Boolean mLock;
        private Integer mState;
        private Boolean mLevel;
        private Integer mHits;
        private Integer mDayhits;
        private Integer mWeekhits;
        private Integer mMonthhits;
        private Short mDuration;
        private BigDecimal mScore;
        private Integer mAddtime;
        private Integer mTime;
        private String mPlayfrom;
        private String mDownfrom;
        private String mContent;
        private String mPlayurl;
        private String mDownurl;

        public Builder(MovieService movieService) {
            this.movieService = movieService;
        }

        public Builder setmContent(String mContent) {
            this.mContent = mContent;
            return this;
        }

        public Builder setmPlayurl(String mPlayurl) {
            this.mPlayurl = mPlayurl;
            return this;
        }

        public Builder setmDownurl(String mDownurl) {
            this.mDownurl = mDownurl;
            return this;
        }

        public Builder setmName(String mName) {
            this.mName = mName;
            return this;
        }

        public Builder setmSubname(String mSubname) {
            this.mSubname = mSubname;
            return this;
        }

        public Builder setmPic(String mPic) {
            this.mPic = mPic;
            return this;
        }

        public Builder setmPicthumb(String mPicthumb) {
            this.mPicthumb = mPicthumb;
            return this;
        }

        public Builder setmPicslide(String mPicslide) {
            this.mPicslide = mPicslide;
            return this;
        }

        public Builder setmStarring(String mStarring) {
            this.mStarring = mStarring;
            return this;
        }

        public Builder setmDirected(String mDirected) {
            this.mDirected = mDirected;
            return this;
        }

        public Builder setmTag(String mTag) {
            this.mTag = mTag;
            return this;
        }

        public Builder setmArea(String mArea) {
            this.mArea = mArea;
            return this;
        }

        public Builder setmLang(String mLang) {
            this.mLang = mLang;
            return this;
        }

        public Builder setmYear(Short mYear) {
            this.mYear = mYear;
            return this;
        }

        public Builder setmType(Short mType) {
            this.mType = mType;
            return this;
        }

        public Builder setmTypeExpand(String mTypeExpand) {
            this.mTypeExpand = mTypeExpand;
            return this;
        }

        public Builder setmClass(String mClass) {
            this.mClass = mClass;
            return this;
        }

        public Builder setmTopic(String mTopic) {
            this.mTopic = mTopic;
            return this;
        }

        public Builder setmHide(Boolean mHide) {
            this.mHide = mHide;
            return this;
        }

        public Builder setmLock(Boolean mLock) {
            this.mLock = mLock;
            return this;
        }

        public Builder setmState(Integer mState) {
            this.mState = mState;
            return this;
        }

        public Builder setmLevel(Boolean mLevel) {
            this.mLevel = mLevel;
            return this;
        }

        public Builder setmHits(Integer mHits) {
            this.mHits = mHits;
            return this;
        }

        public Builder setmDayhits(Integer mDayhits) {
            this.mDayhits = mDayhits;
            return this;
        }

        public Builder setmWeekhits(Integer mWeekhits) {
            this.mWeekhits = mWeekhits;
            return this;
        }

        public Builder setmMonthhits(Integer mMonthhits) {
            this.mMonthhits = mMonthhits;
            return this;
        }

        public Builder setmDuration(Short mDuration) {
            this.mDuration = mDuration;
            return this;
        }

        public Builder setmScore(BigDecimal mScore) {
            this.mScore = mScore;
            return this;
        }

        public Builder setmAddtime(Integer mAddtime) {
            this.mAddtime = mAddtime;
            return this;
        }

        public Builder setmTime(Integer mTime) {
            this.mTime = mTime;
            return this;
        }

        public Builder setmPlayfrom(String mPlayfrom) {
            this.mPlayfrom = mPlayfrom;
            return this;
        }

        public Builder setmDownfrom(String mDownfrom) {
            this.mDownfrom = mDownfrom;
            return this;
        }

        public MovieBasePipline newInstance() {
            return new MovieBasePipline(this);
        }


    }

    private MovieBasePipline(Builder builder) {
        mName = builder.mName;
        mSubname = builder.mSubname;
        mPic = builder.mPic;
        mPicthumb = builder.mPicthumb;
        mPicslide = builder.mPicslide;
        mStarring = builder.mStarring;
        mDirected = builder.mDirected;
        mTag = builder.mTag;
        mArea = builder.mArea;
        mLang = builder.mLang;
        mYear = builder.mYear;
        mType = builder.mType;
        mTypeExpand = builder.mTypeExpand;
        mClass = builder.mClass;
        mTopic = builder.mTopic;
        mHide = builder.mHide;
        mLock = builder.mLock;
        mState = builder.mState;
        mLevel = builder.mLevel;
        mHits = builder.mHits;
        mDayhits = builder.mDayhits;
        mWeekhits = builder.mWeekhits;
        mMonthhits = builder.mMonthhits;
        mDuration = builder.mDuration;
        mScore = builder.mScore;
        mAddtime = builder.mAddtime;
        mTime = builder.mTime;
        mPlayfrom = builder.mPlayfrom;
        mDownfrom = builder.mDownfrom;
        mContent = builder.mContent;
        mPlayurl = builder.mPlayurl;
        mDownurl = builder.mDownurl;
        movieService = builder.movieService;
        //获取是否在入库的时候同步下载图片并入库
        isSycnImgflag = ConfigProperties.getIsSycnImg(getClass());
        //图片存取路径
        imagespath=ConfigProperties.getIsSycnImg(getClass(),"imgpath")+File.separator
                +DateUtils.dateToString(System.currentTimeMillis());
    }


}
