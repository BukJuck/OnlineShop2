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

	public void memberAdd(MemberDTO m) throws Exception{
		int n = template.insert("MemberMapper.memberAdd", m);
//		System.out.println("insert 갯수: " + n);
	}

	public MemberDTO login(Map<String, String> map) throws Exception{
		return template.selectOne("MemberMapper.login", map);
	}

	public MemberDTO mypage(String userid) throws Exception{
		return template.selectOne("MemberMapper.mypage", userid);
		
	}

	public int idCheck(String userid)throws Exception {
		return template.selectOne("MemberMapper.idCheck", userid);
	}

	public void memberUpdate(MemberDTO m)throws Exception {
		int n = template.update("MemberMapper.memberUpdate", m);
		System.out.println(n);
		
	}
}
