package com.accom.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
}
