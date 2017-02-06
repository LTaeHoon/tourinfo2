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

			<table border="1">
			
				<%
				
				if (list != null){
					
					
					for (FoodBean bean : list){
						
						
						%>

						<tr>
							
							<th>
							title
							</th>
							
							<td>
							<%=bean.getTitle() %>
							</td>
						</tr>
						
						<tr>
							
							<th>
							addr1
							</th>
							
							<td>
							<%=bean.getAddr1() %>
							</td>
						</tr>
						
						<tr>
							
							<th>
							contentid
							</th>
							
							<td>
							<%=bean.getContentid() %>
							</td>
						</tr>
						
						<tr>
							
							<th>
							contentypeid
							</th>
							
							<td>
							<%=bean.getContenttypeid() %>
							</td>
						</tr>
						
						<tr>
							
							<th>
							firstimage
							</th>
							
							<td>
							<%=bean.getFirstimage() %>
							</td>
						</tr>
						
						<tr>
							
							<th>
							overview
							</th>
							
							<td>
							<%=bean.getOverview() %>
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