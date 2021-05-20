package mttp.client.service;

import mttp.client.model.Notification;
import mttp.client.model.TypeEnum;
import mttp.client.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification sendOrderNotification(Long orderId, Long userId, String status) {
        Notification notification = new Notification(orderId, userId, TypeEnum.ORDER_INFORMATION.name(), status);
        notificationRepository.save(notification);
        return notification;
    }

    public Notification sendAdvertisingNotification(Long userId, String content) {
        Notification notification = new Notification(userId, TypeEnum.ADVERTISING.name(), content);
        notificationRepository.save(notification);
        return notification;
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }
}
