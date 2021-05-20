package mttp.client.quartz;

import mttp.client.service.NotificationService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
public class NotificationJob implements Job {
    @Autowired
    private NotificationService notificationService;

    @Override
    public void execute(JobExecutionContext context) {
        notificationService.sendAdvertisingNotification(1L, "hello");
        System.out.println("Job execute");
    }
}
