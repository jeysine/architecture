package utils.okhttputil.test;

import okhttp3.Response;
import utils.okhttputil.OkHttpUtils;
import utils.okhttputil.callback.MyStringCallback;

public class OkhttpDemo {

    public static void main(String args[]) throws Exception{

        //http://suggest.taobao.com/sug?code=utf-8&q=商品关键字&callback=cb
        //回调
        OkHttpUtils.get()
                .url("http://suggest.taobao.com/sug")
                .addParams("code","utf-8")
                .addParams("q","机械键盘")
                .addParams("callback","cb")
                .build()
                .execute(new MyStringCallback());


        //同步调用
        String url = "https://www.baidu.com";
        Response response = OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute();
        System.out.println(response.body().string());

        //传递字符串
        OkHttpUtils.postString().url(url).content("123").build().execute();

    }

}
