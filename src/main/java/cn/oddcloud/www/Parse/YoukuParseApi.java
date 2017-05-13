package cn.oddcloud.www.Parse;


import cn.oddcloud.www.Utils.JsoupUtils;
import cn.oddcloud.www.Utils.UrlUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vog1g on 2017/4/28.
 */
@Component
public class YoukuParseApi {

    private final static String VIDEO_INFO_API = "http://play-ali.youku.com/play/get.json?vid=%s&ct=12";
    private final static String VIDEO_PLAY = "http://pl.youku.com/playlist/m3u8?vid=%s&type=%s&ts=%s&keyframe=0&ep=%s&sid=%s&token=%s&ctype=12&ev=1&oip=%s";
    private final static String[] TYPE = {"flv", "mp4", "hd2", "hd3"};

    private final static String VID_REGX = "id_(.*?)(_|\\.html)";
    HashMap<String, String> hashMap = new HashMap<>();
    private static int[] e = {19, 1, 4, 7, 30, 14, 28, 8, 24, 17, 6, 35, 34, 16, 9, 10, 13, 22, 32, 29, 31, 21, 18, 3, 2, 23, 25, 27, 11, 20, 5, 15, 12, 0, 33, 26};


    public String parseurl(String url) {

        String vid = getVid(url);
        String api = String.format(VIDEO_INFO_API, vid);
        JSONObject get = JSONObject.parseObject(JsoupUtils.getDocWithPhone(api).text());

        if (get.getJSONObject("data").getJSONObject("security") == null) {
            return "视频不存在";
        }
        JSONObject security = get.getJSONObject("data").getJSONObject("security");
        String encrypt_string = security.getString("encrypt_string");
        String ip = security.getString("ip");
        String result = rc4(translate("b4eto0b4", e), decode64(encrypt_string));
        String[] param = result.split("_");
        String sid = param[0];
        String token = param[1];
        String ep = encode64(rc4(translate("boa4poz1", e), sid + "_" + vid + "_" + token));
        ep = UrlUtils.URLEncodeByUTF8(ep);
        long ts = new Date().getTime() / 1000;


        String videourl = String.format(VIDEO_PLAY, vid, TYPE[2], ts, ep, sid, token, ip);

        System.out.println(videourl);
        return videourl;
    }


    public String parsevidmp4(String vid) {
        String uvid = getVid("http://v.youku.com/v_show/id_" + vid + ".html");
        String api = String.format(VIDEO_INFO_API, uvid);
        String resource = JsoupUtils.getDocWithPhone(api).text();
        JSONObject get = JSONObject.parseObject(resource);
        if (get.getJSONObject("data").getJSONObject("security") == null) {
            return "视频不存在";
        }
        JSONObject security = get.getJSONObject("data").getJSONObject("security");
        String encrypt_string = security.getString("encrypt_string");
        String ip = security.getString("ip");
        String result = rc4(translate("b4eto0b4", e), decode64(encrypt_string));
        String[] param = result.split("_");
        String sid = param[0];
        String token = param[1];
        long ts = new Date().getTime() / 1000;
        JSONArray streams = get.getJSONObject("data").getJSONArray("stream");
        for (int i = 0; i < streams.size(); i++) {

            Map<String, String> stream_type = getStreamType(streams.getJSONObject(i).getString("stream_type"));


            JSONArray segs = streams.getJSONObject(i).getJSONArray("segs");

            for (int j = 0; j < segs.size(); j++) {
                String fileId = segs.getJSONObject(j).getString("fileid");

                String key = segs.getJSONObject(j).getString("key");
                String ep = encode64(rc4(translate("boa4poz1", e), sid + "_" + fileId + "_" + token));
                ep = UrlUtils.URLEncodeByUTF8(ep);
                String vidsa = "http://k.youku.com/player/getFlvPath/sid/" + sid + "_00/st/" + stream_type.get("type") + "/fileid/" + fileId + "?K=" + key + "&hd=0&myp=0&ts=" + ts + "&ypp=0&ep=" + ep + "&ctype=12&ev=1&token=" + token + "&oip=" + ip;
                String data = "http://k.youku.com/player/getFlvPath/sid/0494142325962127de8c9_00/st/mp4/fileid/0300080100590B0A91BFA408D3F34B8E0CB38A-F5FC-8E16-DFC4-6A040883EDA8?K=04f98058009d9f44282c54bc&sign=b0f20d96f47b1665bf949ebbf22e14dd&hd=0&myp=0&ts=300.96&ypp=0&ep=ciadHkiJVM0C4CrZij8bYHi3fCQGXP4J9h%2BFidJjALshQejNmU%2FYxu%2FGP%2FtCHo0aBCECYuOEq6OVaUhlYYZG3xsQ1zupP%2FqUiIPn5asixJQAbhE1B7mmvFSeRjH1&ctype=12&ev=1&token=0514&oip=1931219237";
                System.out.println(vidsa);

            }
        }

        return "";
    }


