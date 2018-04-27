package cn.com.architecture.entity.wechat.callbackip;

import cn.com.architecture.entity.wechat.result.WechatCommonResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jeysine on 2018/2/27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class WechatCallBackIp extends WechatCommonResult {

    private static final long serialVersionUID = 3852308229703322285L;
    @JsonProperty("ip_list")
    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    @Override
    public String toString() {
        return "WechatCallBackIp{" +
                "ipList=" + ipList +
                '}';
    }
}
