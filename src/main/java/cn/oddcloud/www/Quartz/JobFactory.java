package cn.oddcloud.www.Quartz;


import cn.generator.pojo.ScheduleJob;
import cn.oddcloud.www.Aop.MovieDataShowByAop;
import cn.oddcloud.www.Spider.Api.BaseApiSpider;
import cn.oddcloud.www.Utils.ClassScaner;
import cn.oddcloud.www.Web.controller.admin.spider_admin.SpiderController;
import cn.oddcloud.www.Web.service.MovieService;
import org.aspectj.weaver.bcel.ClassPathManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/**
 * 任务工厂类,非同步
 *
 */

@DisallowConcurrentExecution
public class JobFactory implements Job {


    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(JobFactory.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        MovieService movieService=wac.getBean(MovieService .class);
        LOG.info("JobFactory execute");

        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get(
            "jobParam");

        //反射实现动态调用相关任务
        ClassScaner scaner = new ClassScaner();
        Set<Class> classes = scaner.doScan("cn.oddcloud.www.Spider.Api");
        for (Iterator iterator = classes.iterator(); iterator.hasNext(); ) {
            Class<?> cls = (Class<?>) iterator.next();
            if (cls.getName().contains(scheduleJob.getJobGroup())) {
                for (int i = 0; i < cls.getDeclaredMethods().length; i++) {
                    if (cls.getDeclaredMethods()[i].getName().contains("newInstance"))
                    {
                        Method method = cls.getDeclaredMethods()[i];
                        BaseApiSpider oj = null;
                        try {
                            oj = (BaseApiSpider) method.invoke(null, new Object[]{});
                            oj.doAction(movieService);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }

                    }

                }
                break;
            }
        }
    }
}
