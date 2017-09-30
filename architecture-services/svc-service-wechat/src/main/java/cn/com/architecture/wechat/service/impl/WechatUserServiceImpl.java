package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.entity.WechatUser;
import cn.com.architecture.wechat.service.WechatAccessTokenService;
import cn.com.architecture.wechat.service.WechatUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wechatUserService")
public class WechatUserServiceImpl implements WechatUserService{
	@Value("${wechat.get.user.url}")
	private String getWechatUserUrl;
	@Value("${wechat.get.user.list.url}")
	private String getWechatUserListUrl;
	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;

	private static final ObjectMapper mapper = new ObjectMapper();
	@Override
	public WechatUser getWechatUserInfo(String openid, String lang) throws IOException {
		WechatAccessToken wechatAccessToken = wechatAccessTokenService.getAccessToken();
		String url = getWechatUserUrl.replace("ACCESS_TOKEN", wechatAccessToken.getAccessToken())
				.replace("OPENID", openid);
		Response response = OkHttpUtils.get().url(url).build().execute();

		return mapper.readValue(response.body().toString(), WechatUser.class);
	}

	@Override
	public List<WechatUser> getWechatUserInfoList(List<String> openids) throws IOException {
		WechatAccessToken wechatAccessToken = wechatAccessTokenService.getAccessToken();
		String url = getWechatUserUrl.replace("ACCESS_TOKEN", wechatAccessToken.getAccessToken());
		Map<String, Object> map = new HashMap<>();
		map.put("user_list", openids);
		String properties = mapper.writeValueAsString(map);
		Response response = OkHttpUtils.postString().url(url).content(properties).build().execute();

		return mapper.readValue(response.body().toString(),
				mapper.getTypeFactory().constructParametricType(List.class, WechatUser.class));
	}
}
