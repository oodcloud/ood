package cn.oddcloud.www.Spider.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by vog1g on 2017/5/3.
 */
public class ConfigProperties {
    public static String type(String name,Class<?> cls){
          Properties properties=new Properties();
        try {
            properties.load(cls.getClassLoader().getResourceAsStream("properties/SortExplain.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(name);
    }
    public static String getIsSycnImg(Class<?> cls){
        Properties properties=new Properties();
        try {
            properties.load(cls.getClassLoader().getResourceAsStream("./properties/isSynchronizedImge.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("imgsyn");
    }

    public static String getIsSycnImg(Class<?> cls,String name){
        Properties properties=new Properties();
        try {
            properties.load(cls.getClassLoader().getResourceAsStream("./properties/isSynchronizedImge.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(name);
    }


}
