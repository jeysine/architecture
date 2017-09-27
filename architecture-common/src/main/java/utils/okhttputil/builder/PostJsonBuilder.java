package utils.okhttputil.builder;

import okhttp3.MediaType;
import utils.okhttputil.request.PostStringRequest;
import utils.okhttputil.request.RequestCall;
import utils.okhttputil.type.TypeList;

/**
 * Created by lst on 17/09/27.
 */
public class PostJsonBuilder extends PostStringBuilder
{

    public PostJsonBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostJsonBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, TypeList.JSON_UTF8.getMediaType(),id).build();
    }


}
