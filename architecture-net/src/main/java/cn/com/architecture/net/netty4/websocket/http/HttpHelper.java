package cn.com.architecture.net.netty4.websocket.http;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by p on 2016-09-28.
 */
public class HttpHelper {
    //    private static final MD5 md5 = new MD5();
    private static final String SIGN_NAME = "signature";

    private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    public static boolean validateSign(Map<String, List<String>> uriParams) {
        if (!AppContext.isHttpSwitch())
            return true;

        String sign = uriParams.get(SIGN_NAME).get(0);
        uriParams.remove(SIGN_NAME);
        System.out.println(makeSign(uriParams));
        if (!sign.equals(makeSign(uriParams))) {
            logger.info("validateSign fail: sign:"+sign+", makeSign:"+makeSign(uriParams));
            StringBuilder stringBuilder = new StringBuilder();
            uriParams.entrySet().forEach(entry -> stringBuilder.append(entry.getKey()).append("=").append(entry.getValue().get(0)).append(","));
            logger.info("validateSign fail: uriParams:"+stringBuilder.toString());
            return false;
        }
        return true;
    }

    public static String makeSign(Map<String, List<String>> uriParams) {
        List<PostParameter> paramsArr = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : uriParams.entrySet()) {
            PostParameter param = new PostParameter(entry.getKey(), entry.getValue().get(0));
            paramsArr.add(param);
        }

        return makeSign(paramsArr);
    }

    public static String makeSign(List<PostParameter> params) {
        Collections.sort(params, Comparator.comparing(o -> (o.getName())));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setLength(0);
        for (PostParameter param : params) {
            stringBuilder.append(param.getName()).append("=").append(param.getValue()).append("&");
        }

        return new MD5().toDigest(stringBuilder.append(AppContext.getSecretKey()).toString());
    }

    public static String buildUrl(Map<String, String> uriParams) {
        List<PostParameter> paramsArr = new ArrayList<>();

        for (Map.Entry<String, String> entry : uriParams.entrySet()) {
            PostParameter param = new PostParameter(entry.getKey(), entry.getValue());
            paramsArr.add(param);
        }
        Collections.sort(paramsArr, Comparator.comparing(o -> (o.getName())));
        StringBuilder stringBuilder = new StringBuilder();
        for (PostParameter param : paramsArr) {
            stringBuilder.append(param.getName()).append("=").append(param.getValue()).append("&");
        }
        stringBuilder.append("signature").append("=").append(makeSign(paramsArr));
        return stringBuilder.toString();
    }
}
