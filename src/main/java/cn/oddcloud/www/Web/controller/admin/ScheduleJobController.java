package cn.oddcloud.www.Web.controller.admin;



import cn.generator.pojo.ScheduleJob;
import cn.oddcloud.www.Web.service.ScheduleJobService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *  Created by vog1g on 2017/5/26.
 */
@Controller
@RequestMapping("/admin/schedulejob/")
public class ScheduleJobController {

    /** job service */
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 任务页面
     *
     * @return
     */
    @RequestMapping(value = "inputschedulejob", method = RequestMethod.GET)
    public String inputScheduleJob(ScheduleJob ScheduleJob, Model model) {
        List<String> Tasks=scheduleJobService.getAllTask();
        if (ScheduleJob.getScheduleJobId() != null) {
            ScheduleJob scheduleJob = scheduleJobService.get(ScheduleJob.getScheduleJobId());

            scheduleJob.setDescription(ScheduleJob.getDescription());
            model.addAttribute("ScheduleJob", scheduleJob);
        }
        model.addAttribute("Task",Tasks);

        return "/admin/inputschedulejob";
    }

    /**
     * 删除任务
     *
     * @return
     */
    @RequestMapping(value = "deleteschedulejob", method = RequestMethod.GET)
    public String deleteScheduleJob(Long scheduleJobId) {

        scheduleJobService.delete(scheduleJobId);

        return "redirect:/admin/schedulejob/listschedulejob";
    }

    /**
     * 运行一次
     *
     * @return
     */
    @RequestMapping(value = "runonceschedulejob", method = RequestMethod.GET)
    public String runOnceScheduleJob(Long scheduleJobId) {

        scheduleJobService.runOnce(scheduleJobId);

        return "redirect:/admin/schedulejob/listschedulejob";
    }

    /**
     * 暂停
     *
     * @return
     */
    @RequestMapping(value = "pauseschedulejob", method = RequestMethod.GET)
    public String pauseScheduleJob(Long scheduleJobId) {
        scheduleJobService.pauseJob(scheduleJobId);
        return "redirect:/admin/schedulejob/listschedulejob";
    }

    /**
     * 恢复
     *
     * @return
     */
    @RequestMapping(value = "resumeschedulejob", method = RequestMethod.GET)
    public String resumeScheduleJob(Long scheduleJobId) {
        scheduleJobService.resumeJob(scheduleJobId);
        return "redirect:/admin/schedulejob/listschedulejob";
    }

    /**
     * 保存任务
     *
     * @param ScheduleJob
     * @return
     */
    @RequestMapping(value = "saveschedulejob", method = RequestMethod.POST)
    public String saveScheduleJob(ScheduleJob ScheduleJob) {
        ScheduleJob.setStatus("1");
        if (ScheduleJob.getScheduleJobId() == null) {
            scheduleJobService.insert(ScheduleJob);
        } else {
            scheduleJobService.update(ScheduleJob);
        }
        return "redirect:/admin/schedulejob/listschedulejob";
    }

    /**
     * 任务列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "listschedulejob", method = RequestMethod.GET)
    public String listScheduleJob(ScheduleJob ScheduleJob, Model model) {

        List<ScheduleJob> ScheduleJobList = scheduleJobService.queryList(ScheduleJob);
        model.addAttribute("schedulejobList", ScheduleJobList);

        List<ScheduleJob> executingJobList = scheduleJobService.queryExecutingJobList();
        model.addAttribute("executingjobList", executingJobList);

        return "/admin/collecttimer";
    }

}
