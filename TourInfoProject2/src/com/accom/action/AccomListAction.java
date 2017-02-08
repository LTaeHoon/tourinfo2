package com.accom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accom.model.AccomBean;
import com.accom.model.AccomDAO;
import com.controller.action.Action;
import com.controller.action.ActionForward;


public class AccomListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		AccomDAO dao = new AccomDAO();
		
		int page = 1;
		int limit = 10; // 한 페이지에 보여지는 목록수 지정
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int listcount = dao.getListCount();
		
		List<AccomBean> list = dao.selectAccom(page,limit); 
		int maxpage = (int)((double)listcount/limit+0.95);
		// 총페이지 수 구하는 수식
		int startpage = (((int)((double)page/10+0.9))-1)*10+1;
		// 시작 페이지 구하는 수식
		int endpage = maxpage;
		if(endpage > startpage+10-1) endpage = startpage+10-1;
		request.setAttribute("page",page); // 쪽번호 저장
		request.setAttribute("maxpage", maxpage); //총페이지 수 저장
		request.setAttribute("startpage", startpage);//시작페이지
		request.setAttribute("endpage", endpage); // 끝 페이지
		request.setAttribute("listcount",listcount); // 총레코드 수
		request.setAttribute("limit", limit); // 페이지 당 목록 수
		request.setAttribute("list", list); 
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(false); 
		forward.setPath("./accom/accommodation.jsp"); 

		
		return forward;
	}

}
