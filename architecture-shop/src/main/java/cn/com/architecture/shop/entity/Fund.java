package cn.com.architecture.shop.entity;

import cn.com.architecture.shop.config.Const;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Fund {

    @Id
    private long id;
    @Column(nullable = false, unique = true)
    private String name;//基金名称
    @Column(nullable = true)
    private String url;//url
    @Column(nullable = true)
    private int number =0;
    @Column(nullable = true)
    private String ext = "";//额外数据
    @Column(nullable = true)
    private float dwjz = 0.0f;//单位净值
    @Column(nullable = true)
    private String jl = "";//基金经理
    @Column(nullable = true)
    private long lastTime = 0;//上次更新的时间
    @Column(nullable = false)
    private int status = Const.DataStatus.NORMAL;//状态

    @ManyToMany(mappedBy = "funds",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();


    public long getId() {
        return id;
    }

    public Fund setId(long id) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public float getDwjz() {
        return dwjz;
    }

    public void setDwjz(float dwjz) {
        this.dwjz = dwjz;
    }

    public String getJl() {
        return jl;
    }

    public void setJl(String jl) {
        this.jl = jl;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}