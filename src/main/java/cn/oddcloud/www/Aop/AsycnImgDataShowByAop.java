package cn.oddcloud.www.Aop;

import cn.oddcloud.www.Web.Entity.ImgeAsycnDataShowEnity;
import cn.oddcloud.www.Web.Entity.MovieAopEntity;
import org.aspectj.lang.JoinPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vog1g on 2017/5/22.
 */
public class AsycnImgDataShowByAop {
    public static List<ImgeAsycnDataShowEnity> imgeAsycnDataShowEnities=new ArrayList<>();
    public static BlockingQueue<List<ImgeAsycnDataShowEnity>> imgqueue=new ArrayBlockingQueue(50);

    public void imgafterreturning(JoinPoint joinPoint, Object rex) throws Throwable {
        ImgeAsycnDataShowEnity bloBss= (ImgeAsycnDataShowEnity) rex;
        imgeAsycnDataShowEnities.add(bloBss);
        if (imgeAsycnDataShowEnities.size()==20)
        {
            imgqueue.offer(imgeAsycnDataShowEnities);
            imgeAsycnDataShowEnities=new ArrayList<>();
        }
    }
}
