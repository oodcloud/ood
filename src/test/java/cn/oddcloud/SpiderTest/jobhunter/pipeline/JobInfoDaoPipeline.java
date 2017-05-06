package cn.oddcloud.SpiderTest.jobhunter.pipeline;

import cn.oddcloud.SpiderTest.jobhunter.dao.JobInfoDAO;
import cn.oddcloud.SpiderTest.jobhunter.model.LieTouJobInfo;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;


import javax.annotation.Resource;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("JobInfoDaoPipeline")
public class JobInfoDaoPipeline implements PageModelPipeline<LieTouJobInfo> {

    @Resource
    private JobInfoDAO jobInfoDAO;

    @Override
    public void process(LieTouJobInfo lieTouJobInfo, Task task) {
        jobInfoDAO.add(lieTouJobInfo);
    }
}
