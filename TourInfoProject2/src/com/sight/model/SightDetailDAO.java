package com.sight.model;

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

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import db.DriverTest;

public class SightDetailDAO {
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;	
	private String sql=null;
	
	
	public SightDetailDAO(){
		
		try{
			DriverTest db = new DriverTest();
			
			con = db.con(); // 커넥션 가져오기
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	} // 생성자 end
	
	
	// 관광지 contentid 리스트 반환하는 함수
	public List<String> select(){
		
		List<String> content = new ArrayList<String>();
		
		sql = "select contentid from tourcode where contenttypeid=12";
		
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
		
	} // select() 메서드 end
	
	
	
	public List<SightDetailBean> sightparsing(List<String> content) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		
		List<SightDetailBean> list = null;
		
		List<String> urlList = new ArrayList<String>();
		
		NodeList contentid = null;
		NodeList contenttypeid = null;
		NodeList accomcount = null;
		NodeList chkbabycarriage = null;
		NodeList chkcreditcard = null;
		NodeList chkpet = null;
		NodeList expagerange = null;
		NodeList expguide = null;
		NodeList infocenter = null;
		NodeList opendate = null;
		NodeList parking = null;
		NodeList restdate = null;
		NodeList useseason = null;
		NodeList usetime = null;
		
		
		// sight contentid 값을 매개변수로 받아오기
		String url = null;
		
		for(String c : content){
			
			url = "http://api.visitkorea.or.kr/openapi/"
					+ "service/rest/KorService/detailIntro?"
					+ "ServiceKey=p5hlXxc2jROVa9FqW1%2FnIw6G%2FR6naUbs3srbdrv0nI43AdCqVIZ%2FV%2BIPmugmi7rVf5ZaQoWhDXVaHR4Im%2FUoPg%3D%3D&&"
					+ "contentId=" + c + "&"
					+ "contentTypeId=12&"
					+ "MobileOS=ETC&MobileApp=AppTesting";
			
			urlList.add(url);
			
		}
		
		
		list = new ArrayList<SightDetailBean>();
		
		for(String u : urlList){
			
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(u); 
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			
			contentid = (NodeList)xpath.evaluate("//item/contentid", document, XPathConstants.NODESET);
			contenttypeid = (NodeList)xpath.evaluate("//item/contenttypeid", document, XPathConstants.NODESET);
			accomcount = (NodeList)xpath.evaluate("//item/accomcount", document, XPathConstants.NODESET);
			chkbabycarriage = (NodeList)xpath.evaluate("//item/chkbabycarriage", document, XPathConstants.NODESET);
			chkcreditcard = (NodeList)xpath.evaluate("//item/chkcreditcard", document, XPathConstants.NODESET);
			chkpet = (NodeList)xpath.evaluate("//item/chkpet", document, XPathConstants.NODESET);
			expagerange = (NodeList)xpath.evaluate("//item/expagerange", document, XPathConstants.NODESET);
			expguide = (NodeList)xpath.evaluate("//item/expguide", document, XPathConstants.NODESET);
			infocenter = (NodeList)xpath.evaluate("//item/infocenter", document, XPathConstants.NODESET);
			opendate = (NodeList)xpath.evaluate("//item/opendate", document, XPathConstants.NODESET);
			parking = (NodeList)xpath.evaluate("//item/parking", document, XPathConstants.NODESET);
			restdate = (NodeList)xpath.evaluate("//item/restdate", document, XPathConstants.NODESET);
			useseason = (NodeList)xpath.evaluate("//item/useseason", document, XPathConstants.NODESET);
			usetime = (NodeList)xpath.evaluate("//item/usetime", document, XPathConstants.NODESET);
			
			
			SightDetailBean bean = new SightDetailBean();
			
			String contentid2 = null;
			String contenttypeid2 = null;
			String accomcount2 = null;
			String chkbabycarriage2 = null;
			String chkcreditcard2 = null;
			String chkpet2 = null;
			String expagerange2 = null;
			String expguide2 = null;
			String infocenter2 = null;
			String opendate2 = null;
			String parking2 = null;
			String restdate2 = null;
			String useseason2 = null;
			String usetime2 = null;
			
			
			if (0 < contentid.getLength()){
				
				contentid2 = contentid.item(0).getTextContent();
				
			}else{
				
				contentid2 = "";
				
			}
			
			if (0 < contenttypeid.getLength()){
				
				contenttypeid2 = contenttypeid.item(0).getTextContent();
				
			}else{
				
				contenttypeid2 = "";
				
			}
			
			if (0 < accomcount.getLength()){
				
				accomcount2 = accomcount.item(0).getTextContent();
				
			}else{
				
				accomcount2 = "";
				
			}
			
			if (0 < chkbabycarriage.getLength()){
				
				chkbabycarriage2 = chkbabycarriage.item(0).getTextContent();
				
			}else{
				
				chkbabycarriage2 = "";
				
			}
			
			if (0 < chkcreditcard.getLength()){
				
				chkcreditcard2 = chkcreditcard.item(0).getTextContent();
				
			}else{
				
				chkcreditcard2 = "";
				
			}
			
			if (0 < chkpet.getLength()){
				
				chkpet2 = chkpet.item(0).getTextContent();
				
			}else{
				
				chkpet2 = "";
				
			}
			
			if (0 < expagerange.getLength()){
				
				expagerange2 = expagerange.item(0).getTextContent();
				
			}else{
				
				expagerange2 = "";
				
			}
			
			if (0 < expguide.getLength()){
				
				expguide2 = expguide.item(0).getTextContent();
				
			}else{
				
				expguide2 = "";
				
			}
			
			if (0 < infocenter.getLength()){
				
				infocenter2 = infocenter.item(0).getTextContent();
				
			}else{
				
				infocenter2 = "";
				
			}
			
			if (0 < opendate.getLength()){
				
				opendate2 = opendate.item(0).getTextContent();
				
			}else{
				
				opendate2 = "";
				
			}
			
			if (0 < parking.getLength()){
				
				parking2 = parking.item(0).getTextContent();
				
			}else{
				
				parking2 = "";
				
			}
			
			if (0 < restdate.getLength()){
				
				restdate2 = restdate.item(0).getTextContent();
				
			}else{
				
				restdate2 = "";
				
			}
			
			if (0 < useseason.getLength()){
				
				useseason2 = useseason.item(0).getTextContent();
				
			}else{
				
				useseason2 = "";
				
			}
			
			if (0 < usetime.getLength()){
				
				usetime2 = usetime.item(0).getTextContent();
				
			}else{
				
				usetime2 = "";
				
			}
			
			
			bean.setContentid(contentid2);
			bean.setContenttypeid(contenttypeid2);
			bean.setAccomcount(accomcount2);
			bean.setChkbabycarriage(chkbabycarriage2);
			bean.setChkcreditcard(chkcreditcard2);
			bean.setChkpet(chkpet2);
			bean.setExpagerange(expagerange2);
			bean.setExpguide(expguide2);
			bean.setInfocenter(infocenter2);
			bean.setOpendate(opendate2);
			bean.setParking(parking2);
			bean.setRestdate(restdate2);
			bean.setUseseason(useseason2);
			bean.setUsetime(usetime2);
			
			list.add(bean);

		}
		
		return list;
		
		
	} // sightparsing 메서드 end
	
	
	public void insert(List<SightDetailBean> list) throws SQLException{
		
		for (SightDetailBean l : list){
			
			try{
				
				sql = "insert into sight values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, l.getContentid());
				pstmt.setString(2, l.getContenttypeid());
				pstmt.setString(3, l.getAccomcount());
				pstmt.setString(4, l.getChkbabycarriage());
				pstmt.setString(5, l.getChkcreditcard());
				pstmt.setString(6, l.getChkpet());
				pstmt.setString(7, l.getExpagerange());
				pstmt.setString(8, l.getExpguide());
				pstmt.setString(9, l.getInfocenter());
				pstmt.setString(10, l.getOpendate());
				pstmt.setString(11, l.getParking());
				pstmt.setString(12, l.getRestdate());
				pstmt.setString(13, l.getUseseason());
				pstmt.setString(14, l.getUsetime());
				
				int re = pstmt.executeUpdate();
				
				if (re >= 0){
					
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

}  // class SightDetailDAO end
