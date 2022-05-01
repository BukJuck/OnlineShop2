package com.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;

	public void memberAdd(MemberDTO m)throws Exception {
		dao.memberAdd(m);
		
	}

	public MemberDTO login(Map<String, String> map) throws Exception{
		return dao.login(map);
	}

	public MemberDTO mypage(String userid) throws Exception{
		return dao.mypage(userid);
		
	}

	public int idCheck(String userid) throws Exception{
		return dao.idCheck(userid);
	}

	public void memberUpdate(MemberDTO m) throws Exception{
		dao.memberUpdate(m);
		
	}
	
}
