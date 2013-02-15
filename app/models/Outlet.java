package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "outlets")
public class Outlet {

    public enum Status { ACTIVE, INACTIVE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "warehouse")
    private Warehouse warehouse;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description = "";

    @Column(name = "address")
    private String address = "";

    @Column(name = "latitude", nullable = true)
    private Double latitude;

    @Column(name = "longitude", nullable = true)
    private Double longitude;

    @Column(name = "item_sold")
    private Integer itemSold = 0;

    @Column(name = "income")
    private BigDecimal income = BigDecimal.ZERO;

    @Column(name = "status")
    private Status status = Status.ACTIVE;

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(mappedBy = "outlet")
    private List<MenuPrice> menuPrices = new ArrayList<>();

    @OneToMany(mappedBy = "outlet")
    private List<SalesRecap> salesRecaps = new ArrayList<>();

    @OneToMany(mappedBy = "outlet")
    private List<OutletManager> managers = new ArrayList<>();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getItemSold() {
        return itemSold;
    }

    public void setItemSold(Integer itemSold) {
        this.itemSold = itemSold;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
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

    public List<MenuPrice> getMenuPrices() {
        return menuPrices;
    }

    public void setMenuPrices(List<MenuPrice> menuPrices) {
        this.menuPrices = menuPrices;
    }

    public List<SalesRecap> getSalesRecaps() {
        return salesRecaps;
    }

    public void setSalesRecaps(List<SalesRecap> salesRecaps) {
        this.salesRecaps = salesRecaps;
    }

    public List<OutletManager> getManagers() {
        return managers;
    }

    public void setManagers(List<OutletManager> managers) {
        this.managers = managers;
    }
}
