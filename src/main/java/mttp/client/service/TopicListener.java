package mttp.client.service;


import mttp.client.model.Notification;
import org.apache.activemq.command.ActiveMQBytesMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopicListener implements MessageListener {
    @Autowired
    public NotificationService notificationService;

    @Override
    public void onMessage(Message message) {
        System.out.println(message);
        if (message instanceof ActiveMQBytesMessage) {
            try {
                ActiveMQBytesMessage bytesMessage = (ActiveMQBytesMessage) message;
                String topicName = bytesMessage.getDestination().getPhysicalName();
                String messageText = new String(bytesMessage.getContent().data);
                Pattern pattern = Pattern.compile("\\b[\\d]+\\b");
                Matcher matcher = pattern.matcher(messageText);
                matcher.find();
                Long orderId = Long.parseLong(matcher.group());
                matcher.find();
                Long userId = Long.parseLong(matcher.group());
                notificationService.sendOrderNotification(orderId, userId, "Оплачен");
                //Notification notification = new Notification(orderId, userId, LocalDate.now());
                //notificationService.save(notification);
                System.out.println(topicName);
                System.out.println(messageText);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
