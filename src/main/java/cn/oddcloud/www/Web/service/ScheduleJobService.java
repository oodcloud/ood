package cn.oddcloud.www.Web.service;

import cn.generator.pojo.ScheduleJob;

import java.util.List;

/**
 * 定时任务service
 *Created by vog1g on 2017/5/26.
 */
public interface ScheduleJobService {

    /**
     * 初始化定时任务
     */
    public void initScheduleJob();

    /**
     * 新增
     * 
     * @param scheduleJobVo
     * @return
     */
    public Long insert(ScheduleJob scheduleJobVo);

    /**
     * 直接修改 只能修改运行的时间，参数、同异步等无法修改
     * 
     * @param scheduleJobVo
     */
    public void update(ScheduleJob scheduleJobVo);

//    /**
//     * 删除重新创建方式
//     *
//     * @param scheduleJobVo
//     */
//    public void delUpdate(ScheduleJob scheduleJobVo);

    /**
     * 删除
     * 
     * @param scheduleJobId
     */
    public void delete(Long scheduleJobId);

    /**
     * 运行一次任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    public void runOnce(Long scheduleJobId);

    /**
     * 暂停任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    public void pauseJob(Long scheduleJobId);

    /**
     * 恢复任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    public void resumeJob(Long scheduleJobId);

    /**
     * 获取任务对象
     * 
     * @param scheduleJobId
     * @return
     */
    public ScheduleJob get(Long scheduleJobId);

    /**
     * 查询任务列表
     * 
     * @param scheduleJobVo
     * @return
     */
    public List<ScheduleJob> queryList(ScheduleJob scheduleJobVo);

    /**
     * 获取运行中的任务列表
     *
     * @return
     */
    public List<ScheduleJob> queryExecutingJobList();

    public List<String> getAllTask();

}
