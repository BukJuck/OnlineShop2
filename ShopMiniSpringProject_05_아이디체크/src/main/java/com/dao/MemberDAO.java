package com.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate template;

	public void memberAdd(MemberDTO m) {
		int n = template.insert("MemberMapper.memberAdd", m);
//		System.out.println("insert 갯수: " + n);
	}

	public MemberDTO login(Map<String, String> map) {
		return template.selectOne("MemberMapper.login", map);
	}

	public MemberDTO mypage(String userid) {
		return template.selectOne("MemberMapper.mypage", userid);
		
	}

	public int idCheck(String userid) {
		return template.selectOne("MemberMapper.idCheck", userid);
	}
}
