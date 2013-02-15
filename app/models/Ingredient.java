package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredients",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"menu", "stock_item"})})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "menu")
    private Menu menu;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_item")
    private StockItem stockItem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_unit")
    private StockUnit stockUnit;

    @Column(name = "position")
    private Integer position;

    @Column(name = "quantity")
    private BigDecimal quantity = BigDecimal.ZERO;

    @Column(name = "note")
    private String note = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public StockUnit getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(StockUnit stockUnit) {
        this.stockUnit = stockUnit;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
