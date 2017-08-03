package utils.okhttputil.test;

import utils.okhttputil.OkHttpUtils;
import utils.okhttputil.callback.MyStringCallback;

public class OkhttpDemo {

    public static void main(String args[]) throws Exception{

        //http://suggest.taobao.com/sug?code=utf-8&q=商品关键字&callback=cb

        OkHttpUtils.get()
                .url("http://suggest.taobao.com/sug")
                .addParams("code","utf-8")
                .addParams("q","机械键盘")
                .addParams("callback","cb")
                .build()
                .execute(new MyStringCallback());

    }

}
