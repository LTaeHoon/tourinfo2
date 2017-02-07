package com.accom.model;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

import db.DriverTest;


public class AccomDetailDAO {
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;	
	private String sql=null;
	
	
	public AccomDetailDAO() {
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
			
			sql = "select contentid from tourcode where contenttypeid=32";
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
		
		
		public List<AccomDetailBean> AccomXmlParsing(List<String> accom) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
			
			List<String> urllist = new ArrayList<String>();
			
			NodeList contentid = null; //개별 숙박시설 id
			NodeList contenttypeid = null;//숙박시설 32
			NodeList infocenterlodging = null; //문의 및 안내
			NodeList scaleleports = null; //규모
			NodeList accomcountlodging = null; //수용가능 인원
			NodeList checkintime = null; //체크인 시간
			NodeList checkouttime = null; //체크아웃 시간
			NodeList roomcount = null; //객실 수 
			NodeList parkinglodging = null; //주차시설 여부
			NodeList chkcooking = null;//객실 내 취사 가능 여부
			NodeList pickup = null;//픽업 서비스 가능 여부
			NodeList reservationlodging = null; //예약 안내
			NodeList reservationurl = null; //예약 사이트	
			
			//accomcontent id 값 을 매개변수로 받아오기
			String url=null;
			
			for(String a : accom){
				
					url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?ServiceKey=ALvuC1y5ifztwuiNT2asVPtcyODkqf1zAWWxVBptey2nOhfV4%2Be%2BTOj607RcIUrb7%2BXsoBvT3l0KFGiJUTegOw%3D%3D&"
							+ "contentTypeId=32&"
							+ "contentId="+a
							+ "&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&introYN=Y";				
					
					urllist.add(url);				
			}
			
			List<AccomDetailBean> list = new ArrayList<AccomDetailBean>();
			
			for(String u:urllist){
				// XML Document 객체 생성 
				System.out.println(u);
				Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(u); 
				XPath xpath = XPathFactory.newInstance().newXPath(); 
								
				contentid = (NodeList)xpath.evaluate("//item/contentid", document, XPathConstants.NODESET);
				contenttypeid = (NodeList)xpath.evaluate("//item/contenttypeid", document, XPathConstants.NODESET);
				infocenterlodging = (NodeList)xpath.evaluate("//item/infocenterlodging", document, XPathConstants.NODESET);
				scaleleports = (NodeList)xpath.evaluate("//item/scaleleports", document, XPathConstants.NODESET); 
				accomcountlodging = (NodeList)xpath.evaluate("//item/accomcountlodging", document, XPathConstants.NODESET); 
				checkintime = (NodeList)xpath.evaluate("//item/checkintime", document, XPathConstants.NODESET); 
				checkouttime = (NodeList)xpath.evaluate("//item/checkouttime", document, XPathConstants.NODESET); 
				roomcount = (NodeList)xpath.evaluate("//item/roomcount", document, XPathConstants.NODESET); 
				parkinglodging = (NodeList)xpath.evaluate("//item/parkinglodging", document, XPathConstants.NODESET); 
				chkcooking = (NodeList)xpath.evaluate("//item/chkcooking", document, XPathConstants.NODESET); 
				pickup = (NodeList)xpath.evaluate("//item/pickup", document, XPathConstants.NODESET); 
				reservationlodging = (NodeList)xpath.evaluate("//item/reservationlodging", document, XPathConstants.NODESET); 
				reservationurl = (NodeList)xpath.evaluate("//item/reservationurl", document, XPathConstants.NODESET); 
		 		
		 		AccomDetailBean bean = new AccomDetailBean(); 
		 		
		 		String contId = null;
		 		String contTypeId = null;
		 		String info = null;
		 		String scale = null;
		 		String countlod = null;
		 		String checkin = null;
		 		String checkout = null;
		 		String room = null;
		 		String parking = null;
		 		String cooking = null;
		 		String pick = null;
		 		String reservation = null;
		 		String reservationUrl = null;	 		
		 		
		 		
		 		if (0 < contentid.getLength()) {
		 			contId=contentid.item(0).getTextContent();
		 		} else {
		 			contId = "";
		 		}
		 		if (0 < contenttypeid.getLength()) {
		 			contTypeId=contenttypeid.item(0).getTextContent();
		 		} else {
		 			contTypeId = "";
		 		}		 		
		 		if (0 < infocenterlodging.getLength()) {
		 			info=infocenterlodging.item(0).getTextContent();
		 		} else {
		 			info = "";
		 		}
		 		if (0 < scaleleports.getLength()) {
		 			scale=scaleleports.item(0).getTextContent();
		 			System.out.println(scale);
		 		} else {
		 			scale = "";
		 		}
		 		if (0 < accomcountlodging.getLength()) {
		 			countlod=accomcountlodging.item(0).getTextContent();
		 		} else {
		 			countlod = "";
		 		}
		 		if (0 < checkintime.getLength()) {
		 			checkin=checkintime.item(0).getTextContent();
		 		} else {
		 			checkin = "";
		 		}
		 		if (0 < checkouttime.getLength()) {
		 			checkout=checkouttime.item(0).getTextContent();
		 		} else {
		 			checkout = "";
		 		}
		 		if (0 < roomcount.getLength()) {
		 			room=roomcount.item(0).getTextContent();
		 		} else {
		 			room = "";
		 		}		 		
		 		if (0 < parkinglodging.getLength()) {
		 			parking=parkinglodging.item(0).getTextContent();
		 		} else {
		 			parking = "";
		 		}
		 		if (0 < chkcooking.getLength()) {
		 			cooking=chkcooking.item(0).getTextContent();
		 		} else {
		 			cooking = "";
		 		}
		 		if (0 < pickup.getLength()) {
		 			pick=pickup.item(0).getTextContent();
		 		} else {
		 			pick = "";
		 		}
		 		if (0 < reservationlodging.getLength()) {
		 			reservation=reservationlodging.item(0).getTextContent();
		 		} else {
		 			reservation = "";
		 		}
		 		if (0 < reservationurl.getLength()) {
		 			reservationUrl=reservationurl.item(0).getTextContent();
		 		} else {
		 			reservationUrl = "";
		 		}

		 		bean.setContentid(contId);
		 		bean.setContenttypeid(contTypeId);
		 		bean.setInfocenterlodging(info);		
		 		bean.setScaleleports(scale);
		 		bean.setAccomcountlodging(countlod);
		 		bean.setCheckintime(checkin);
		 		bean.setCheckouttime(checkout);
		 		bean.setRoomcount(room);
		 		bean.setParkinglodging(parking);
		 		bean.setChkcooking(cooking);
		 		bean.setPickup(pick);
		 		bean.setReservationlodging(reservation);
		 		bean.setReservationurl(reservationUrl);
		 
		 		list.add(bean); 
			}
			for(AccomDetailBean li : list ){
				System.out.println(li.getContentid());
				System.out.println(li.getContenttypeid());
	 			System.out.println(li.getInfocenterlodging());
	 			System.out.println(li.getScaleleports());
	 			System.out.println(li.getAccomcountlodging());
	 			System.out.println(li.getCheckintime());
	 			System.out.println(li.getCheckouttime());
	 			System.out.println(li.getRoomcount());
	 			System.out.println(li.getParkinglodging());
	 			System.out.println(li.getChkcooking());
	 			System.out.println(li.getPickup());
	 			System.out.println(li.getReservationlodging());
	 			System.out.println(li.getReservationurl());
	 		}
	 		// Xpath 생성 
	 		return list;	 		
		}
		
		
		public void insert(List<AccomDetailBean> com) throws SQLException{
			
			
			for(AccomDetailBean bean : com){
				try{
				sql ="insert into accom_detail values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, bean.getContentid());
				pstmt.setString(2, bean.getContenttypeid());
				pstmt.setString(3, bean.getInfocenterlodging());
				pstmt.setString(4, bean.getScaleleports());
				pstmt.setString(5, bean.getAccomcountlodging());
				pstmt.setString(6, bean.getCheckintime());
				pstmt.setString(7, bean.getCheckouttime());
				pstmt.setString(8, bean.getRoomcount());
				pstmt.setString(9, bean.getParkinglodging());
				pstmt.setString(10, bean.getChkcooking());
				pstmt.setString(11, bean.getPickup());
				pstmt.setString(12, bean.getReservationlodging());
				pstmt.setString(13, bean.getReservationurl());
				
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
	
	
	
	

}
