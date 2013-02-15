package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stocks",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"warehouse", "stock_item"})})
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "warehouse")
    private Warehouse warehouse;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_item")
    private StockItem stockItem;

    @Column(name = "current_level")
    private BigDecimal currentLevel = BigDecimal.ZERO;

    @Column(name = "reorder_level", nullable = true)
    private BigDecimal reorderLevel;

    @Column(name = "current_unit_price", nullable = true)
    private BigDecimal currentUnitPrice;

    @Column(name = "last_change", nullable = true)
    private Date lastChange;

    @Column(name = "last_purchase", nullable = true)
    private Date lastPurchase;

    @OneToMany(mappedBy = "stock")
    private List<LevelChange> levelChanges = new ArrayList<>();

    @OneToMany(mappedBy = "stock")
    private List<StockPurchase> stockPurchases = new ArrayList<>();

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

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public BigDecimal getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(BigDecimal currentLevel) {
        this.currentLevel = currentLevel;
    }

    public BigDecimal getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(BigDecimal reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Date getLastPurchase() {
        return lastPurchase;
    }

    public void setLastPurchase(Date lastPurchase) {
        this.lastPurchase = lastPurchase;
    }

    public List<LevelChange> getLevelChanges() {
        return levelChanges;
    }

    public void setLevelChanges(List<LevelChange> levelChanges) {
        this.levelChanges = levelChanges;
    }

    public List<StockPurchase> getStockPurchases() {
        return stockPurchases;
    }

    public void setStockPurchases(List<StockPurchase> stockPurchases) {
        this.stockPurchases = stockPurchases;
    }
}
