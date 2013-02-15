package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menus",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_unit", "name"})})
public class Menu {

    public enum Status { ACTIVE, INACTIVE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "menu_unit")
    private MenuUnit menuUnit;

    @ManyToOne(optional = true)
    @JoinColumn(name = "menu_category", nullable = true)
    private MenuCategory menuCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description = "";

    @Column(name = "note")
    private String note = "";

    @Column(name = "unit_sold")
    private Integer unitSold = 0;

    @Column(name = "status")
    private Status status = Status.ACTIVE;

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(mappedBy = "menu")
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<MenuPrice> menuPrices = new ArrayList<>();

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

    public MenuUnit getMenuUnit() {
        return menuUnit;
    }

    public void setMenuUnit(MenuUnit menuUnit) {
        this.menuUnit = menuUnit;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
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

    public Integer getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(Integer unitSold) {
        this.unitSold = unitSold;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<MenuPrice> getMenuPrices() {
        return menuPrices;
    }

    public void setMenuPrices(List<MenuPrice> menuPrices) {
        this.menuPrices = menuPrices;
    }
}
