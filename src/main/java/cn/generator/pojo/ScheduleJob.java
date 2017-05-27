package cn.generator.pojo;

import java.util.Date;

/**
 * Created by vog1g on 2017/5/26.
 */
public class ScheduleJob {

    /** 任务id */
    private Long   scheduleJobId;
    /** 任务名称 */
    private String jobName;
    /** 触发器 */
    private String   jobTrigger;

    /** 任务状态 */
    private String   status;
    /** 任务分组 */
    private String jobGroup;

    /** 任务运行时间表达式 */
    private String cronExpression;
    /** 任务描述 */
    private String description;


    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
    private Date              gmtModify;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getJobTrigger() {
        return jobTrigger;
    }

    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getScheduleJobId() {
        return scheduleJobId;
    }

    public void setScheduleJobId(Long scheduleJobId) {
        this.scheduleJobId = scheduleJobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }


    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
