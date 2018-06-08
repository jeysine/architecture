package cn.com.architecture.shop.web;

import cn.com.architecture.shop.config.AppConstant;
import cn.com.architecture.shop.demo.JdDemo;
import cn.com.architecture.shop.service.MailService;
import cn.com.architecture.shop.service.impl.MailServiceImpl;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.JsonUtil;
import utils.okhttputil.OkHttpUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@Controller
public class HelloController extends BaseController{

    @Resource
    private MailService mailService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/user/list";
    }

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name){

        JdDemo.itemMap.forEach((itemName, itemUrl)->{

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

                if(itemName.equals("老茶树龙井")){



                    mailService.sendSimpleMail("649489698@qq.com","商品详情",result);
                }

                System.out.println(result);

            }catch (Exception e){
                e.printStackTrace();
            }

        });

        return "hello";

    }


}
