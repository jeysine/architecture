package utils;

/**
 * Created by li on 2018/1/18.
 * 位操作工具类
 */
public class BitUtils {


    //新事件通知
    public final static int NEW_EVENT_NONE 		= 0; 	  // 无
    public final static int NEW_EVENT_ACHIEVEMENT_FINISH 	= 1 << 0; // 有达成成就未领取
    public final static int NEW_STORY_BOOK_EVENT = 1 << 1; //有新的法典未阅读
    public final static int NEW_FRIEND_REQUEST = 1 << 2; //有新的好友申请


    /**
     * 按位保存操作:判断,是否有存储值
     * @param status  储存值
     * @param bit 判断位的定义值
     * @return
     */
    public static boolean isStatusBit(int status, int bit) {
        return (status & bit) != 0;
    }

    /**
     * 按位保存操作:设置
     * @param status  储存值
     * @param bit 判断位的定义值
     * @return
     */
    public static int setStatusBit(int status, int bit) {
        return (status |= bit);
    }

    /**
     * 按位保存操作:清除
     * @param status  储存值
     * @param bit 判断位的定义值
     * @return
     */
    public static int clearStatusBit(int status, int bit) {
        return (status &= ~bit);
    }

    /**
     * 输出int的位
     * @param a
     * @return
     */
    public static String getBitString(int a){
        return Integer.toBinaryString(a);
    }

    public static void main(String args[]){

        int fag = 0;

        fag = setStatusBit(fag, NEW_EVENT_ACHIEVEMENT_FINISH);
        fag = setStatusBit(fag, NEW_STORY_BOOK_EVENT);
        fag = setStatusBit(fag, NEW_FRIEND_REQUEST);

        System.out.println(getBitString(fag));

        System.out.println(fag);

        fag = clearStatusBit(fag,NEW_STORY_BOOK_EVENT);

        System.out.println(getBitString(fag));

        System.out.println(fag);

        System.out.println(isStatusBit(fag,NEW_FRIEND_REQUEST));


    }



}
