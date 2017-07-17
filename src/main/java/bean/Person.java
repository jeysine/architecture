package bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Created by li on 2017/7/18.
 */

public class Person implements Serializable{

    private long id;

    private String name;

    private Classes classes;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public Classes getClasses() {
        return classes;
    }

    public long getId() {
        return id;
    }

    public Person(){}

    public Person(long id,String name,Classes classes){
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public String toString(){
        return "id:"+id+",name:"+name+",classes-->"+classes.toString();
    }
}
