package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock_units")
public class StockUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "specific_to", nullable = true)
    private StockItem specificTo;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description = "";

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_ratio")
    private BigDecimal groupRatio = BigDecimal.ZERO;

    @OneToMany(mappedBy = "stockUnit")
    private List<StockItem> stockItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StockItem getSpecificTo() {
        return specificTo;
    }

    public void setSpecificTo(StockItem specificTo) {
        this.specificTo = specificTo;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public BigDecimal getGroupRatio() {
        return groupRatio;
    }

    public void setGroupRatio(BigDecimal groupRatio) {
        this.groupRatio = groupRatio;
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }
}
