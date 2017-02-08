package com.main.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;





import db.DriverTest;

public class CommonDAO {
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;	
	private String sql=null;
	
	public CommonDAO(){
		try{
			DriverTest db = new DriverTest();
			con = db.con(); // 커넥션 가져오기
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	//숙박 contentid 리스트 반환하는 함수
	public List<String> select(){
		List<String> content = new ArrayList<String>();
		
		sql = "select contentid from tourcode";
		try{
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				content.add(rs.getString(1));	
			}
			rs.close();pstmt.close();
		}catch(Exception  e){
			e.printStackTrace();
		}
		return content;
	}
	
	
	public List<Commonbean> commonparsing(List<String> accom) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		List<String> urllist = new ArrayList<String>();
		
		NodeList addr1 = null;
		NodeList contentid = null;
		NodeList contenttypeid = null;
		NodeList firstimage=null; 
		NodeList overview=null; 
		NodeList title=null;
		NodeList homepage=null;
		NodeList zipcode = null;
		NodeList telno = null;
		
		//accomcontent id 값 을 매개변수로 받아오기
		String url=null;
		for(String a : accom){
				url = "http://api.visitkorea.or.kr/openapi/"
		 				+ "service/rest/KorService/detailCommon?"
		 				+ "ServiceKey=EeBjN2xdCzzcqHvefO0rZXaycAim0uGpKxnOX72PY1UpkSZnifzIK1kxLm61XXaQ4pFxhbW%2F%2FZbmQDKFiAFNVA%3D%3D&"
		 				+ "contentId=" +a
		 				+ "&defaultYN=Y&"
		 				+ "addrinfoYN=Y&"
		 				+ "firstImageYN=Y&"
		 				+ "overviewYN=Y&"
		 				+ "MobileOS=ETC&MobileApp=AppTesting"; 
				urllist.add(url);
			
		}
		
		List<Commonbean> list = new ArrayList<Commonbean>();
		
		for(String u:urllist){
			// XML Document 객체 생성 
			
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(u); 
			XPath xpath = XPathFactory.newInstance().newXPath(); 
	 		
	 		
	 		addr1 = (NodeList)xpath.evaluate("//item/addr1", document, XPathConstants.NODESET); 
	 		contentid = (NodeList)xpath.evaluate("//item/contentid", document, XPathConstants.NODESET);
	 		contenttypeid = (NodeList)xpath.evaluate("//item/contenttypeid", document, XPathConstants.NODESET);
	 		firstimage = (NodeList)xpath.evaluate("//item/firstimage", document, XPathConstants.NODESET); 
	 		overview = (NodeList)xpath.evaluate("//item/overview", document, XPathConstants.NODESET); 
	 		title = (NodeList)xpath.evaluate("//item/title", document, XPathConstants.NODESET); 
	 		homepage = (NodeList)xpath.evaluate("//item/homepage", document, XPathConstants.NODESET);
	 		telno= (NodeList)xpath.evaluate("//item/tel", document, XPathConstants.NODESET);
	 		zipcode = (NodeList)xpath.evaluate("//item/zipcode", document, XPathConstants.NODESET);
	 		//System.out.println(telno);
		
	 		Commonbean bean = new Commonbean(); 
	 		
	 		String address = null;
	 		String content = null;
	 		String contype = null;
	 		String fimage = null;
	 		String ov = null;
	 		String tit = null;
	 		String home = null;
	 		String tel = null;
	 		String zip = null;
	 		
	 		if (0 < addr1.getLength()) {
	 			address=addr1.item(0).getTextContent();
	 		} else {
	 			address = "";
	 		}
	 		if (0 < contentid.getLength()) {
	 			content=contentid.item(0).getTextContent();
	 		} else {
	 			content = "";
	 		}
	 		if (0 < contenttypeid.getLength()) {
	 			contype=contenttypeid.item(0).getTextContent();
	 		} else {
	 			contype = "";
	 		}
	 		if (0 < firstimage.getLength()) {
	 			fimage=firstimage.item(0).getTextContent();
	 		} else {
	 			fimage = "";
	 		}
	 		if (0 < overview.getLength()) {
	 			ov=overview.item(0).getTextContent();
	 		} else {
	 			ov = "";
	 		}
	 		if (0 < title.getLength()) {
	 			tit=title.item(0).getTextContent();
	 		} else {
	 			tit = "";
	 		}
	 		if (0 < homepage.getLength()) {
	 			home=homepage.item(0).getTextContent();
	 		} else {
	 			home = "";
	 		}
	 		if (0 < telno.getLength()) {
	 			tel=telno.item(0).getTextContent();
	 		} else {
	 			tel = "";
	 		}
	 		
	 		if (0 < zipcode.getLength()) {
	 			zip=zipcode.item(0).getTextContent();
	 		} else {
	 			zip = "";
	 		}
	 		
	 	
/*
	 		try {
	 			address = StringUtils.defaultString(addr1.item(0).getTextContent());
		 		content = StringUtils.defaultString(contentid.item(0).getTextContent());
		 		contype= StringUtils.defaultString(contenttypeid.item(0).getTextContent());
		 		fimage = StringUtils.defaultString(firstimage.item(0).getTextContent());
		 		ov = StringUtils.defaultString(overview.item(0).getTextContent());
		 		tit= StringUtils.defaultString(title.item(0).getTextContent());
		 		home= StringUtils.defaultString(homepage.item(0).getTextContent());
	 		} catch (NullPointerException e) {
	 			System.out.println(e);
	 			System.out.println(telno);
	 			System.out.println(telno.getLength());
	 		}*/
//	 		if () {
//	 			tel= StringUtils.defaultString();
//	 		}
	 		
	 	
	 		
	 		
	 		/*System.out.println(addr1.item(0).getTextContent());
	 		System.out.println(contentid.item(0).getTextContent());
	 		*/
	 		bean.setAddr1(address); 
	 		bean.setContentid(content);
	 		bean.setContenttypeid(contype);
	 		bean.setFirstimage(fimage); 
	 		bean.setOverview(ov);
	 		bean.setTitle(tit);
	 		bean.setHompage(home);
	 		bean.setTel(tel);
	 		bean.setZipcode(zip);
	 		
	 		
	 		list.add(bean); 
		}
 		
 		
 		
 		
 		return list;
 		
	}
	public void insert(List<Commonbean> com) throws SQLException{
		
		
		for(Commonbean bean : com){
			try{
			sql ="insert into commoninfo values(?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bean.getContentid());
			pstmt.setString(2, bean.getContenttypeid());
			pstmt.setString(3, bean.getAddr1());
			pstmt.setString(4, bean.getFirstimage());
			pstmt.setString(5, bean.getOverview());
			pstmt.setString(6, bean.getTitle());
			pstmt.setString(7, bean.getHompage());
			pstmt.setString(8, bean.getTel());
			pstmt.setString(9, bean.getZipcode());
			int re=pstmt.executeUpdate();
				if(re>=1){
					System.out.println("insert 성공");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				pstmt.close();
			}
			
		}
		con.close();
	}
	
	  //주변 식당 정보 가져오기
	   public Commonbean getSurroundFood(String id){      
	      Commonbean bean = null;
	      
	      sql ="select * from COMMONINFO "
	         + "where zipcode=(select zipcode from COMMONINFO where contentid=?)"
	         + "and contenttypeid=39";
	      try{
	         
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs=pstmt.executeQuery();//쿼리문 실행
	         
	          while(rs.next()){
	             
	             bean = new Commonbean();
	             bean.setTitle(rs.getString("title"));
	             bean.setFirstimage(rs.getString("firstimage"));
	             bean.setTel(rs.getString("telno"));
	             bean.setAddr1(rs.getString("addr1"));
	             bean.setZipcode(rs.getString("zipcode"));
	             bean.setHompage(rs.getString("homepage"));
	             bean.setOverview(rs.getString("overview"));             
	             
	          }
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      return bean;         
	   }
	   
	   //주변 숙소 정보 가져오기
	      public Commonbean getSurroundAccom(String id){      
	    	  Commonbean bean =null;
	    	  sql ="select * from COMMONINFO "
	      	            + "where zipcode=(select zipcode from COMMONINFO where contentid=?)"
	      	            + "and contenttypeid=32";
	       
	         try{
	        	 pstmt=con.prepareStatement(sql);
		         pstmt.setString(1, id);
		         rs=pstmt.executeQuery();//쿼리문 실행
		     
      	             while(rs.next()){
      	                
      	            	bean = new Commonbean();
      	                bean.setTitle(rs.getString("title"));
      	                bean.setFirstimage(rs.getString("firstimage"));
      	                bean.setTel(rs.getString("telno"));
      	                bean.setAddr1(rs.getString("addr1"));
      	                bean.setZipcode(rs.getString("zipcode"));
      	                bean.setHompage(rs.getString("homepage"));
      	                bean.setOverview(rs.getString("overview"));  
      	                
      	             }
		         
		         }catch(Exception e){
			            e.printStackTrace();
		         }
		        
		        return bean;      
	         
	        
	             
	           
	      }
	      
	      //주변 관광지 정보 가져오기
	      public Commonbean getSurroundSight(String id){      
	         Commonbean bean = null;
	         
	         sql ="select * from COMMONINFO "
	               + "where zipcode=(select zipcode from COMMONINFO where contentid=?)"
	               + "and contenttypeid=12";
	         try{
	            
	            pstmt=con.prepareStatement(sql);
	            pstmt.setString(1, id);
	            rs=pstmt.executeQuery();//쿼리문 실행
	            
	            while(rs.next()){
	               
	               bean = new Commonbean();
	               bean.setTitle(rs.getString("title"));
	               bean.setFirstimage(rs.getString("firstimage"));
	               bean.setTel(rs.getString("telno"));
	               bean.setAddr1(rs.getString("addr1"));
	               bean.setZipcode(rs.getString("zipcode"));
	               bean.setHompage(rs.getString("homepage"));
	               bean.setOverview(rs.getString("overview"));             
	               
	            }
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	         return bean;         
	      }
	      
	      public int getcountfood(String id){
	    	  int result =-1;
	    	  int count=0;
		         sql = "select count(*) from COMMONINFO where zipcode=(select zipcode from COMMONINFO where contentid=?) and contenttypeid=32";
		         try{
		        	 pstmt=con.prepareStatement(sql);
			         pstmt.setString(1, id);
			         rs=pstmt.executeQuery();//쿼리문 실행
			         if(rs.next()){
			         count = rs.getInt(1);
			         }//
			         System.out.println(count);
			         if(count>0){ // 값이 있는 경우
			        	 result=1;
			         }
			         rs.close();pstmt.close();
		         }catch(Exception e){
		        	 e.printStackTrace();
		         }
			         return result;
	      	}
	      
}
