package cn.oddcloud.www.Web.controller.admin.spider_admin;

import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Aop.AsycnImgDataShowByAop;
import cn.oddcloud.www.Aop.MovieDataShowByAop;
import cn.oddcloud.www.Utils.ConfigProperties;
import cn.oddcloud.www.Utils.DateUtils;
import cn.oddcloud.www.Web.Entity.ImgeAsycnDataShowEnity;
import cn.oddcloud.www.Web.Entity.MovieAopEntity;
import cn.oddcloud.www.Web.service.ImgAsycnService;
import cn.oddcloud.www.Web.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vog1g on 2017/5/22.
 */
@Controller
@RequestMapping("/admin/api/spider")
public class ImgBlackDataShowController {

    @Resource
    private MovieService movieService;
    @RequestMapping("/imgdata")
    public String black(Model model){
        String  imagespath= ConfigProperties.getIsSycnImg(getClass(),"imgpath")+ File.separator
                + DateUtils.dateToString(System.currentTimeMillis());
        long realtime=System.currentTimeMillis();
        List<MovieWithBLOBs> movieWithBLOBsList= movieService.AllNotSycnImg();
        System.out.println("查询后时间"+(System.currentTimeMillis()-realtime));

        ImgAsycnService.DOWN.imgDownUrl(movieService,movieWithBLOBsList,imagespath);
        try {
            BlockingQueue<List<ImgeAsycnDataShowEnity>> imgqueue= AsycnImgDataShowByAop.imgqueue;
            if (imgqueue.size()!=0)
            {
                model.addAttribute("data",imgqueue.take());
                model.addAttribute("code", 200);
            }else {
                model.addAttribute("code", 100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "/admin/imgasycndatablack";
    }

    @ResponseBody
    @RequestMapping("/close")
    public void closeconnect(){
        ImgAsycnService.cachedThreadPool.shutdown();
    }
}
