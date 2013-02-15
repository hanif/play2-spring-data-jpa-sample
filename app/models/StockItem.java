package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stock_items")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_unit")
    private StockUnit stockUnit;

    @ManyToOne(optional = true)
    @JoinColumn(name = "stock_category", nullable = true)
    private StockCategory stockCategory;

    @ManyToOne(optional = true)
    @JoinColumn(name = "stock_type", nullable = true)
    private StockType stockType;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description = "";

    @Column(name = "note")
    private String note = "";

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(mappedBy = "stockItem")
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "stockItem")
    private List<Stock> stocks = new ArrayList<>();

    @OneToMany(mappedBy = "specificTo")
    private List<StockUnit> stockUnits = new ArrayList<>();

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

    public StockUnit getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(StockUnit stockUnit) {
        this.stockUnit = stockUnit;
    }

    public StockCategory getStockCategory() {
        return stockCategory;
    }

    public void setStockCategory(StockCategory stockCategory) {
        this.stockCategory = stockCategory;
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<StockUnit> getStockUnits() {
        return stockUnits;
    }

    public void setStockUnits(List<StockUnit> stockUnits) {
        this.stockUnits = stockUnits;
    }
}
