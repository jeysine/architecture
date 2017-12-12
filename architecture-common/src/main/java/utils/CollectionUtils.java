package utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
//        Monster m2 = new Monster(1,"c");
//        Monster m3 = new Monster(2,"d");
//        Monster m4 = new Monster(1,"e");

        monsters.add(m);
        monsters.add(m1);
//        monsters.add(m2);
//        monsters.add(m3);
//        monsters.add(m4);


//        ConcurrentMap map1 = monsters.stream().collect(Collectors.groupingByConcurrent(Monster::getId));
//
//        ConcurrentMap map = listToCMaps(monsters,Monster::getId);

        //Map<Integer,Monster> map2 = monsters.stream().collect(Collectors.toMap(Monster::getId,t->t));

        Map<Integer,Monster> map3 =
                monsters.stream().collect(Collectors.toMap(Monster::getId,Function.identity()));

        Map<Integer,Monster> map4 =
                monsters.stream().collect(Collectors.toMap(Monster::getId,t->t));

        //Map map3 = listToMap(monsters,Monster::getId);


//        printCollection(map);
//
//        printCollection(map1);

        //printCollection(map2);

        printCollection(map3);

        printCollection(map4);

        Monster m2 = new Monster(1,"c");
        monsters.add(m2);
//        Map<Integer,Monster> map5 =
//                monsters.stream().collect(Collectors.toMap(Monster::getId,t->t));
//        printCollection(map5);

    }


    /**
     * 将List转成Map<R,list<T>>的集合,比如将person按照class进行ConcurrentMap分组,在读取Excel表的时候有使用场景</>></>
     */
    public static <T,R> ConcurrentMap<R, List<T>> listToCMaps(List<T> list, Function<? super T, ? extends R> f){
        if(list==null){
            return new ConcurrentHashMap<R, List<T>>();
        }
        return list.stream().collect(Collectors.groupingByConcurrent(f));
    }

    /**
     * 将List转成Map<R,list<T>>的集合,比如将person按照class进行map分组,在读取Excel表的时候有使用场景</>></>
     */
    public static <T,R> Map<R, List<T>> listToMaps(List<T> list, Function<? super T, ? extends R> f){
        if(list==null){
            return new HashMap<>();
        }
        return list.stream().collect(Collectors.groupingBy(f));
    }

    /**
     * 将List转成Map<R,T>的集合,比如将person按照class进行map分组,出现相同的key后面的会覆盖前面的
     */
    public static <T,R> Map<R, T> listToKVMap(List<T> list, Function<? super T, ? extends R> f){
        return listToKVMap(list, f,true);
    }

    /**
     * 将List转成Map<R,T>的集合,比如将person按照class进行map分组,,如果fixDuplicate为true,
     * list出现相同的key会进行覆盖,否则抛错.
     */
    public static <T,R> Map<R, T> listToKVMap(List<T> list, Function<? super T, ? extends R> f,boolean fixDuplicate){
        if(list==null){
            return new HashMap<R, T>();
        }
        if(fixDuplicate){
            return list.stream().collect(Collectors.toMap(f,Function.identity(),(key1, key2) -> key2));
        }else{
            return list.stream().collect(Collectors.toMap(f,Function.identity()));
        }
    }

    /**
     * 将List转成Map<R,T>的集合,比如将person按照class进行map分组,出现相同的key后面的会覆盖前面的
     */
    public static <T,R> ConcurrentMap<R, T> listToKVCMap(List<T> list, Function<? super T, ? extends R> f){
        return listToKVCMap(list, f, true);
    }

    /**
     * 将List转成Map<R,T>的集合,比如将person按照class进行map分组,如果fixDuplicate为true,
     * list出现相同的key会进行覆盖,否则抛错.
     */
    public static <T,R> ConcurrentMap<R, T> listToKVCMap(List<T> list, Function<? super T, ? extends R> f,boolean fixDuplicate){
        if(list==null){
            return new ConcurrentHashMap<R, T>();
        }
        if(fixDuplicate){
            return list.stream().collect(Collectors.toConcurrentMap(f,Function.identity(),(key1, key2) -> key2));
        }else{
            return list.stream().collect(Collectors.toConcurrentMap(f,Function.identity()));
        }
    }

    /**
     * 将List转成Map<R,T>的集合,支持选定的Map返回类型
     */
    public static <T,R extends Map<T,R>> Map<? extends R, T> listToKVCMap(List<T> list, Function<? super T, ? extends R> f,Supplier<Map<R,T>> supplier){
        if(list==null){
            return supplier.get();
        }
        return list.stream().collect(Collectors.toMap(f,Function.identity(),(key1, key2) -> key2,supplier));
    }


    /**
     * 取集合符合要求的某个值
     */
    public static <T> T filterOne(List<T> list,Predicate<T> predicate){
        return list.stream().filter(predicate).findFirst().get();
    }

    /**
     * 取集合符合要求的值
     */
    public static <T> List<T> filterAll(List<T> list,Predicate<T> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * map值转list
     */
    public static <K,V> List<V> mapValueToList (Map<K,V> map){
        return new ArrayList<V>(map.values());
    }

    /**
     * map键转list
     */
    public static <K,V> List<K> mapKeyToList (Map<K,V> map){
        return new ArrayList<K>(map.keySet());
    }

    /**
     * 打印集合
     * @param map
     */
    public static <K,V> void printCollection(Map<K,V> map){
        map.forEach((k,v)->{System.out.println(k+":"+v);});
    }

    public static  Function<Object, Object> self(){
        return Function.identity();
    }

    /**
     * 打印集合
     * @param collection
     */
    public static <T> void printCollection (Collection<T> collection){
        collection.forEach(System.out::println);
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
