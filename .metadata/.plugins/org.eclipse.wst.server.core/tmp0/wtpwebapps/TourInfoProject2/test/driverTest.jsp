<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>    
 
<%
  Connection con = null;  
  try{
	  String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	  String uid = "scott";
	  String pwd = "tiger";
	  String driver = "oracle.jdbc.driver.OracleDriver";
	  
	  // 1단계 : 드라이버 로딩
	  Class.forName(driver);
	  // 2단계 : DB 연동(3개 파라미터 사용)
	  con = DriverManager.getConnection(url, uid, pwd);
	  
	  // 쿼리문 작성 영역 시작
	  
	  
	  
	  
	  // 쿼리문 작성 영역 끝
	  
	  out.println("DB에 연결되었습니다.");
  }catch(Exception e){
	  e.printStackTrace();
	  out.println("DB 연결에 실패하였습니다.");
  }
%>    
