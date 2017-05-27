package cn.oddcloud.www.Web.service;

import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Utils.CommonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vog1g on 2017/4/29.
 */
@Service
public enum ImgAsycnService {

    DOWN;
    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    private  MovieService movieService;

    public void imgDownUrl(MovieService movieService, List<MovieWithBLOBs> movieWithBLOBs, String directory){
          this.movieService=movieService;
        try {

//            new Thread(new DownFile(movieWithBLOBs ,  directory)).start();
            cachedThreadPool.execute(new DownFile(movieWithBLOBs ,  directory));

        }
        catch (Exception e)
        {
           e.printStackTrace();

        }


    }

    private class DownFile implements Runnable {
        private List<MovieWithBLOBs> movieWithBLOBs;
        private String directory;


        public DownFile(List<MovieWithBLOBs> movieWithBLOBs, String directory) {
          this.movieWithBLOBs=movieWithBLOBs;
          this.directory=directory;

        }

        @Override
        public void run() {

            try {

                for (int i = 0; i < movieWithBLOBs.size(); i++) {

                    if (i%20==0)
                    {
                        Thread.sleep(500);
                    }
                    ImgAsycnService.DOWN.downloadImg(movieWithBLOBs.get(i),directory);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void downloadImg(MovieWithBLOBs movieWithBLOBs, String directory) throws Exception{

        File file =null;
        MovieWithBLOBs movieWithBLOBs1=movieWithBLOBs;
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(movieWithBLOBs.getmPic());
        get.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
         get.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        FileImageOutputStream fios = null;
        InputStream in = null;
        ByteArrayOutputStream baos = null;

        String fileName=movieWithBLOBs.getmPic().split("\\/")[5];

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
                 file = new File(dir, fileName);
                if (!file.exists()) {

                    //保存数据库
                    file.createNewFile();
                    fios = new FileImageOutputStream(file);
                    fios.write(b);
                    baos.close();
                    fios.close();
                    if (file.exists()&&file.length()!=0)
                    {
                        movieWithBLOBs1.setmPic(CommonUtils.picpath(movieWithBLOBs.getmPic()));

                        movieService.UpdataAllNotSycnImgVideoData(movieWithBLOBs,movieWithBLOBs1);
                    }else {

                        movieService.UpdataAllNotSycnImgVideoData(movieWithBLOBs,movieWithBLOBs1);

                    }
                }
            } else {
                 file = new File(dir, fileName);
                file.createNewFile();
                fios = new FileImageOutputStream(file);
                fios.write(b);
                //保存数据库
                baos.close();
                fios.close();

                if (file.exists()&&file.length()!=0)
                {
                    movieWithBLOBs1.setmPic(CommonUtils.picpath(movieWithBLOBs.getmPic()));
                    movieService.UpdataAllNotSycnImgVideoData(movieWithBLOBs,movieWithBLOBs1);
                }else {

                    movieService.UpdataAllNotSycnImgVideoData(movieWithBLOBs,movieWithBLOBs1);

                }
            }


    }


}
