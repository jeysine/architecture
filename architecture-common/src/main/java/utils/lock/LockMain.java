package utils.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lst on 2018/5/8.
 * 测试类
 */
public class LockMain {

    /**
     * 实验，一边对集合进行遍历，一边对集合增加,一边减少
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception{

        List<String> list1 = new ArrayList<>();

        List<String> list2 = new ArrayList<>();

        for(int i = 0;i<100;i++){
            list1.add(i+"");
            list2.add(i+"");
        }

        ListWithLock<String> list3 = new ListWithLock<String>(list2);

        Thread t1 = new Thread(()->{
            while (true){
                try{
                    list1.remove(6);
                    //Thread.sleep(110);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            while (true) {
                try {
                    int j = 0;
                    for (String i : list1) {
                        j += 1;
                    }
                    System.out.println("list1数量：" + j);
                    //Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(()->{
            while (true) {
                try {
                    list1.add("222");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t4 = new Thread(()->{
            while (true) {
                try {
                    list3.remove(0);
                    //Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t5 = new Thread(()->{
            while (true) {
                try {
                    list3.readExec(() -> {
                        int j = 0;
                        for (String i : list2) {
                            j += 1;
                        }
                        System.out.println("list2数量：" + j);
                    });
                    //Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t6 = new Thread(()->{
            while (true) {
                try {
                    list3.add("222");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        t1.start();
//        t2.start();
//        t3.start();

        t4.start();
        t5.start();
        t6.start();
        while (true){

        }

    }

}
