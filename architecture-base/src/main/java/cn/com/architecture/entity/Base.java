package cn.com.architecture.entity;

import javax.persistence.Id;
import java.util.Date;

public class Base {

    @Id
    private String id;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
