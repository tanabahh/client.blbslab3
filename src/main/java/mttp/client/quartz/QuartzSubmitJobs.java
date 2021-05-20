package mttp.client.quartz;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzSubmitJobs {
    private static final String CRON_EVERY_FIVE_MINUTES = "0 0/5 * ? * * *";

    @Bean(name = "notification")
    public JobDetailFactoryBean jobMemberStats() {
        return QuartzConfig.createJobDetail(NotificationJob.class, "Notification Job Job");
    }

    @Bean(name = "notificationTrigger")
    public SimpleTriggerFactoryBean triggerMemberStats(@Qualifier("notification") JobDetail jobDetail) {
        return QuartzConfig.createTrigger(jobDetail, 6000, "Notification Job Trigger");
    }
}

