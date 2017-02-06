<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- result.jsp : Action 클래스에서 key 포워딩 -->

이름 : ${NAME} <br>
나이 : ${AGE} <br>

<hr>

<!-- 2차 작성 -->

<a href="<%=request.getContextPath() %>/actionTwo.do">actionTwo.do</a>