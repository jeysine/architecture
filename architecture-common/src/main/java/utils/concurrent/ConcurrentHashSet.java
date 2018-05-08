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


        HashSet<Integer> set = new HashSet<>();

        ConcurrentHashSet<Integer> set1 = new ConcurrentHashSet<>();

        set1.add(1);
        set1.add(2);

        System.out.println(set1);


    }

}
