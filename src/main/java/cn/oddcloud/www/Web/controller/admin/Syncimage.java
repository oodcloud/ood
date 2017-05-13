package cn.oddcloud.www.Web.controller.admin;

import cn.oddcloud.www.Spider.Utils.ConfigProperties;
import cn.oddcloud.www.Utils.DateUtils;
import cn.oddcloud.www.Utils.DownloadUtils;
import org.apache.log4j.net.SocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vog1g on 2017/5/12.
 */

@Controller
@RequestMapping("/sync")
public class Syncimage {

    @RequestMapping("/index")
    public String  index(){
      String  imagespath= ConfigProperties.getIsSycnImg(getClass(),"imgpath")+ File.separator
                + DateUtils.dateToString(System.currentTimeMillis());
        try {
            ServerSocket serverSocket=new ServerSocket(5000);
            while (true)
            {
                Socket socket= serverSocket.accept();

                OutputStream outputStream=  socket.getOutputStream();




            }


        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        DownloadUtils.DOWN.imgDownUrl("",imagespath);
        return "/admin/syncimage";
    }

}
