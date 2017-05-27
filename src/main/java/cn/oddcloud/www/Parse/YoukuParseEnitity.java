package cn.oddcloud.www.Parse;

import java.util.List;

/**
 * Created by vog1g on 2017/5/26.
 */
public class YoukuParseEnitity {


    /**
     * audio_lang : default
     * milliseconds_video : 276599
     * milliseconds_audio : 276480
     * segs : [{"size":15354054,"cdn_url":"http://k.youku.com/player/getFlvPath/sid/0495765312617124bab69/st/flv/fileid/0300020100592543C7C101131B6C6CC10BEB78-7E72-308E-031B-4B378A67BB78?k=78bd330aa6389aa8261fb30b&hd=0&myp=0&ts=276&ymovie=1&ctype=12&ev=1&token=0539&oip=2086519830&ep=ciadH06LU80B5yXejz8bY36zJnEGXP4J9h%2BFg9JjALshQeq6nT2iwO6xTv5DFfhrdFEAY5jwq6KS%0AGEccYfc2rmoQ3E6gTPrg%2FfGR5akhx5cIFx8xAL%2FQvFSeRjP4&ccode=0401&duration=276&expire=18000&psid=0a2d3b963918b7955455502322a714d2&ups_client_netip=124.93.196.22&ups_ts=1495765312&ups_userid=&utid=RqdTEQmk9RsCAXxdxAjbzVmN&vid=XMjc4MzI1NTEyOA%3D%3D&vkey=A8ce5c9f5bbf7132955afa75feb879e12","total_milliseconds_video":276599,"total_milliseconds_audio":276480,"key":"78bd330aa6389aa8261fb30b","fileid":"0300020100592543C7C101131B6C6CC10BEB78-7E72-308E-031B-4B378A67BB78"}]
     * size : 15354054
     * subtitle_lang : default
     * media_type : standard
     * drm_type : default
     * stream_type : flvhd
     * width : 640
     * logo : none
     * m3u8_url : http://pl-ali.youku.com/playlist/m3u8?vid=XMjc4MzI1NTEyOA%3D%3D&type=flv&ups_client_netip=124.93.196.22&ups_ts=1495765312&utid=RqdTEQmk9RsCAXxdxAjbzVmN&ccode=0401&psid=0a2d3b963918b7955455502322a714d2&ckey=&duration=276&expire=18000&ups_key=91062858efa438a9faa9c89b18a151fb
     * height : 360
     * channel_type : tail
     */

    private String audio_lang;
    private int milliseconds_video;
    private int milliseconds_audio;
    private int size;
    private String subtitle_lang;
    private String media_type;
    private String drm_type;
    private String stream_type;
    private int width;
    private String logo;
    private String m3u8_url;
    private int height;
    private String channel_type;
    private List<SegsBean> segs;

    public String getAudio_lang() {
        return audio_lang;
    }

    public void setAudio_lang(String audio_lang) {
        this.audio_lang = audio_lang;
    }

    public int getMilliseconds_video() {
        return milliseconds_video;
    }

    public void setMilliseconds_video(int milliseconds_video) {
        this.milliseconds_video = milliseconds_video;
    }

    public int getMilliseconds_audio() {
        return milliseconds_audio;
    }

    public void setMilliseconds_audio(int milliseconds_audio) {
        this.milliseconds_audio = milliseconds_audio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSubtitle_lang() {
        return subtitle_lang;
    }

    public void setSubtitle_lang(String subtitle_lang) {
        this.subtitle_lang = subtitle_lang;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getDrm_type() {
        return drm_type;
    }

    public void setDrm_type(String drm_type) {
        this.drm_type = drm_type;
    }

    public String getStream_type() {
        return stream_type;
    }

    public void setStream_type(String stream_type) {
        this.stream_type = stream_type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getM3u8_url() {
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

    public List<SegsBean> getSegs() {
        return segs;
    }

    public void setSegs(List<SegsBean> segs) {
        this.segs = segs;
    }

    public static class SegsBean {
        /**
         * size : 15354054
         * cdn_url : http://k.youku.com/player/getFlvPath/sid/0495765312617124bab69/st/flv/fileid/0300020100592543C7C101131B6C6CC10BEB78-7E72-308E-031B-4B378A67BB78?k=78bd330aa6389aa8261fb30b&hd=0&myp=0&ts=276&ymovie=1&ctype=12&ev=1&token=0539&oip=2086519830&ep=ciadH06LU80B5yXejz8bY36zJnEGXP4J9h%2BFg9JjALshQeq6nT2iwO6xTv5DFfhrdFEAY5jwq6KS%0AGEccYfc2rmoQ3E6gTPrg%2FfGR5akhx5cIFx8xAL%2FQvFSeRjP4&ccode=0401&duration=276&expire=18000&psid=0a2d3b963918b7955455502322a714d2&ups_client_netip=124.93.196.22&ups_ts=1495765312&ups_userid=&utid=RqdTEQmk9RsCAXxdxAjbzVmN&vid=XMjc4MzI1NTEyOA%3D%3D&vkey=A8ce5c9f5bbf7132955afa75feb879e12
         * total_milliseconds_video : 276599
         * total_milliseconds_audio : 276480
         * key : 78bd330aa6389aa8261fb30b
         * fileid : 0300020100592543C7C101131B6C6CC10BEB78-7E72-308E-031B-4B378A67BB78
         */

        private int size;
        private String cdn_url;
        private int total_milliseconds_video;
        private int total_milliseconds_audio;
        private String key;
        private String fileid;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getCdn_url() {
            return cdn_url;
        }

        public void setCdn_url(String cdn_url) {
            this.cdn_url = cdn_url;
        }

        public int getTotal_milliseconds_video() {
            return total_milliseconds_video;
        }

        public void setTotal_milliseconds_video(int total_milliseconds_video) {
            this.total_milliseconds_video = total_milliseconds_video;
        }

        public int getTotal_milliseconds_audio() {
            return total_milliseconds_audio;
        }

        public void setTotal_milliseconds_audio(int total_milliseconds_audio) {
            this.total_milliseconds_audio = total_milliseconds_audio;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getFileid() {
            return fileid;
        }

        public void setFileid(String fileid) {
            this.fileid = fileid;
        }
    }
}
