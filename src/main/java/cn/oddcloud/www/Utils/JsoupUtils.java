package cn.oddcloud.www.Utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Jsoup 工具类
 */

public class JsoupUtils {
  private static final String UA_PHONE = "Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Safari/537.36";
  private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";
  private static final int TIME_OUT = 10 * 1000;

  public static Document getDocWithPC(String url){
    Document document = new Document("http://ictgu.cn");
    try {
      document = Jsoup.connect(url).userAgent(UA_PC).timeout(TIME_OUT).ignoreContentType(true).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return document;
  }

  public static Document getDocWithPhone(String url){
    Document document = new Document("http://ictgu.cn");
    try {
      document = Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).ignoreContentType(true).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return document;
  }

  public static Document getDocWithPhone(String url, String cookie){
    Document document = new Document("http://ictgu.cn");
    try {
      document = Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).header("Cookie", cookie).ignoreContentType(true).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return document;
  }

  public static Document getDocWithPC(String url, String cookie){
    Document document = new Document("http://ictgu.cn");
    try {
      document = Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).header("Cookie", cookie).ignoreContentType(true).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return document;
  }
}
