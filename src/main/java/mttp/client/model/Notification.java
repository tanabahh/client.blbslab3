
package mttp.client.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mobile_notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "time")
    private LocalDate localDate;

    @Column(name = "order_id")
    private Long orderId;

    @Column
    private String content;

    public Notification(){}

    public Notification(Long orderId, Long userId, String type, String content){
        this.type = type;
        this.orderId = orderId;
        this.userId = userId;
        this.localDate = LocalDate.now();
        this.content = content;
    }

    public Notification(Long userId, String type, String content){
        this.type = type;
        this.userId = userId;
        this.localDate = LocalDate.now();
        this.content = content;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUser() {
        return userId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOrder(Long orderId) {
        this.orderId = orderId;
    }

    public void setUser(Long user) {
        this.userId = userId;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}