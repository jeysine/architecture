package cn.com.architecture.shop.config;

import com.google.common.collect.ImmutableBiMap;

import java.util.Map;

/**
 * Created by li on 2018/6/3.
 */



public class AppConstant {

    public static Map<String,String> urlNameMap = ImmutableBiMap.of(
            "detail.tmall.com","天猫",
            "item.taobao.com","淘宝",
            "item.jd.com","京东"
    );//BiMap,反转

    public static String baseUrl = "https://zhushou.huihui.cn/productSense";

}
