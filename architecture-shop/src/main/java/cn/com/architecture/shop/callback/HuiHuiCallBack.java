package cn.com.architecture.shop.callback;
/**
 * Created by li on 2018/6/3.
 */

import okhttp3.Response;
import utils.okhttputil.callback.Callback;

import java.io.IOException;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class HuiHuiCallBack extends Callback<String>
{
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException
    {




        return response.body().string();
    }
}
