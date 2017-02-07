package com.main.model;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import db.DBConnection;




public class XmlParsing {

	 public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Databean> beanlist = new ArrayList<Databean>();
		Databean bean = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;
		
		/*String url = "http://api.visitkorea.or.kr/openapi/"
					+"service/rest/KorService/areaBasedList?"
					+"ServiceKey=EeBjN2xdCzzcqHvefO0rZXaycAim0uGpKxnOX72PY1UpkSZnifzIK1kxLm61XXaQ4pFxhbW%2F%2FZbmQDKFiAFNVA%3D%3D"
					+"&areaCode=39"
					+"&numOfRows=330"
					+"&contentTypeId=12"
					+"&MobileOS=ETC&MobileApp=AppTesting";*/
		String turl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=EeBjN2xdCzzcqHvefO0rZXaycAim0uGpKxnOX72PY1UpkSZnifzIK1kxLm61XXaQ4pFxhbW%2F%2FZbmQDKFiAFNVA%3D%3D&numOfRows=1101&areaCode=39&MobileOS=ETC&MobileApp=AppTesting";
		 // XML Document 객체 생성
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(turl);
		
		//Xpath 생성
		XPath xpath = XPathFactory.newInstance().newXPath();

		String expression = "//item";
		NodeList items = (NodeList)xpath.compile(expression).evaluate(document,XPathConstants.NODESET);
		
		NodeList contentid=null;
		NodeList contenttypeid = null;
		NodeList title = null;
		for(int idx=0;idx <items.getLength();idx++){
			
			expression = "//item/contentid";
			contentid = (NodeList)xpath.compile(expression).evaluate(document,XPathConstants.NODESET);
			expression = "//item/contenttypeid";
			contenttypeid = (NodeList)xpath.compile(expression).evaluate(document,XPathConstants.NODESET);
			expression = "//item/title";
			title = (NodeList)xpath.compile(expression).evaluate(document,XPathConstants.NODESET);
			
			
			//System.out.println(items.item(idx).getTextContent());
		}
		for(int i=0;i<items.getLength();i++){
			int type = Integer.parseInt(contenttypeid.item(i).getTextContent());
			
			if(type==12){
				bean= new Databean();
				bean.setContentId(contentid.item(i).getTextContent());
				bean.setContentTypeid(contenttypeid.item(i).getTextContent());
				bean.setTitle(title.item(i).getTextContent());
				beanlist.add(bean);
			}
			if(type==32){
				bean= new Databean();
				bean.setContentId(contentid.item(i).getTextContent());
				bean.setContentTypeid(contenttypeid.item(i).getTextContent());
				bean.setTitle(title.item(i).getTextContent());
				beanlist.add(bean);
			}
			if(type==39){
				bean= new Databean();
				bean.setContentId(contentid.item(i).getTextContent());
				bean.setContentTypeid(contenttypeid.item(i).getTextContent());
				bean.setTitle(title.item(i).getTextContent());
				beanlist.add(bean);
			}
			
			
		}
		/*for(Databean b : beanlist){
			System.out.println(b.getContentId());
			System.out.println(b.getContentTypeid());
			System.out.println(b.getTitle());
		}*/
		
		db.DriverTest db = new db.DriverTest();
		con = db.con();
		for(Databean b : beanlist){
			try{
				
				String sql = "insert into tourcode values(?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, b.getContentId());
				pstmt.setString(2, b.getContentTypeid());
				pstmt.setString(3, b.getTitle());
				
				int result =pstmt.executeUpdate();
				if(result>=1){
					System.out.println("데이터 입력 성공");
				}else{
					System.out.println("데이터 입력 실패");
				}
				
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					pstmt.close();		
				}
			
		}
		con.close();
		//Nodelist 가져오기
		
		
	}

}
