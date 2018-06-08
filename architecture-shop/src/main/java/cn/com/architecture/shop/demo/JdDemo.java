package cn.com.architecture.shop.demo;

import cn.com.architecture.shop.config.AppConstant;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import okhttp3.Response;
import scala.App;
import utils.JsonUtil;
import utils.okhttputil.OkHttpUtils;

import java.util.Map;

/**
 * Created by li on 2018/6/2.
 */

public class JdDemo {




    public static Map<String,String> itemMap = ImmutableMap.of(
            "老茶树龙井", "https://detail.tmall.com/item.htm?id=41810451622&_u=t2dmg8j26111",
            "美商海盗船 复仇者 DDR3 1600 8GB 台式机内存","https://item.jd.com/3849783.html",
            "东芝 TR200系列 240GB SATA3 固态硬盘","https://item.jd.com/5724596.html"
    );//不可变


    public static void main(String args[]) throws Exception{


        itemMap.forEach((itemName,itemUrl)->{

            String url = AppConstant.baseUrl;

            try{
                Response response = OkHttpUtils
                        .get()
                        .url(url)
                        .addParams("phu",itemUrl)
                        .build()
                        .execute();//自封装http请求

                String json = response.body().string();
                Map<String,Object> map = JsonUtil.parseToMap(json);//结构体装载成json

                int todayPrice = (int) map.getOrDefault("today",0);//今日价格

                int maxPrice = (int) map.getOrDefault("max",0);//最高价

                int minPrice = (int) map.getOrDefault("min",0);//最低价

                String sourceName = "其他";

                for(Map.Entry<String,String> entry: AppConstant.urlNameMap.entrySet()){
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if(key.indexOf(itemUrl)!=-1){
                        sourceName = value;
                        break;
                    }
                }//查询所属渠道

                String result= "商品名称:" + itemName
                        + ",当天价格:" + todayPrice
                        + ";历史最低价:" + minPrice
                        + ",历史最高价:" + maxPrice
                        + ",商品渠道:" + sourceName ;

                System.out.println(result);

            }catch (Exception e){
                e.printStackTrace();
            }

        });

    }

}
