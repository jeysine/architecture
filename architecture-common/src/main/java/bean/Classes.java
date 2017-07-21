package bean;

import java.io.Serializable;

/**
 * Created by li on 2017/7/18.
 */


public class Classes implements Serializable {

    private long id;

    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Classes(){
        super();
    }

    public Classes(long id,String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "id:"+id+",name:"+name;
    }
}
