//package cn.oddcloud;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.client.HttpClient;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
//import java.io.*;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// * Created by vog1g on 2017/4/25.
// */
//public class porn91 {
//
//    private static String cookie = "incap_ses_401_649914=31EbXVOgx0r6Ql5TmqOQBdjxdFcAAAAAu7MrrqICFZvpjsIw5VriGQ==; incap_ses_434_649914=wx2HcnWH7GDQCChRweAFBt/xdFcAAAAAczn9Ohl2VBPqxEd8kRi2GA==; incap_ses_407_649914=U4VYNM5iO1l1H0VP7/SlBWXydFcAAAAAifL73Yq/OnIgRqKWiWPqUg==; incap_ses_406_649914=8Ub/DfvqEGs9L9gFemeiBWEKdVcAAAAA+aBeDqKyWw37Sv+KZ4cdlA==; incap_ses_432_649914=bLzAYBXvVG0kSU6wyMX+BWUKdVcAAAAAZW+uykXgylzu/dZOu7IDWw==; _ga=GA1.2.1738858661.1466764840; _gat=1; visid_incap_649914=2hb3ym0OQ9C7sr1krqKCQTUObVcAAAAAQUIPAAAAAADQQCM/QP5jhCXO3+mlIKmg; incap_ses_199_649914=RkWbbfybyCoL2fxKs/3CAqIbdVcAAAAAOa+RJFdt35NV8xtM8MbP8Q==; session=eyJfZnJlc2giOmZhbHNlLCJjc3JmX3Rva2VuIjp7IiBiIjoiTkdFek9HRmtNakkxTldVM05EVXpZMkZoTldKaE5tWXpOV014TlRBNU1UZ3dPVGcyTkRNMU5BPT0ifX0.ClatMQ.INJmWYMZ8T220CgsSTcfpHhTxXI";
//    private static String cookie2 = "incap_ses_401_649914=31EbXVOgx0r6Ql5TmqOQBdjxdFcAAAAAu7MrrqICFZvpjsIw5VriGQ==; incap_ses_434_649914=wx2HcnWH7GDQCChRweAFBt/xdFcAAAAAczn9Ohl2VBPqxEd8kRi2GA==; incap_ses_407_649914=U4VYNM5iO1l1H0VP7/SlBWXydFcAAAAAifL73Yq/OnIgRqKWiWPqUg==; incap_ses_406_649914=8Ub/DfvqEGs9L9gFemeiBWEKdVcAAAAA+aBeDqKyWw37Sv+KZ4cdlA==; incap_ses_432_649914=bLzAYBXvVG0kSU6wyMX+BWUKdVcAAAAAZW+uykXgylzu/dZOu7IDWw==; _ga=GA1.2.1738858661.1466764840; _gat=1; visid_incap_649914=2hb3ym0OQ9C7sr1krqKCQTUObVcAAAAAQUIPAAAAAADQQCM/QP5jhCXO3+mlIKmg; incap_ses_199_649914=RkWbbfybyCoL2fxKs/3CAqIbdVcAAAAAOa+RJFdt35NV8xtM8MbP8Q==; session=eyJfZnJlc2giOmZhbHNlLCJjc3JmX3Rva2VuIjp7IiBiIjoiTkdFek9HRmtNakkxTldVM05EVXpZMkZoTldKaE5tWXpOV014TlRBNU1UZ3dPVGcyTkRNMU5BPT0ifX0.ClatMw.6MGC1jX7mgjsChpGFBd-xHTv9ZU";
//
//    private static String Token = "1467296187##60ecf40d9328862cc6cd6a478adfc72ee0554050";
//
//    private static String Url = "http://freeget.co/video/extraction";
//    private static String url001 = null;
//    private static String dirfile = "F:/91porn/91url.csv";
//    private static String destfile = "F:/91porn/data.txt";
//
//    private static int cnt0 = 0;
//
//    private static String num = null;
//    private static String title = null;
//    private static String time = null;
//    private static String longtime = null;
//    private static String viewnum = null;
//    private static String Parurl = null;// "http://www.91porn.com/view_video.php?viewkey=c5ec60d0da8c8fbdb180&page=4&viewtype=basic&category=mr";
//
//    public static void main(String[] args) throws InterruptedException {
//
//        File file = new File(dirfile);
//        FileReader reader = null;
//        BufferedReader br = null;
//        try {
//            reader = new FileReader(file);
//            br = new BufferedReader(reader);
//            String str = null;
//            String[] strArr = null;
//            int cnt = 0;
//            while ((str = br.readLine()) != null) {
//                // System.out.println(str);
//                strArr = str.split(",");
//                if (strArr.length != 7)
//                    continue;
//                num = strArr[0];
//                title = strArr[1];
//                time = strArr[2];
//                longtime = strArr[4];
//                viewnum = strArr[5];
//                Parurl = strArr[6];
//                cnt++;
//                System.out.println(num + "," + title + "," + time);
//                func_step1();
//            }
//            System.out.println("采集结束,总共：" + cnt + "条,成功写入" + cnt0 + "条");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (Exception e2) {
//                    // TODO: handle exception
//                    e2.printStackTrace();
//                }
//            }
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (Exception e2) {
//                    // TODO: handle exception
//                    e2.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private static void func_step1() {
//        HttpClient httpClient = new HttpClient();
//        try {
//            PostMethod postMethod = new PostMethod(Url);
//            postMethod.getParams().setContentCharset("utf-8");
//            // 每次访问需授权的网址时需 cookie 作为通行证
//            postMethod.setRequestHeader("cookie", cookie);
//            postMethod.setRequestHeader("X-CSRFToken", Token);
//            postMethod.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.8");
//            postMethod.setRequestHeader("Host", "freeget.co");
//            postMethod.setRequestHeader("Referer", "http://freeget.co/");
//            postMethod.setRequestHeader("User-Agent",
//                    "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0) QQBrowser/9.2.5063.400");
//            postMethod.setParameter("url", Parurl);
//            int statusCode = httpClient.executeMethod(postMethod);// 返回状态码200为成功，500为服务器端发生运行错误
//            System.out.println("返回状态码：" + statusCode);
//            // 打印出返回数据，检验一下是否成功
//            String result = postMethod.getResponseBodyAsString();
//            if (statusCode == 200) {
//                // 解析成功，取得token和view_key
//                JSONObject a = new JSONObject(result);
//                url001 = "http://freeget.co/video/" + a.get("view_key") + "/" + a.get("token");
//                System.out.println("视频解析地址：" + url001);
//                func_step2(url001);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void func_step2(String url) {
//        HttpClient httpClient = new HttpClient();
//        try {
//            GetMethod getMethod = new GetMethod(url);
//            getMethod.getParams().setContentCharset("utf-8");
//            getMethod.setRequestHeader("cookie", cookie2);
//            getMethod.setRequestHeader("Accept-Language", "zh-cn");
//            getMethod.setRequestHeader("User-Agent",
//                    "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0) QQBrowser/9.2.5063.400");
//            int statusCode = httpClient.executeMethod(getMethod);// 返回状态码200为成功，500为服务器端发生运行错误
//            // System.out.println("返回状态码：" + statusCode);
//            // 打印出返回数据，检验一下是否成功
//            InputStream inputStream = getMethod.getResponseBodyAsStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuffer stringBuffer = new StringBuffer();
//            String str = "";
//            while ((str = br.readLine()) != null) {
//                stringBuffer.append(str);
//            }
//            if (statusCode == 200) {
//                Document doc = Jsoup.parse(stringBuffer.toString());
//                Elements name = doc.select("a");
//                String playurl = name.get(4).text();
//                System.out.println("在线播放地址：" + playurl);
//                writefile(playurl);
//                cnt0++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void writefile(String url) {
//        FileWriter fw = null;
//        BufferedWriter bw = null;
//        PrintWriter pw = null;
//        try {
//            fw = new FileWriter(new File(destfile), true);
//            bw = new BufferedWriter(fw);
//            pw = new PrintWriter(bw);
//            pw.write(num + "," + title + ","+time + ","+longtime + ","+viewnum + ","+url + "\r\n");
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (pw != null) {
//                pw.close();
//            }
//            if (bw != null) {
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public List<Porn> QueryAllBook() {
//        java.sql.Connection connection = DBConnection.getConnection();
//        String sql = "select * from porn where status=0";
//        java.sql.PreparedStatement pstmt = DBConnection.getPreparedStatement(connection, sql);
//        List<Porn> pornlist = new ArrayList<Porn>();
//        System.out.println(sql);
//        try {
//            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            java.sql.ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                Porn porn = new Porn();
//                porn.setNum(rs.getString(1));
//                porn.setTitle(rs.getString(2));
//                porn.setTime(rs.getString(3));
//                porn.setViewkey(rs.getString(4));
//                porn.setLongtime(rs.getString(5));
//                porn.setViewnum(rs.getString(6));
//                porn.setParurl(rs.getString(7));
//                pornlist.add(porn);
//            }
//            rs.last();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnection.close(connection, pstmt, null);
//        }
//        return pornlist;
//    }
//}