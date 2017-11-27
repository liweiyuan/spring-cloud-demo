package com.wade.cloud.service;

import com.wade.cloud.domain.ScheduleJob;
import com.wade.cloud.task.TestTask;
import com.wade.cloud.util.SpringApplicationContextUtil;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tingyun on 2017/11/27.
 */
public class ScheduleJobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestTask.class);

    public void getScheduleJob(){

        try {
            SchedulerFactoryBean schedulerFactoryBean = SpringApplicationContextUtil.getBean("scheduler");
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    ScheduleJob job = new ScheduleJob();
                    job.setJobName(jobKey.getName());
                    job.setJobGroup(jobKey.getGroup());
                    job.setDesc("触发器:" + trigger.getKey());
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                    job.setJobStatus(triggerState.name());
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        String cronExpression = cronTrigger.getCronExpression();
                        job.setCronExpression(cronExpression);
                    }
                    jobList.add(job);
                }
            }

            for (ScheduleJob job : jobList) {
                LOGGER.info("计划列表,name:{},group:{},desc:{},status:{}",job.getJobName(),job.getJobGroup(),job.getDesc(),job.getJobStatus());
            }

        } catch (SchedulerException e) {
            LOGGER.error("SchedulerException", e);
        }
    }
}
