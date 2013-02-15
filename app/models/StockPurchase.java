package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stock_purchases")
public class StockPurchase {

    public enum Status { IN_PROGRESS, DELIVERED, CANCELED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user", nullable = true)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock", nullable = false)
    private Stock stock;

    @Column(name = "quantity")
    private BigDecimal quantity = BigDecimal.ZERO;

    @Column(name = "unit_price")
    private BigDecimal unitPrice = BigDecimal.ZERO;

    @Column(name = "sub_total")
    private BigDecimal subTotal = BigDecimal.ZERO;

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_ordered")
    private Date dateOrdered;

    @Column(name = "date_delivered", nullable = true)
    private Date dateDelivered;

    @Column(name = "date_canceled", nullable = true)
    private Date dateCanceled;

    @Column(name = "status")
    private Status status = Status.IN_PROGRESS;

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public Date getDateCanceled() {
        return dateCanceled;
    }

    public void setDateCanceled(Date dateCanceled) {
        this.dateCanceled = dateCanceled;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
