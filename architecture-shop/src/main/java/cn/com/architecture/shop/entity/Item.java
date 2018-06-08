package cn.com.architecture.shop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String url;
    @Column(nullable = true)
    private int currentPrice =0;
    @Column(nullable = true)
    private int maxPrice = 0;
    @Column(nullable = true)
    private int minPrice = 0;
    @Column(nullable = false)
    private long pushTime = 0L;//上次推送的时间

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "ITEM_USER", joinColumns = {
            @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    private Set<User> users = new HashSet<>();


    public long getId() {
        return id;
    }

    public Item setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setPushTime(long pushTime) {
        this.pushTime = pushTime;
    }

    public long getPushTime() {
        return pushTime;
    }
}