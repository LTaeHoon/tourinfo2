package com.main.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class XmlParsing_comm {
	 public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, SQLException{
		Connection con = null;
		List<Commonbean> com =null;
		
		CommonDAO dao = new CommonDAO();

		List<String> content =null;
		content = dao.select();
		for(String c : content){
			System.out.println(c);
		}
		//commonbean list가 넘어옴
		com= dao.commonparsing(content);
		dao.insert(com);
		
		
		 
	 }
}
