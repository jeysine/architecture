package cn.com.architecture.shop.task;

import cn.com.architecture.shop.config.AppConstant;
import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.service.ItemService;
import cn.com.architecture.shop.service.MailService;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import scala.App;
import utils.JsonUtil;
import utils.okhttputil.OkHttpUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by summer on 2016/12/1.
 */

@Component
public class ItemSchedulerTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    ItemService itemService;

    @Autowired
    MailService mailService;

    private int count=0;

    private static String TIME_DAILY_ZERO = "0 0 0 * * ?";//每天0点清理
    private static String TIME_DAILY_23 = "0 0 23 * * ?";//每天0点清理
    private static String TIME_EVERY_HOUR = "0 0 * * * ?";//每小时
    private static String TIME_EVERY_MINUTE = "0 * * * * ?";//每分钟
    private static String TIME_EVERY_SECOND = "0/1 * * * * ?";//每秒钟
    private static String TIME_EVERY_FIVE_MINUTE = "0 */5 * * * ?";//每五分钟

    //每小时
    @Scheduled(cron="0 */5 * * * ?")
    private void process(){


        //System.out.println("当前时间:"+new Date().toLocaleString());

        List<Item> itemList = itemService.getItemList();

        for (Item i:itemList){

            String url = AppConstant.baseUrl;
            String itemUrl = i.getUrl();
            String itemName = i.getName();

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

                logger.info(result);

                //当天价格比历史最低价格高不了50块,进行推送,也就是,历史最低100块,那么在149以内都会进行推送
                if(todayPrice<minPrice+50){



                    //mailService.sendSimpleMail();


                    logger.info("当天价格符合预期价格,推送通知");

                }

            }catch (Exception e){
                logger.error("刷新价格异常",e);
            }

        }

    }

}
