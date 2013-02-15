package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    final static String DEFAULT_TIMEZONE = "UTC";

    public enum Role { SUPPORT, OWNER, ADMIN, USER, AUDITOR }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contact_no")
    private String contactNo = "";

    @Column(name = "address")
    private String address = "";

    @Column(name = "bio")
    private String bio = "";

    @Column(name = "role")
    private Role role = Role.USER;

    @Column(name = "timezone")
    private String timezone = DEFAULT_TIMEZONE;

    @Column(name = "enable")
    private Boolean enable = true;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "expiration_date", nullable = true)
    private Date expirationDate;

    @OneToMany(mappedBy = "user")
    private List<Log> logs = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Token> tokens = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<OutletManager> managedOutlets = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<WarehouseManager> managedWarehouses = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<OutletManager> getManagedOutlets() {
        return managedOutlets;
    }

    public void setManagedOutlets(List<OutletManager> managedOutlets) {
        this.managedOutlets = managedOutlets;
    }

    public List<WarehouseManager> getManagedWarehouses() {
        return managedWarehouses;
    }

    public void setManagedWarehouses(List<WarehouseManager> managedWarehouses) {
        this.managedWarehouses = managedWarehouses;
    }
}
