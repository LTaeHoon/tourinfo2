package com.accom.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.food.model.FoodBean;

import db.DBConnection;

public class AccomDAO {
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;	
	private String sql=null;
	
	public AccomDAO(){
		try{
			DBConnection db = new DBConnection();
			con = db.con; // 커넥션 가져오기
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	//숙박 contentid 리스트 반환하는 함수
	public List<Integer> select(){
		List<Integer> content = new ArrayList<Integer>();
		
		sql = "select contentid from tourinfo where contenttypeid=39";
		try{
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				content.add(rs.getInt(1));	
			}
			rs.close();pstmt.close();con.close();
		}catch(Exception  e){
			e.printStackTrace();
		}
		return content;
	}
	
	
	public List<AccomBean> AccomXmlParsing() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		List<AccomBean> list = new ArrayList<AccomBean>();
		
 		String url = "http://api.visitkorea.or.kr/openapi/"
 				+ "service/rest/KorService/detailCommon?"
 				+ "ServiceKey=EeBjN2xdCzzcqHvefO0rZXaycAim0uGpKxnOX72PY1UpkSZnifzIK1kxLm61XXaQ4pFxhbW%2F%2FZbmQDKFiAFNVA%3D%3D&"
 				+ "contentId=143036&"
 				+ "defaultYN=Y&"
 				+ "addrinfoYN=Y&"
 				+ "firstImageYN=Y&"
 				+ "overviewYN=Y&"
 				+ "MobileOS=ETC&MobileApp=AppTesting"; 
 		
 		// XML Document 객체 생성 
 		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url); 
		 
 		// Xpath 생성 
 		XPath xpath = XPathFactory.newInstance().newXPath(); 
 		
 		NodeList item = (NodeList)xpath.evaluate("//item", document, XPathConstants.NODESET); 
 		NodeList addr1 = (NodeList)xpath.evaluate("//item/addr1", document, XPathConstants.NODESET); 
 		NodeList contentid = (NodeList)xpath.evaluate("//item/contentid", document, XPathConstants.NODESET);
 		NodeList contenttypeid = (NodeList)xpath.evaluate("//item/contenttypeid", document, XPathConstants.NODESET);
 		NodeList firstimage = (NodeList)xpath.evaluate("//item/firstimage", document, XPathConstants.NODESET); 
 		NodeList overview = (NodeList)xpath.evaluate("//item/overview", document, XPathConstants.NODESET); 
 		NodeList title = (NodeList)xpath.evaluate("//item/title", document, XPathConstants.NODESET); 
		
 		AccomBean bean = new AccomBean(); 
 		
 		bean.setAddr1(addr1.item(0).getTextContent()); 
 		bean.setContentid(Integer.parseInt(contentid.item(0).getTextContent()));
 		bean.setContenttypeid(Integer.parseInt(contenttypeid.item(0).getTextContent()));
 		bean.setFirstimage(firstimage.item(0).getTextContent()); 
 		bean.setOverview(overview.item(0).getTextContent());
 		bean.setTitle(title.item(0).getTextContent());
 		
 		list.add(bean); 
 		
 		return list;
 		
	}
	
}
