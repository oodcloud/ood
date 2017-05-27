package cn.oddcloud.www.Web.Entity;

import cn.generator.pojo.MovieWithBLOBs;

/**
 * Created by vog1g on 2017/5/22.
 */
public class ImgeAsycnDataShowEnity {
    private String  originImgUrl;
    private String  asycnImgUrl;
    private String status;
    private MovieWithBLOBs target;

    public MovieWithBLOBs getTarget() {
        return target;
    }

    public void setTarget(MovieWithBLOBs target) {
        this.target = target;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginImgUrl() {
        return originImgUrl;
    }

    public void setOriginImgUrl(String originImgUrl) {
        this.originImgUrl = originImgUrl;
    }

    public String getAsycnImgUrl() {
        return asycnImgUrl;
    }

    public void setAsycnImgUrl(String asycnImgUrl) {
        this.asycnImgUrl = asycnImgUrl;
    }
}