    public String parsevidhd0mp4(String vid) {
        System.out.println(System.currentTimeMillis()+"-------------------->>>start");

        String vidsa="";
        String uvid = getVid("http://v.youku.com/v_show/id_" + vid + ".html");
        String api = String.format(VIDEO_INFO_API, uvid);
        String resource = JsoupUtils.getDocWithPC(api).text();
        JSONObject get = JSONObject.parseObject(resource);
        if (get.getJSONObject("data").getJSONObject("security") == null) {
            return "视频不存在";
        }
        JSONObject security = get.getJSONObject("data").getJSONObject("security");
        String encrypt_string = security.getString("encrypt_string");
        String ip = security.getString("ip");
        String result = rc4(translate("b4eto0b4", e), decode64(encrypt_string));
        String[] param = result.split("_");
        String sid = param[0];
        String token = param[1];
        long ts = new Date().getTime() / 1000;
        JSONArray streams = get.getJSONObject("data").getJSONArray("stream");
        if (streams==null||streams.isEmpty())
        {
            return "视频不存在";
        }
        JSONArray segs = streams.getJSONObject(2).getJSONArray("segs");
        for (int j = 0; j < segs.size(); j++) {
            String fileId = segs.getJSONObject(j).getString("fileid");
            String key = segs.getJSONObject(j).getString("key");
            String ep = encode64(rc4(translate("boa4poz1", e), sid + "_" + fileId + "_" + token));
            ep = UrlUtils.URLEncodeByUTF8(ep);
             vidsa = "http://k.youku.com/player/getFlvPath/sid/" + sid + "_00/st/mp4/fileid/" + fileId + "?K=" + key + "&hd=0&myp=0&ts=" + ts + "&ypp=0&ep=" + ep + "&ctype=12&ev=1&token=" + token + "&oip=" + ip;
            System.out.println(vidsa);

        }
        System.out.println(System.currentTimeMillis()+"-------------------->>>start");

        return vidsa;
    }


    public String parsevid(String vid) {
        String uvid = getVid("http://v.youku.com/v_show/id_" + vid + ".html");
        String api = String.format(VIDEO_INFO_API, uvid);
        JSONObject get = JSONObject.parseObject(JsoupUtils.getDocWithPhone(api).text());

        if (get.getJSONObject("data").getJSONObject("security") == null) {
            return "视频不存在";
        }

        JSONObject security = get.getJSONObject("data").getJSONObject("security");
        String encrypt_string = security.getString("encrypt_string");
        String ip = security.getString("ip");
        String result = rc4(translate("b4eto0b4", e), decode64(encrypt_string));
        String[] param = result.split("_");
        String sid = param[0];
        String token = param[1];
        String ep = encode64(rc4(translate("boa4poz1", e), sid + "_" + vid + "_" + token));
        ep = UrlUtils.URLEncodeByUTF8(ep);
        long ts = new Date().getTime() / 1000;


        String videourl = String.format(VIDEO_PLAY, vid, TYPE[2], ts, ep, sid, token, ip);

        System.out.println(videourl);
        return videourl;
    }

    private String getVid(String url) {
        Matcher matcher = Pattern.compile(VID_REGX).matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            if (url.contains("tudou.com")) {
                Document document = JsoupUtils.getDocWithPhone(url);
                matcher = Pattern.compile("vcode: '(.*?)'").matcher(document.html());
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        }
        return "";
    }

