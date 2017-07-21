package utils;

import bean.Classes;
import bean.Person;

import java.io.*;

/**
 * Created by li on 2017/7/18.
 * 克隆工具类
 */

public class CloneUtil {


    private CloneUtil() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }

    public static void main(String args[]) throws Exception{

        Classes classes = new Classes(1,"一班");

        Person p = new Person(1,"小明",classes);

        System.out.println(p);

        Person p2 = clone(p);

        Classes classes2 = new Classes(2,"二班");
        p2.setName("小红");
        p2.setId(2);
        p2.setClasses(classes2);


        System.out.println("===================");
        System.out.println(p);
        System.out.println(p2);

    }

}
