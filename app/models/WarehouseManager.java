package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "warehouse_managers",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"warehouse", "user"})})
public class WarehouseManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "warehouse")
    private Warehouse warehouse;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
