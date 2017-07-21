package utils.okhttputil.builder;

import utils.okhttputil.OkHttpUtils;
import utils.okhttputil.request.OtherRequest;
import utils.okhttputil.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
