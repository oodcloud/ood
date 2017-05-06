package cn.oddcloud.www.Utils;



import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Url 工具类
 */

public class UrlUtils {

  public static String getDomain(String url){
    String domain = "";
    try {
      URL target = new URL(url);
      domain = target.getHost();
    } catch (MalformedURLException e) {

      e.printStackTrace();
    }
    return domain;
  }

  public static String getTopDomain(String url){
    String domain = "";
    try {
      URL target = new URL(url);
      domain = target.getHost();
      String[] part = domain.split("\\.");
      if (part.length > 2){
        return part[part.length-2] + "." + part[part.length-1];
      }
    } catch (MalformedURLException e) {

      e.printStackTrace();
    }
    return domain;
  }

  public static String adjustUrl(String url){
    if (url.contains("http://")){
      return url;
    }
    return "http://" + url;
  }
  public static String URLEncodeByUTF8(String query) {
    try {
      query = URLEncoder.encode(query, "UTF-8");

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return query;
  }

}
