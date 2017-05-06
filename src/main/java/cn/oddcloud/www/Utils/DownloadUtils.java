package cn.oddcloud.www.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import sun.nio.ch.ThreadPool;

import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vog1g on 2017/4/29.
 */
public enum DownloadUtils {

    DOWN;


    public void imgDownUrl(String imgUri, String directory){

        try {
            new Thread(new DownFile( imgUri,  directory)).start();

        }
        catch (Exception e)
        {
           e.printStackTrace();

        }

    }

    private class DownFile implements Runnable {
        private String imgUri;
        private String directory;


        public DownFile(String imgUri, String directory) {
          this.imgUri=imgUri;
          this.directory=directory;

        }

        @Override
        public void run() {
            try {
                  DownloadUtils.DOWN.downloadImg(imgUri,directory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 下载图片到本地
     * @param imgUri
     * @param directory
     * @return
     */
    private void downloadImg(String imgUri, String directory) throws Exception{


        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(imgUri);
        get.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
         get.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

        FileImageOutputStream fios = null;
        InputStream in = null;
        ByteArrayOutputStream baos = null;

        String fileName=imgUri.split("\\/")[5];
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
            byte[] b = baos.toByteArray();
            //创建目录
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
                File file = new File(dir, fileName);
                if (!file.exists()) {
                    file.createNewFile();
                    fios = new FileImageOutputStream(file);
                    fios.write(b);
                    baos.close();
                    fios.close();
                }
            } else {
                File file = new File(dir, fileName);
                file.createNewFile();
                fios = new FileImageOutputStream(file);
                fios.write(b);
                baos.close();
                fios.close();
            }
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


}
