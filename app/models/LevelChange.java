package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "level_changes")
public class LevelChange {

    public enum Type { CORRECTION, USAGE, PURCHASE, BROKEN, WASTED, STOCK_IN, STOCK_OUT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock")
    private Stock stock;

    @Column(name = "current_level")
    private BigDecimal currentLevel;

    @Column(name = "delta")
    private BigDecimal delta = BigDecimal.ZERO;

    @Column(name = "is_auto")
    private Boolean isAuto = false;

    @Column(name = "type")
    private Type type;

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public BigDecimal getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(BigDecimal currentLevel) {
        this.currentLevel = currentLevel;
    }

    public BigDecimal getDelta() {
        return delta;
    }

    public void setDelta(BigDecimal delta) {
        this.delta = delta;
    }

    public Boolean getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Boolean isAuto) {
        this.isAuto = isAuto;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
