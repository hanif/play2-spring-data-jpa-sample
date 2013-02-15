package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_prices",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"outlet", "menu"})})
public class MenuPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "outlet", nullable = false)
    private Outlet outlet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "menu", nullable = false)
    private Menu menu;

    @Column(name = "price", precision = 12, scale = 2)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
