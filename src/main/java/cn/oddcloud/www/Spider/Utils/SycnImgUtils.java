package cn.oddcloud.www.Spider.Utils;

import cn.oddcloud.www.Utils.DownloadUtils;

/**
 * Created by vog1g on 2017/5/4.
 */
public class SycnImgUtils {


    //获取是否在入库的时候同步下载图片并入库
    public static String isSycnImgflag(Class<?> cls){
        String isSycnImgflag= ConfigProperties.getIsSycnImg(cls);
        return isSycnImgflag;
    }



}
