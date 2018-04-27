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
    public final static int NEW_SHOP_SALE = 1 << 3; //有新的促销商品
    public final static int NEW_NONREAD_MAIL = 1 << 4; //有未读邮件
    public final static int NEW_FLOWER = 1 << 5;//有人献花
    public final static int NEW_ARENA = 1 << 6;//竞技场有挑战次数
    public final static int NEW_ABATTOIR = 1 << 7;//角斗场有挑战次数
    public final static int NEW_GUARDIAN_CRYSTAL = 1 << 8;//守卫水晶有挑战次数
    public final static int NEW_MONEY = 1 << 9;//金币关卡有挑战次数
    public final static int NEW_ARREST = 1 << 10;//抓捕关卡有挑战次数
    public final static int NEW_GVG = 1 << 11;//GVG
    public final static int NEW_FACTION_WINPOINT_CHEST = 1 << 12;//势力胜点宝箱
    public final static int NEW_TEMPMAP_PVE = 1 << 13;//神殿大地图-PVE-被反攻
    public final static int NEW_MISSION_CHEST = 1 << 14;//副本宝箱小红点
    public final static int NEW_TEMPLEGUARD_BOX = 1 << 15;//神殿守卫宝箱小红点
    public final static int NEW_PRIVETE_CHAT = 1 << 16;//私聊小红点
    public final static int NEW_GVE = 1 << 17;//GVE小红点
    public final static int NEW_PRACTICE = 1 << 18;//试炼塔小红点
    public final static int NEW_ESCORT = 1 << 19;//押镖小红点
    public final static int NEW_ACTIVE_CHEST = 1 << 20;//日常活跃宝箱小红点
    public final static int NEW_REPO = 1 << 21;//回购红点
    public final static int NEW_WORLD_BOSS = 1 << 22;//世界boss
    public final static int NEW_WELFARE = 1 << 23;//福利小红点
    public final static int NEW_TEMPLEMANOR_LEVEL = 1 << 24;//神殿领地升级
    public final static int NEW_TALISMAN_SOUL_EXTRACT_ITEM_GET = 1 << 25;//灵魂抽取物品领取小红点
    public final static int NEW_FIRST_PAY = 1 << 26;//首冲奖励领取小红点
    public final static int NEW_BILL_FUND = 1 << 27;//基金奖励领取小红点
    public final static int NEW_TEMPMAP_PVPISLAND= 1 << 28;//神殿大地图-PVP-被别人抢了岛
    public final static int NEW_TEMPMAP_UPTITLE= 1 << 29;//神殿大地图-称号升级

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
