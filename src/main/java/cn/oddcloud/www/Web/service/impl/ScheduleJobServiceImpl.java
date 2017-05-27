package cn.oddcloud.www.Web.service.impl;


import cn.generator.mapper.ScheduleJobMapper;
import cn.generator.pojo.ScheduleJob;

import cn.oddcloud.www.Utils.ClassScaner;
import cn.oddcloud.www.Utils.ScheduleUtils;
import cn.oddcloud.www.Web.service.ScheduleJobService;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 定时任务
 *
 * Created by vog1g on 2017/5/26.
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    /** 调度工厂Bean */
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;



    public void initScheduleJob() {
        List<ScheduleJob> scheduleJobList = scheduleJobMapper.queryList();
        if (CollectionUtils.isEmpty(scheduleJobList)) {
            return;
        }
        for (ScheduleJob scheduleJob : scheduleJobList) {

            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobName(),
                scheduleJob.getJobGroup());

            //不存在，创建一个
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            } else {
                //已存在，那么更新相应的定时设置
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }

    public Long insert(ScheduleJob ScheduleJob) {

        ScheduleUtils.createScheduleJob(scheduler, ScheduleJob);
        return scheduleJobMapper.insert(ScheduleJob);
    }

    public void update(ScheduleJob ScheduleJob) {

        ScheduleUtils.updateScheduleJob(scheduler, ScheduleJob);
        scheduleJobMapper.update(ScheduleJob);
    }

//    public void delUpdate(ScheduleJob ScheduleJob) {
//
//        //先删除
//        ScheduleUtils.deleteScheduleJob(scheduler, ScheduleJob.getJobName(), ScheduleJob.getJobGroup());
//        //再创建
//        ScheduleUtils.createScheduleJob(scheduler, ScheduleJob);
//        //数据库直接更新即可
//        scheduleJobMapper.update(ScheduleJob);
//    }

    public void delete(Long scheduleJobId) {
        ScheduleJob scheduleJob = scheduleJobMapper.get(scheduleJobId);
        //删除运行的任务
        ScheduleUtils.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
        //删除数据
        scheduleJobMapper.delete(scheduleJobId);
    }

    public void runOnce(Long scheduleJobId) {

        ScheduleJob scheduleJob = scheduleJobMapper.get(scheduleJobId);
        ScheduleUtils.runOnce(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
    }

    public void pauseJob(Long scheduleJobId) {

        ScheduleJob scheduleJob = scheduleJobMapper.get(scheduleJobId);
        ScheduleUtils.pauseJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());


    }

    public void resumeJob(Long scheduleJobId) {
        ScheduleJob scheduleJob = scheduleJobMapper.get(scheduleJobId);
        ScheduleUtils.resumeJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
    }

    public ScheduleJob get(Long scheduleJobId) {
        ScheduleJob scheduleJob = scheduleJobMapper.get(scheduleJobId);


        return scheduleJob;
    }

    public List<ScheduleJob> queryList(ScheduleJob ScheduleJob) {

        List<ScheduleJob> scheduleJobs = scheduleJobMapper.queryList();


        try {
            for (ScheduleJob vo : scheduleJobs) {

                JobKey jobKey = ScheduleUtils.getJobKey(vo.getJobName(), vo.getJobGroup());
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                if (CollectionUtils.isEmpty(triggers)) {
                    continue;
                }

                //这里一个任务可以有多个触发器， 但是我们一个任务对应一个触发器，所以只取第一个即可，清晰明了
                Trigger trigger = triggers.iterator().next();
                ScheduleJob.setJobTrigger(trigger.getKey().getName());

                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                vo.setStatus(triggerState.name());

                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    vo.setCronExpression(cronExpression);
                }
            }
        } catch (SchedulerException e) {
           e.printStackTrace();
        }
        return scheduleJobs;
    }

    public List<ScheduleJob> queryExecutingJobList() {
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(executingJobs.size());
            for (JobExecutionContext executingJob : executingJobs) {
                ScheduleJob job = new ScheduleJob();
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setJobTrigger(trigger.getKey().getName());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setStatus(triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
            return jobList;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<String> getAllTask() {
        List<String> list=new ArrayList<>();

        ClassScaner scaner = new ClassScaner();
        Set<Class> classes = scaner.doScan("cn.oddcloud.www.Spider.Api");

        for(Iterator<Class> iterator=classes.iterator();iterator.hasNext();)
        {
            Class<?> cls = (Class<?>) iterator.next();

            if (cls.getName().contains("_Spider")) {
                list.add(cls.getName().split("\\.")[6]);
            }
        }


        return list;
    }
}
