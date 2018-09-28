package com.cafe24.iumium.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.dto.UserLoginData;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.dao.UserMapper.";
	
	// 사용자 로그인 체크
	public UserLoginData userLoginCheck(UserLoginData userLoginData) {
		System.out.println("userDao - userLoginCheck() - input id : " + userLoginData.getUserId() + ", input pw : " + userLoginData.getUserPw());
		UserLoginData userLevel = null;
		try {
			userLevel = sqlSessionTemplate.selectOne(nameSpace + "userLoginCheck", userLoginData);
			System.out.println("userDao - userLoginCheck() - output id : " + userLevel.getUserId() + ", output level : " + userLevel.getUserLevel());
		} catch(Exception e) {
			System.out.println("아이디 혹은 비밀번호가 다름");
		}
		return userLevel;
	}
}
