package cn.com.architecture.entity.wechat.user;

import cn.com.architecture.entity.wechat.result.WechatCommonResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 获取微信用户列表返回的实体
 * Created by jeysine on 2018/2/11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WechatUserList extends WechatCommonResult {
    private static final long serialVersionUID = -684293493704544765L;
    @JsonProperty("user_info_list")
    private List<WechatUser> userInfoList;

    public List<WechatUser> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<WechatUser> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @Override
    public String toString() {
        return super.toString() + "WechatUserDTO{" +
                "userInfoList=" + userInfoList +
                '}';
    }
}
