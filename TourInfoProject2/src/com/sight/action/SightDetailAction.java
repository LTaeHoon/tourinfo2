package com.sight.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.sight.model.SightBean;
import com.sight.model.SightDAO;

public class SightDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String contentid = request.getParameter("contentid");
		String contenttypeid = request.getParameter("contenttypeid");
		
		request.setAttribute("contentid", contentid);
		request.setAttribute("contenttypeid", contenttypeid);
		
		
		ActionForward forward = new ActionForward();
		

		forward.setRedirect(false); 
		forward.setPath("./sight/touristSites_detail.jsp"); 

		
		return forward;
	}

}