    private static String decode64(String a) {
        int b, c, f = 0, g, d, e;
        String h = "";
        int[] i = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54,
                55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33,
                34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
        for (g = a.length(); f < g; ) {
            do {
                b = i[255 & (int) a.charAt(f++)];
            } while (f < g && b == -1);
            if (b == -1)
                break;
            do {
                c = i[255 & (int) a.charAt(f++)];
            } while (f < g && c == -1);
            if (c == -1)
                break;
            h += (char) (b << 2 | (48 & c) >> 4);
            do {
                d = 255 & (int) a.charAt(f++);
                if (61 == d) {
                    return h;
                }
                d = i[d];
            } while (f < g && d == -1);
            if (d == -1)
                break;
            h += (char) ((15 & c) << 4 | (60 & d) >> 2);
            do {
                e = 255 & (int) a.charAt(f++);
                if (61 == e)
                    return h;
                e = i[e];
            } while (f < g && e == -1);
            if (e == -1)
                break;
            h += (char) ((3 & d) << 6 | e);
        }
        return h;
    }

    private static String rc4(String a, String b) {
        int c, e = 0, g = 0;
        String f = "";
        int[] d = new int[256];
        for (; g < 256; g++) {
            d[g] = g;
        }
        for (g = 0; g < 256; g++) {
            e = (e + d[g] + a.charAt(g % a.length())) % 256;
            c = d[g];
            d[g] = d[e];
            d[e] = c;
        }
        g = 0;
        e = 0;
        for (int h = 0; h < b.length(); h++) {
            g = (g + 1) % 256;
            e = (e + d[g]) % 256;
            c = d[g];
            d[g] = d[e];
            d[e] = c;
            f += (char) (b.charAt(h) ^ d[(d[g] + d[e]) % 256]);
        }
        return f;
    }

    private static String translate(String a, int[] b) {
        char[] c = new char[26];
        for (int d = 0; d < a.length(); d++) {
            int e;
            boolean flag = (a.charAt(d) >= 'a' && a.charAt(d) <= 'z');
            if (flag) {
                e = (int) a.charAt(d) - (int) 'a';
            } else {
                e = (int) a.charAt(d) - (int) '0' + 26;
            }
            for (int f = 0; f < 36; f++) {
                if (b[f] == e) {
                    e = f;
                    break;
                }
            }
            if (e > 25) {
                c[d] = (char) (e + 22);
            } else {
                c[d] = (char) (e + 97);
            }
        }
        return new String(c).trim();
    }

    private String encode64(String a) {
        int c = 0, d, e, f, g;
        String b = "";
        String h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (d = a.length(); c < d; ) {
            e = 255 & a.charAt(c++);
            if (c == d) {
                b += h.charAt(e >> 2);
                b += h.charAt((3 & e) << 4);
                b += "==";
                break;
            }
            f = a.charAt(c++);
            if (c == d) {
                b += h.charAt(e >> 2);
                b += h.charAt((3 & e) << 4 | (240 & f) >> 4);
                b += h.charAt((15 & f) << 2);
                b += "=";
                break;
            }
            g = a.charAt(c++);
            b += h.charAt(e >> 2);
            b += h.charAt((3 & e) << 4 | (240 & f) >> 4);
            b += h.charAt((15 & f) << 2 | (192 & g) >> 6);
            b += h.charAt(63 & g);
        }
        return b;
    }


    /**
     * 获取视频的格式与描述
     *
     * @return
     */
    Map<String, String> getStreamType(String streamType) {

        switch (streamType) {
            case "mp4hd3":
                hashMap.put("type", "flv");
                hashMap.put("msg", "1080");
                break;

            case "hd3":
                hashMap.put("type", "flv");
                hashMap.put("msg", "1080");
                break;

            case "mp4hd2":
                hashMap.put("type", "flv");
                hashMap.put("msg", "超清");
                break;

            case "hd2":
                hashMap.put("type", "flv");
                hashMap.put("msg", "超清");
                break;
            case "mp4hd":
                hashMap.put("type", "mp4");
                hashMap.put("msg", "高清");
                break;
            case "mp4":
                hashMap.put("type", "mp4");
                hashMap.put("msg", "高清");
                break;

            case "flvhd":
                hashMap.put("type", "flv");
                hashMap.put("msg", "标清");
                break;

            case "flv":
                hashMap.put("type", "flv");
                hashMap.put("msg", "标清");
                break;
            case "3gphd":
                hashMap.put("type", "3gp");
                hashMap.put("msg", "标清(3GP)");
                break;
            default:
                hashMap.put("type", "flv");
                hashMap.put("msg", "标清");
        }
        return hashMap;

    }



}
