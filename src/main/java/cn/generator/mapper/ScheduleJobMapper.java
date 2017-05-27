package cn.generator.mapper;



import cn.generator.pojo.ScheduleJob;

import java.util.List;

/**
 * Created by vog1g on 2017/5/26.
 */
public interface ScheduleJobMapper {


    List<ScheduleJob> queryList();

    Long insert(ScheduleJob scheduleJob);

    void update(ScheduleJob scheduleJob);

    ScheduleJob get(Long scheduleJobId);

    void delete(Long scheduleJobId);
}
