package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(mappedBy = "warehouse")
    private List<Outlet> outlets = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse")
    private List<Stock> stocks = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse")
    private List<WarehouseManager> managers = new ArrayList<>();

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<Outlet> outlets) {
        this.outlets = outlets;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<WarehouseManager> getManagers() {
        return managers;
    }

    public void setManagers(List<WarehouseManager> managers) {
        this.managers = managers;
    }
}
