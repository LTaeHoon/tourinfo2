package com.accom.model;

import java.io.IOException;

import java.sql.SQLException;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class XmlParsing_accom {
	 public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, SQLException{
		
		List<AccomDetailBean> com =null;
		
		AccomDetailDAO dao = new AccomDetailDAO();

		List<String> content =null;
		content = dao.select();
		for(String c : content){
			System.out.println(c);
		}
		
		com= dao.AccomXmlParsing(content);
		dao.insert(com);
		 
	 }
}
