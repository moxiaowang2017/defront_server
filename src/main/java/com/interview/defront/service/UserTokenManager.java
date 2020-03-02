package com.interview.defront.service;


import com.interview.defront.utils.JwtHelper;
import jodd.util.StringUtil;

/**
 * 维护用户token
 */
public class UserTokenManager {
	public static String generateToken(String id) {
        JwtHelper jwtHelper = new JwtHelper();
        return jwtHelper.createToken(id);
    }
    public static String getUserId(String token) {
    	JwtHelper jwtHelper = new JwtHelper();
    	String userId = jwtHelper.verifyTokenAndGetUserId(token);
    	if(userId == null || StringUtil.isBlank(userId)){
    		return null;
    	}
        return userId;
    }
}
