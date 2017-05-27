package cn.oddcloud.www.Utils;

import cn.oddcloud.www.Utils.DateUtils;

import java.io.File;

/**
 * Created by vog1g on 2017/5/4.
 */
public class CommonUtils {
    public static String picpath(String path) {
        String imagespath = path.split("\\/")[5];
        String paths = "/images/upload/" + DateUtils.dateToString(System.currentTimeMillis()) + "/" + imagespath;
        return paths;
    }

    public static String checkPicIsFinished(String picurl, Class<?> cls) {
        if (picurl.contains("http://")) {
            return "未同步图片";
        }
        String img = picurl.replace("/images/upload/", "");
        img = ConfigProperties.getIsSycnImg(cls, "imgpath") + File.separator + img;
        System.out.println(img + ">>>>>>>>>>>>>>>>>>>>");
        File file = new File(img);
        boolean result = file.exists();
        if (result) {
            return "同步成功！！";
        } else {
            return "同步失败！！";
        }
    }
}
