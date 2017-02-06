package com.controller.action;

import javax.servlet.http.*;

// Action 클래스 생성용
public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
