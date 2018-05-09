package utils.concurrent;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by li on 2018/5/8.
 */

public class ConcurrentHashSet<E> extends AbstractSet<E>
        implements Set<E>,Serializable {

    private transient ConcurrentHashMap<E,Object> map = null;

    private static final Object PRESENT = new Object();


    public ConcurrentHashSet() {
        map = new ConcurrentHashMap<>();
    }

    public ConcurrentHashSet(Collection<? extends E> c) {
        map = new ConcurrentHashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }

    public ConcurrentHashSet(int initialCapacity, float loadFactor) {
        map = new ConcurrentHashMap<>(initialCapacity, loadFactor);
    }


    public ConcurrentHashSet(int initialCapacity) {
        map = new ConcurrentHashMap<>(initialCapacity);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }


    public int size() {
        return map.size();
    }


    public boolean isEmpty() {
        return map.isEmpty();
    }


    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    public void clear() {
        map.clear();
    }

//    @SuppressWarnings("unchecked")
//    public Object clone() {
//        try {
//            ConcurrentHashSet<E> newSet = (ConcurrentHashSet<E>) super.clone();
//            newSet.map = (ConcurrentHashMap<E, Object>) map.clone();
//            return newSet;
//        } catch (CloneNotSupportedException e) {
//            throw new InternalError(e);
//        }
//    }

//    public Spliterator<E> spliterator() {
//        return new ConcurrentHashMap.KeySpliterator<E,Object>(map, 0, -1, 0, 0);
//    }

    public static void main(String args[]){

        HashSet<String> set1 = new HashSet<>();


        ConcurrentHashSet<String> set2 = new ConcurrentHashSet<>();


        Thread t1 = new Thread(()->{
            int i = 1;
            while (true){
                try{
                    set1.remove(i+"");
                    i++;
                    //Thread.sleep(110);
                }catch(Exception e){
                    throw e;
                }
            }
        });

        Thread t2 = new Thread(()->{
            while (true) {
                try {
                    int j = 0;
                    for (String i : set1) {
                        j += 1;
                    }
                    System.out.println("set1数量：" + j);
                    //Thread.sleep(10);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

        Thread t3 = new Thread(()->{
            int i = 1;
            while (true) {
                try {
                    set1.add(i+"");
                    i++;
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        
        Thread t4 = new Thread(()->{
            int i = 1;
            while (true) {
                try{
                    set2.remove(i+"");
                    i++;
                    //Thread.sleep(110);
                }catch(Exception e){
                    throw e;
                }
            }
        });

        Thread t5 = new Thread(()->{
            while (true) {
                try {
                    int j = 0;
                    for (String i : set2) {
                        j += 1;
                    }
                    System.out.println("set2数量：" + j);
                    //Thread.sleep(10);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

        Thread t6 = new Thread(()->{
            int i = 1;
            while (true) {
                try {
                    set2.add(i+"");
                    i++;
                } catch (Exception e) {
                    throw e;
                }
            }
        });

//        t3.start();
//        try{
//            Thread.sleep(10);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        t2.start();
//        t1.start();

        t6.start();
        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        t5.start();
        t4.start();



        while(true){



        }


    }

}
