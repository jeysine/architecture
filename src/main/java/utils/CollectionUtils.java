package utils;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
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
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> ConcurrentMap<R, List<T>> listToCMaps(List<T> list, Function<? super T, ? extends R> f){
        return list.stream().collect(Collectors.groupingByConcurrent(f));
    }

    /**
     * 将List转成Map<R,list<T>>的集合,比如将person按照class进行map分组,在读取Excel表的时候有使用场景</>></>
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> Map<R, List<T>> listToMaps(List<T> list, Function<? super T, ? extends R> f){
        return list.stream().collect(Collectors.groupingBy(f));
    }

    /**
     * 将List转成Map<R,list<T>>的集合,比如将person按照class进行map分组,如果list出现相同的key会抛错Duplicate key,见map5</>></>
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> Map<R, T> listToMap(List<T> list, Function<? super T, ? extends R> f){
        return list.stream().collect(Collectors.toMap(f,Function.identity()));
    }

    /**
     * 将List转成Map<R,list<T>>的集合,比如将person按照class进行map分组,如果list出现相同的key会抛错Duplicate key,见map5</>></>
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> ConcurrentMap<R, T> listToCMap(List<T> list, Function<? super T, ? extends R> f){
        return list.stream().collect(Collectors.toConcurrentMap(f,Function.identity()));
    }

    /**
     * map值转list
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> List<V> mapValueToList (Map<K,V> map){
        return new ArrayList<>(map.values());
    }

    /**
     * map键转list
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> List<K> mapKeyToList (Map<K,V> map){
        return new ArrayList<>(map.keySet());
    }

    /**
     * 打印集合
     * @param map
     */
    public static void printCollection(Map map){
            map.forEach((k,v)->{
                System.out.println(k+":"+v);
            });
    }

    /**
     * 打印集合
     * @param collection
     */
    public static void printCollection (Collection collection){
        collection.forEach(v->{
            System.out.println(v);
        });
    }

    public static <T> void printCollection(T[] arr){
        System.out.println(Arrays.toString(arr));
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
