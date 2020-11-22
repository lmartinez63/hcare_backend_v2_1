package com.landl.hcare.quartz;
import com.landl.hcare.component.VerifySchedule;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduleJob extends QuartzJobBean {

    private VerifySchedule verifySchedule;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        verifySchedule.executeTask();
    }
    public void setVerifySchedule(VerifySchedule verifySchedule) {
        this.verifySchedule = verifySchedule;
    }
}