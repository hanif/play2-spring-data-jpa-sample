package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "daily_recaps")
public class SalesRecap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "outlet")
    private Outlet outlet;

    @Column(name = "for_date")
    private Date forDate;

    @Column(name = "note")
    private String note = "";

    @OneToMany(mappedBy = "salesRecap")
    private List<RecapItem> recapItems = new ArrayList<>();

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

    public Date getForDate() {
        return forDate;
    }

    public void setForDate(Date forDate) {
        this.forDate = forDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<RecapItem> getRecapItems() {
        return recapItems;
    }

    public void setRecapItems(List<RecapItem> recapItems) {
        this.recapItems = recapItems;
    }
}
