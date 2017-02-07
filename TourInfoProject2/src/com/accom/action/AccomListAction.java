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
	
		List<AccomBean> list = dao.selectAccom(); 
		
		request.setAttribute("list", list); 
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(false); 
		forward.setPath("./jsp/accommodation.jsp"); 

		
		return forward;
	}

}
