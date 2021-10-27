package com.kosta.controller5;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// HttpSessionBindingListener : ������ ���� ����ɶ� �߻�
//public class LoginImpl implements HttpSessionBindingListener {
@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
	}

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("���� ����");
		++total_user;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("���� �Ҹ�");
		--total_user;
	}

	/*
	 * @Override public void valueBound(HttpSessionBindingEvent arg0) {
	 * System.out.println("����� ����"); ++total_user; }
	 * 
	 * @Override public void valueUnbound(HttpSessionBindingEvent arg0) {
	 * System.out.println("����� ���� ����"); total_user--; }
	 */
}
