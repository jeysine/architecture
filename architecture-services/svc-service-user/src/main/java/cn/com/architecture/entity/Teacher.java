package cn.com.architecture.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 描述：code generate by util模型
* @author yarus li
* @email lloo0331oo@126.com
* @date 2017-07-30 17:56:01
*/

@Entity
@Table(name = "teacher")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher extends Base implements Serializable {

private static final long serialVersionUID = -1L;

@Id
    /** Id */
    private Integer id;
    /** 名称 */
    private String name;
    /** 描述 */
    private String desc;
    /** 创建时间 */
    private Date createDate;

    /** 获取Id */
    public Integer getId() {
        return this.id;
    }

    /** 设置Id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取名称 */
    public String getName() {
        return this.name;
    }

    /** 设置名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取描述 */
    public String getDesc() {
        return this.desc;
    }

    /** 设置描述 */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /** 获取创建时间 */
    public Date getCreateDate() {
        return this.createDate;
    }

    /** 设置创建时间 */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "Teacher{"+", id='" + id +", name='" + name +", desc='" + desc +", createDate='" + createDate +"'}'";
    }
}