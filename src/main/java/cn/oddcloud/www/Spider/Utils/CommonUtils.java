package cn.oddcloud.www.Spider.Utils;

import cn.oddcloud.www.Utils.DateUtils;

/**
 * Created by vog1g on 2017/5/4.
 */
public class CommonUtils {
    public static String picpath(String path){
        String imagespath=path.split("\\/")[5];
       String paths= "/upload/"+DateUtils.dateToString(System.currentTimeMillis())+"/"+imagespath;
        return paths;
    }
}
