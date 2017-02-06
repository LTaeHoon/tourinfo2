package com.food.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.food.model.FoodBean;
import com.food.model.FoodDAO;

public class FoodListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		FoodDAO dao = new FoodDAO();
		
		List<FoodBean> list = dao.FoodXmlParsing(); 
		
		request.setAttribute("list", list); 
		
		ActionForward forward = new ActionForward();
		

		forward.setRedirect(false); 
		forward.setPath("./jsp/cuisine.jsp"); 

		
		return forward;
		
	} 
	


}
