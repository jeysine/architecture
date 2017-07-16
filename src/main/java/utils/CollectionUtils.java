package utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by li on 2017/7/17.
 * 用java8对集合的操作进行简化
 */

public class CollectionUtils {


    public static void main(String args[]){


        List<Monster> monsters = new ArrayList<>();

        Monster m = new Monster(1,"a");
        Monster m1 = new Monster(2,"b");
        Monster m2 = new Monster(1,"c");
        Monster m3 = new Monster(2,"d");
        Monster m4 = new Monster(1,"e");

        monsters.add(m);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);
        monsters.add(m4);


        ConcurrentMap map1 = monsters.stream().collect(Collectors.groupingByConcurrent(Monster::getId));

        CollectionUtils utils = new CollectionUtils();

        ConcurrentMap map = translateList(monsters,Monster::getId);

        printCollection(map);

        printCollection(map1);


    }

    public static <T,R> ConcurrentMap<R, List<T>> translateList(List<T> list, Function<? super T, ? extends R> f){
        return list.stream().collect(Collectors.groupingByConcurrent(f));
    }


    public static void printCollection(Map map){
        map.forEach((k,v)->{
             System.out.println(k+":"+v);
        });
    }

    public static void printCollection(List list){
        list.forEach(v->{
            System.out.println(v);
        });
    }


    static class Monster{

        int id;
        String name;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        Monster(int id,String name){
            this.id = id;
            this.name = name;
        }

        public String toString(){
            return "{id:"+id+",name:"+name+"}";
        }
    }

}
