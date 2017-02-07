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
	public List<AccomBean> selectAccom() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		//bean 객체 받을 리스트 객체 선언
		List<AccomBean> list = new ArrayList<AccomBean>();
		
		sql = "select * from commoninfo where contenttypeid=32";
		try{
			pstmt=con.prepareStatement(sql);
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
		}catch(Exception e){
			e.printStackTrace();
		}	
 		return list;
 		
	}
	
}
