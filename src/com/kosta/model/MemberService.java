package com.kosta.model;

public class MemberService {
	MemberDAO dao = new MemberDAO();

	public MemberVO loginCheck(int mid, String mpassword) {
		return dao.loginCheck(mid, mpassword);
	}

}
