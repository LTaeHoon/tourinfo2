<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- jsp/mvcTest.jsp -->

<!-- 1차 작성 -->
<h2> mvcTest.jsp 페이지 입니다. </h2>
<hr>


<!-- 2차 작성 -->
<a href="<%=request.getContextPath() %>/actionOne.do">actionOne.do</a>
<hr>


<!-- 3차 작성 : 2개의 변수 받기 -->
<h3> 2개 변수 받기 </h3>
FILE : ${param.FILE} <br>
URL : ${param.URL} <br>
<hr>