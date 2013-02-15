package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification {

    public enum Status { READ, UNREAD }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    private Status status = Status.UNREAD;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_to_display", nullable = true)
    private Date dateToDisplay;

    @Column(name = "date_to_expire", nullable = true)
    private Date dateToExpire;

    @PrePersist
    public void setCreationDate() {
        if (null == id) {
            dateCreated = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateToDisplay() {
        return dateToDisplay;
    }

    public void setDateToDisplay(Date dateToDisplay) {
        this.dateToDisplay = dateToDisplay;
    }

    public Date getDateToExpire() {
        return dateToExpire;
    }

    public void setDateToExpire(Date dateToExpire) {
        this.dateToExpire = dateToExpire;
    }
}
