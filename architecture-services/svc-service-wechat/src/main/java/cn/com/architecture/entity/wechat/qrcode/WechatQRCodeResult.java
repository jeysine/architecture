package cn.com.architecture.entity.wechat.qrcode;

import cn.com.architecture.entity.wechat.result.WechatCommonResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeysine on 2018/1/23.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WechatQRCodeResult extends WechatCommonResult {
    private static final long serialVersionUID = -6847190001607272687L;
    @JsonProperty("ticket")
    private String ticket;

    @JsonProperty("expire_seconds")
    private Long expireSeconds;

    @JsonProperty("url")
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Long getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Long expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WechatQRCodeResult{" +
                "ticket='" + ticket + '\'' +
                ", expireSeconds=" + expireSeconds +
                ", url='" + url + '\'' +
                '}';
    }
}
