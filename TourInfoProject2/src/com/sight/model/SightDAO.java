package com.sight.model;

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

import db.DBConnection;

public class SightDAO {
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;	
	private String sql=null;
	
	public SightDAO(){
		try{
			DBConnection db = new DBConnection();
			con = db.con; // 커넥션 가져오기
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public List<SightBean> selectSight(int page, int limit) {
		
		//bean 객체 받을 리스트 객체 선언
		List<SightBean> list = new ArrayList<SightBean>();
		int startrow=(page-1)*10+1; //현재페이지에서 시작행
		int endrow=page*limit;     // 현재페이지에서 끝행
		/*sql ="select * from (select gongji.*, rownum as rnum "
				 + " from (select * from gongji order by gongji_no desc) gongji)" 
				 + " where rnum >=? and rnum<=?"; 
		*/
		sql = "select * from (select commoninfo.*,rownum as rnum"
				+" from (select * from commoninfo where contenttypeid=12 order by contentid desc) commoninfo)"
				+ " where rnum >=? and rnum<=?";
		try{
			pstmt=con.prepareStatement(sql);
		    pstmt.setInt(1,startrow);
		    pstmt.setInt(2,endrow); 
			rs=pstmt.executeQuery();
			while(rs.next()){
				// bean 객체 선언
		 		SightBean bean = new SightBean(); 
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
			sql="select count(*) from commoninfo where contenttypeid=12";
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
	public SightDetailBean selectSightDetail(String contentid){
		
		SightDetailBean bean_d = null;
		
		sql = "select * from sight where contentid = ?";
		
		try{
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, contentid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				bean_d = new SightDetailBean();

				bean_d.setContentid(rs.getString("contentid"));
				bean_d.setContenttypeid(rs.getString("contenttypeid"));
				bean_d.setAccomcount(rs.getString("accomcount"));
				bean_d.setChkbabycarriage(rs.getString("chkbabycarriage"));
				bean_d.setChkcreditcard(rs.getString("chkcreditcard"));
				bean_d.setChkpet(rs.getString("chkpet"));
				bean_d.setExpagerange(rs.getString("expagerange"));
				bean_d.setExpguide(rs.getString("expagerange"));
				bean_d.setInfocenter(rs.getString("infocenter"));
				bean_d.setOpendate(rs.getString("opendate"));
				bean_d.setParking(rs.getString("parking"));
				bean_d.setRestdate(rs.getString("restdate"));
				bean_d.setUseseason(rs.getString("useseason"));
				bean_d.setUsetime(rs.getString("usetime"));
				
			}
			
			rs.close(); pstmt.close(); 
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
		return bean_d;
		
	}
	public SightBean getInfo(String contentid){
		SightBean bean = null;
		 
		sql ="select * from commoninfo where contenttypeid=12 and contentid=?";
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, contentid);
			rs=pstmt.executeQuery();//쿼리문 실행
		
		    while(rs.next()){
		    	bean = new SightBean();
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
