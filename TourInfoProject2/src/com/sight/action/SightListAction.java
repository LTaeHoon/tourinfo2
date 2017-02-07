package com.sight.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.sight.model.SightBean;
import com.sight.model.SightDAO;

public class SightListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		SightDAO dao = new SightDAO();
		
		List<SightBean> list = dao.selectSight();
		request.setAttribute("list", list); 
		
		ActionForward forward = new ActionForward();
		

		forward.setRedirect(false); 
		forward.setPath("./jsp/touristSites.jsp"); 

		
		return forward;
		
	} 
	


}
