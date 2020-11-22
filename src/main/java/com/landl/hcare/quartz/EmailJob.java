package com.landl.hcare.quartz;
import com.landl.hcare.component.VerifyEmail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class EmailJob extends QuartzJobBean {

    private VerifyEmail verifyEmail;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        verifyEmail.executeTask();
    }
    public void setVerifyEmail(VerifyEmail verifyEmail) {
        this.verifyEmail = verifyEmail;
    }
}