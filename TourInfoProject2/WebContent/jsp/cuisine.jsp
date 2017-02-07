<%@page import="com.food.model.FoodBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String email = (String)session.getAttribute("email");
%>     
<script src="./js/jquery-3.js"></script>
<script>
	$(function(){
		if(<%=(String)session.getAttribute("email")%>==null){
			$("#header2").hide();
		}else{
			$("#header").hide();
		}
	})
</script>    
    
<span id = "header">
<%@ include file="../include/header.jsp" %>
</span>
<span id = "header2">
<%@ include file="../include/header2.jsp" %>
</span>  

	<!--=========== BEGIN COURSE BANNER SECTION ================-->
    <section id="imgBanner3">
      <h2>Cuisine</h2>
    </section>
    <!--=========== END COURSE BANNER SECTION ================-->
    
    <!--=========== BEGIN COURSE BANNER SECTION ================-->
    <section id="courseArchive">
      <div class="container">
        <div class="row">
        
			<% 
			List<FoodBean> list = (List<FoodBean>)request.getAttribute("list");
			%>
			
			<h2>음식 list</h2>

			<table border="1" width="1100" style="table-layout:fixed">
				<%
				if (list!= null){
					for (FoodBean bean : list){
						
						%>
						<tr>
							<td rowspan="3">
								<%if(bean.getFirstimage()==null){
									%><img src="#" width="200" height="200"/>
									 <% 
								}else{%>
								<img src="<%=bean.getFirstimage()%>" width="200" height="200"/>
								<%}
								%>
							</td>
							<td width="900">
								<%=bean.getTitle() %>
							</td>
						</tr>
						<tr>
							<td width="900">
								<%=bean.getAddr1() %>
							</td>
						</tr>
						<tr>
							<td width="900" style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">
								<%=bean.getOverview()%>...
							</td>
						</tr>
						<%				
					}
				}
				%>
			</table>    

        </div>
      </div>
    </section>
    <!--=========== END COURSE BANNER SECTION ================-->
<%@ include file="../include/footer.jsp" %>