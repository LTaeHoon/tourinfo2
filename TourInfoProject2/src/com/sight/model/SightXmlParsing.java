package com.sight.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;



public class SightXmlParsing {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, SQLException {
		// TODO Auto-generated method stub

		
		List<SightDetailBean> list = null;
		
		SightDetailDAO dao = new SightDetailDAO();
		
		List<String> content = null;
		
		content = dao.select();
		
		for (String c : content){
			
			System.out.println(c);
			
		}
		
		list = dao.sightparsing(content);
		
		dao.insert(list);


	} // main method end

} // class SightXmlParsing end
