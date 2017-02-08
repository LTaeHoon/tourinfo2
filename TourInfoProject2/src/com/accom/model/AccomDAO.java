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
	public List<AccomBean> selectAccom(int page,int limit){
		
		//bean 객체 받을 리스트 객체 선언
		List<AccomBean> list = new ArrayList<AccomBean>();
		int startrow=(page-1)*10+1; //현재페이지에서 시작행
		int endrow=page*limit;     // 현재페이지에서 끝행
		sql = "select * from (select commoninfo.*,rownum as rnum"
				+" from (select * from commoninfo where contenttypeid=32 order by contentid desc) commoninfo)"
				+ " where rnum >=? and rnum<=?";
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startrow);
		    pstmt.setInt(2,endrow);
			rs=pstmt.executeQuery();
			while(rs.next()){
				// bean 객체 선언
				AccomBean bean = new AccomBean(); 
				bean.setContentid(rs.getString(1));
				bean.setContenttypeid(rs.getString(2));
				bean.setAddr1(rs.getString(3));
				bean.setFirstimage(rs.getString(4));
				
				bean.setOverview(rs.getString(5));
				bean.setTitle(rs.getString(6));
				bean.setHompage(rs.getString(7));
				bean.setTel(rs.getString(8));
				bean.setZipcode(rs.getString(9));
				list.add(bean);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
 		return list;
 		
	}
	public int getListCount(){
		int count=0;
		try{
			sql="select count(*) from commoninfo where contenttypeid=32";
			pstmt= con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public AccomDetailBean getDetailInfo(String contentid){		
		AccomDetailBean bean_d = null;
		
		sql ="select * from accom_detail where contentid=?";
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, contentid);
			rs=pstmt.executeQuery();//쿼리문 실행
			
		    while(rs.next()){
		    	bean_d = new AccomDetailBean();
		    	bean_d.setContentid(rs.getString("contentid"));
		    	bean_d.setContenttypeid(rs.getString("contenttypeid"));
		    	bean_d.setInfocenterlodging(rs.getString("infocenterlodging"));
		    	bean_d.setScaleleports(rs.getString("scaleleports"));
		    	bean_d.setAccomcountlodging(rs.getString("accomcountlodging"));
		    	bean_d.setCheckintime(rs.getString("checkintime"));
		    	bean_d.setCheckouttime(rs.getString("checkouttime"));
		    	bean_d.setRoomcount(rs.getString("roomcount"));
		    	bean_d.setParkinglodging(rs.getString("parkinglodging"));
		    	bean_d.setChkcooking(rs.getString("chkcooking"));
		    	bean_d.setPickup(rs.getString("pickup"));
		    	bean_d.setReservationlodging(rs.getString("reservationlodging"));
		    	bean_d.setReservationurl(rs.getString("reservationurl"));			
		    	
		    	
		    }
		    
		    rs.close(); pstmt.close(); 
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean_d;			
	}
	
	
	//기본정보 가져오기
	public AccomBean getInfo(String contentid){
		AccomBean bean = null;
		 
		sql ="select * from commoninfo where contenttypeid=32 and contentid=?";
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, contentid);
			rs=pstmt.executeQuery();//쿼리문 실행
		
		    while(rs.next()){
		    	bean = new AccomBean();
		    	bean.setAddr1(rs.getString("addr1"));
		    	bean.setFirstimage(rs.getString("firstimage"));
		    	bean.setOverview(rs.getString("overview"));
		    	bean.setTitle(rs.getString("title"));
		    	bean.setHompage(rs.getString("homepage"));
		    	bean.setZipcode(rs.getString("zipcode"));
		    	bean.setTel(rs.getString("telno"));		    	
		    }
		    
		    rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}
}
