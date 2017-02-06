<%@page import="com.sight.model.SightBean"%>
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
    <section id="imgBanner">
      <h2>Tourist Sites</h2>
    </section>
    <!--=========== END COURSE BANNER SECTION ================-->
    
    <!--=========== BEGIN COURSE BANNER SECTION ================-->
    <section id="courseArchive">
      <div class="container">
        <div class="row">
          <!-- start course content -->
          
			<%

			List<SightBean> list = (List<SightBean>)request.getAttribute("list");


			%>
			
			<h2>관광지 list</h2>

			<table border="1" width="1100">
			
				<%
				
				if (list != null){
					
					
					for (SightBean bean : list){
						
						
						%>
						
						<tr>
						
							<td rowspan="3">
							
								<img src="<%=bean.getFirstimage() %>" width="200" height="200"/>
							
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

							<td width="900">
								<%=bean.getOverview().substring(0, 200) %>...
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