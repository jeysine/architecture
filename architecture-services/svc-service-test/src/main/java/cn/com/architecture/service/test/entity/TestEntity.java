package cn.com.architecture.service.test.entity;

import java.io.Serializable;

/**
 * Created by li on 2017/8/24.
 */


public class TestEntity implements Serializable{

    private long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
