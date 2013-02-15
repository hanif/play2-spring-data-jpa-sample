package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "recap_items",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"sales_recap", "item_name"})})
public class RecapItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sales_recap")
    private SalesRecap salesRecap;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "unit_price")
    private BigDecimal unitPrice = BigDecimal.ZERO;

    @Column(name = "quantity")
    private Integer quantity = 0;

    @Column(name = "subtotal")
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "note")
    private String note = "";

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

    public SalesRecap getSalesRecap() {
        return salesRecap;
    }

    public void setSalesRecap(SalesRecap salesRecap) {
        this.salesRecap = salesRecap;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
