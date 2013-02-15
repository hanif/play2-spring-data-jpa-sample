package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "outlet_managers",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"outlet", "user"})})
public class OutletManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "outlet")
    private Outlet outlet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "date_created")
    private Date dateCreated;

    @PrePersist
    public void setCreationDate() {
        if (null == id) {
            dateCreated = new Date();
        }
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
