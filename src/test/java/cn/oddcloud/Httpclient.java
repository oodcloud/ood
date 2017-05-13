package cn.oddcloud;

import com.sun.net.httpserver.Headers;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vog1g on 2017/4/25.
 */
 class Httpclients {


    private void downloadurljson(String url) throws Exception{


        org.apache.http.client.HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
//        get.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        get.addHeader("Accept-Encoding","gzip, deflate, sdch");
//        get.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
//        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3018.3 Safari/537.36");
////        get.setHeader("Cookie","juid=01bcl310s4n59; ysestep=1; yseidcount=4; ystep=10; playMode=3; P_pck_rm=QkIXVrlN2w%2B%2BpRzVjVHdgIqX1sGx2xxHaoGC%2B9q1fzU0eflF2RZET7lq%2FqgBLakLilM9lkpb89gMl0N0CjpoNw6ct0U1kxLPvzYwx83AHJVO0c9zB%2FxH92ct32AdA%2BEZ; yktk=AgADAAD%2F%2F%2F%2F%2FAAAA%7C1492610966%7C15%7CaWQ6MTA2Nzc4MTI4Nixubjrohb7orq%2FnlKjmiLc3OTQ1ODI0MTkxLHZpcDpmYWxzZSx5dGlkOjEwNjc3ODEyODYsdGlkOjA%3D%7C20dad7f5507d4f19590ad7223622a455%7C4a1d92ba5ee57390e2fa9d384148405c8605cfd6%7C1; P_gck=NA%7CseNFg52%2FhtB1BqtFe%2FDSDw%3D%3D%7CNA%7C1492610966561; u_id=1067781286; HasLoaded=true; _zpdtk=a5c612b92f448056a7159fd74d0eedba5d6fe5a9; P_sck=5z4Wnf8GSYWny%2BSA7fcwY%2F7yQrh1%2BV42KBCwmxBHLi17PyyNL4bgQztpD2SDYSYdgJSn8GwIP%2BY6aVZWcx%2FrKTaFFvJ7TamD%2BorZf66KU0ZuEBZOyRAav4e6Sny9iT1r; __ysuid=1489893479916xoJ; cna=RqdTEQmk9RsCAXxdxAjbzVmN; l=Aufnn7FoRMBKGKiFZMUqKAU89xG33rky; isg=Au_v5inF6mhF_O5Ud9mCQG9EfgPkJrN52h-K6wF6OdwZUAhSDmSjB01GpPcU");
//        get.setHeader("Cookie","juid=01bcl310s4n59; ysestep=1; yseidcount=4; ystep=10; playMode=3; P_pck_rm=QkIXVrlN2w%2B%2BpRzVjVHdgIqX1sGx2xxHaoGC%2B9q1fzU0eflF2RZET7lq%2FqgBLakLilM9lkpb89gMl0N0CjpoNw6ct0U1kxLPvzYwx83AHJVO0c9zB%2FxH92ct32AdA%2BEZ; yktk=AgADAAD%2F%2F%2F%2F%2FAAAA%7C1492610966%7C15%7CaWQ6MTA2Nzc4MTI4Nixubjrohb7orq%2FnlKjmiLc3OTQ1ODI0MTkxLHZpcDpmYWxzZSx5dGlkOjEwNjc3ODEyODYsdGlkOjA%3D%7C20dad7f5507d4f19590ad7223622a455%7C4a1d92ba5ee57390e2fa9d384148405c8605cfd6%7C1; P_gck=NA%7CseNFg52%2FhtB1BqtFe%2FDSDw%3D%3D%7CNA%7C1492610966561; u_id=1067781286; HasLoaded=true; __ysuid=1489893479916xoJ; cna=RqdTEQmk9RsCAXxdxAjbzVmN; _zpdtk=76b96374b54bce30fab9cb90712b679dce8b1e82; P_sck=5z4Wnf8GSYWny%2BSA7fcwY%2F7yQrh1%2BV42KBCwmxBHLi17PyyNL4bgQztpD2SDYSYdgJSn8GwIP%2BY6aVZWcx%2FrKTaFFvJ7TamD%2BorZf66KU0ZuEBZOyRAav4e6Sny9iT1r; l=Ak1NzycuHhI0ZtL3MsMgGk6S3WPAOoN0; isg=AuLiWbSizzNFA9Nv2p7HCwqrM2hZgeZNn8AXMCx8GNeI_4V5E8NGXMg1WYz5");
        get.setHeader("P3p"," CP=\"CAO PSA OUR\"");
        get.setHeader("Set-Cookie","_zpdtk=367b4c0eb1d3a00fb6fabcf8a74ebbef808ebc93; Domain=www.tudou.com; Path=/");
       get.setHeader("Set-Cookie","P_sck=5z4Wnf8GSYWny%2BSA7fcwY%2F7yQrh1%2BV42KBCwmxBHLi17PyyNL4bgQztpD2SDYSYdgJSn8GwIP%2BY6aVZWcx%2FrKTaFFvJ7TamD%2BorZf66KU0ZuEBZOyRAav4e6Sny9iT1r; Domain=.tudou.com; Path=/; HttpOnly");
        FileImageOutputStream fios = null;
        InputStream in = null;
        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            HttpResponse hr = client.execute(get);
            HttpEntity entity = hr.getEntity();
            in = entity.getContent();
            byte[] buffer = new byte[2048];
            int len = -1;
            while ((len = in.read(buffer)) > 0) {
                baos.write(buffer, 0, len);
            }
            String b = baos.toString();
            System.out.println("内容："+b);

        } catch (IOException e) {
            //异常处理
            if (null != fios) {
                try {
                    fios.close();
                } catch (IOException e1) {

                }
            }

        }

    }

    public static void main(String[] args) throws Exception {

        Httpclients httpclients=new Httpclients();
        httpclients.downloadurljson("http://www.tudou.com/sec/list?secCateId=622736331&pl=24&pn=81");




    }
}
