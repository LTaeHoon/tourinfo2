package com.sight.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.main.model.CommonDAO;
import com.main.model.Commonbean;
import com.map.model.MapDAO;
import com.map.model.Mapbean;
import com.sight.model.SightBean;
import com.sight.model.SightDAO;
import com.sight.model.SightDetailBean;

public class SightDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		String contentid = request.getParameter("contentid");
		
		SightDAO dao = new SightDAO();
		CommonDAO commdao = new CommonDAO();
		
		int result=commdao.getcountfood(contentid);
		if(result>0){
			Commonbean commbean = commdao.getSurroundAccom(contentid);
			request.setAttribute("commbean", commbean);
		}
		
		SightDetailBean bean_d = dao.selectSightDetail(contentid);
		
		SightBean bean = dao.getInfo(contentid);
		MapDAO map = new MapDAO();
	    Mapbean mapInfo = map.getMapInfo(contentid);
	    
	    
	    
	    request.setAttribute("mapInfo", mapInfo);
		request.setAttribute("bean_d", bean_d);
		request.setAttribute("bean", bean);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false); 
		forward.setPath("./sight/touristSites_detail.jsp"); 
		
		
		return forward;
	}

}
