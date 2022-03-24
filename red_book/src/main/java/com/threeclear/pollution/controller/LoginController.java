package com.threeclear.pollution.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.threeclear.baseweb.vo.ServerResponse;
import com.threeclear.pollution.dto.RedBookDto;
import com.threeclear.pollution.util.HttpClientResult;
import com.threeclear.pollution.util.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 登录Controller
 *
 * @author lichen
 * @Date 2018/9/18
 */
@Slf4j
@RestController
@RequestMapping("redBook")
public class LoginController{

	@PostMapping("/queryShieldParam")
	public ServerResponse<String> queryShieldParam(@RequestBody RedBookDto redBookDto, HttpServletResponse response, HttpServletRequest servletRequest) {
		String userName = redBookDto.getUserName();
		String password = redBookDto.getPassword();
		String areaCode = redBookDto.getAreaCode();
		List<String> articleIds = redBookDto.getArticleIds();
		Map<String,Object> map = new HashMap<>();
		//调用登录接口
		/*String url = "https://edith.xiaohongshu.com/api/sns/v4/user/login/password";
		Map<String, String> param = new HashMap<String, String>();
		param.put("phone","17662740351");
		param.put("password","BE7DE7BD3B5B53C9EB76E144AC072E29");
		param.put("zone","86");*/
		String url = "http://42.192.249.77:62323/xhs/shield";
		Map<String, String> param = new HashMap<String, String>();
		param.put("url","https://edith.xiaohongshu.com/api/sns/v4/user/login/password");
		param.put("xy-platform-info","platform=iOS&version=7.31&build=7310208&deviceId=AE75A695-8926-4E7C-9E01-50D24D154911&bundle=com.xingin.discover");
		param.put("xy-common-params","app_id=ECFAAF02&build=7310208&deviceId=AE75A695-8926-4E7C-9E01-50D24D154911&device_fingerprint=202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e&device_fingerprint1=202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e&fid=1623645368-0-0-62b998c5fdd8105d5dec9ba0739d93a8&identifier_flag=1&lang=zh-Hans&launch_id=669644963&platform=iOS&project_id=ECFAAF&sid=session.1647954532938490135244&t=1648087620&teenager=0&tz=Asia/Shanghai&uis=dark&version=7.31");
		//param.put("device_info","{'deviceId': 'AE75A695-8926-4E7C-9E01-50D24D154911', 'device_fingerprint': '202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e', 'sid': 'session.1647954532938490135244'}");
		JSONObject json = new JSONObject();
		json.put("deviceId","AE75A695-8926-4E7C-9E01-50D24D154911");
		json.put("device_fingerprint","202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e");
		json.put("sid","session.1647954532938490135244");
		param.put("device_info", json.toJSONString());
		HttpClientResult result = null;
		String data = "";
		try {
			result = HttpClientUtils.doPost(url,param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Objects.requireNonNull(result,"返回值异常!");
		if(result.getCode()== 200){
			data = result.getContent();
		}

		return ServerResponse.createBySuccess(data);
	}

	@PostMapping("/login")
	public ServerResponse<String> login(@RequestBody RedBookDto redBookDto, HttpServletResponse response, HttpServletRequest servletRequest) {
		String userName = redBookDto.getUserName();
		String password = redBookDto.getPassword();
		String areaCode = redBookDto.getAreaCode();
		List<String> articleIds = redBookDto.getArticleIds();
		Map<String,Object> map = new HashMap<>();
		//调用shield算法接口实时获取参数
		String shield = this.getShieldParam();
		log.info("shield=========="+shield);
		//调用登录接口
		String url = "https://edith.xiaohongshu.com/api/sns/v4/user/login/password";
		Map<String, String> param = new HashMap<String, String>();
		param.put("phone","17662740351");
		param.put("password","BE7DE7BD3B5B53C9EB76E144AC072E29");
		param.put("zone","86");
		param.put("idfa","D2F9AAA9-9F9F-478B-B8EC-546B4DE3F47F");
		param.put("idfv","0C79AB8E-75F6-44C5-A794-5A520EDC0ABF");
		HttpClientResult result = null;
		String data = "";
		try {
			result = HttpClientUtils.doPostLogin(url,null,param,shield);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Objects.requireNonNull(result,"返回值异常!");
		if(result.getCode()== 200){
			data = result.getContent();
		}

		return ServerResponse.createBySuccess(data);
	}

	public String getShieldParam() {
		//调用登录接口
		/*String url = "https://edith.xiaohongshu.com/api/sns/v4/user/login/password";
		Map<String, String> param = new HashMap<String, String>();
		param.put("phone","17662740351");
		param.put("password","BE7DE7BD3B5B53C9EB76E144AC072E29");
		param.put("zone","86");*/
		String url = "http://42.192.249.77:62323/xhs/shield";
		Map<String, String> param = new HashMap<String, String>();
		String time = String.valueOf(System.currentTimeMillis());
		param.put("url","https://edith.xiaohongshu.com/api/sns/v4/user/login/password");
		param.put("xy-platform-info","platform=iOS&version=7.31&build=7310208&deviceId=AE75A695-8926-4E7C-9E01-50D24D154911&bundle=com.xingin.discover");
		param.put("xy-common-params","app_id=ECFAAF02&build=7310208&deviceId=AE75A695-8926-4E7C-9E01-50D24D154911&device_fingerprint=202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e&device_fingerprint1=202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e&fid=1623645368-0-0-62b998c5fdd8105d5dec9ba0739d93a8&identifier_flag=1&lang=zh-Hans&launch_id=669644963&platform=iOS&project_id=ECFAAF&sid=session.1647954532938490135244&t="+time+"&teenager=0&tz=Asia/Shanghai&uis=dark&version=7.31");
		JSONObject json = new JSONObject();
		json.put("deviceId","AE75A695-8926-4E7C-9E01-50D24D154911");
		json.put("device_fingerprint","202007111448467bce8fe19a2e01e06da88ecf0572a189011715cbe1fb800e");
		json.put("sid","session.1648037954124675738225");
		param.put("device_info", json.toJSONString());
		HttpClientResult result = null;
		String data = "";
		try {
			result = HttpClientUtils.doPost(url,param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Objects.requireNonNull(result,"返回值异常!");
		if(result.getCode()== 200){
			data = result.getContent();
		}

		return data;
	}
}
