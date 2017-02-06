package com.food.model;

import java.io.IOException;
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

public class FoodDAO {
	
	public List<FoodBean> FoodXmlParsing() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		List<FoodBean> list = new ArrayList<FoodBean>();
		
 		String url = "http://api.visitkorea.or.kr/openapi/" 
 				+"service/rest/KorService/detailCommon?" 
				+"ServiceKey=EeBjN2xdCzzcqHvefO0rZXaycAim0uGpKxnOX72PY1UpkSZnifzIK1kxLm61XXaQ4pFxhbW%2F%2FZbmQDKFiAFNVA%3D%3D" 
				+"&contentId=134546" 
 				+"&defaultYN=Y" 
 				+"&addrinfoYN=Y" 
				+"&firstImageYN=Y" 
 				+"&overviewYN=Y" 
 				+"&MobileOS=ETC&MobileApp=AppTesting"; 
 		
 		// XML Document 객체 생성 
 		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url); 
		 
 		// Xpath 생성 
 		XPath xpath = XPathFactory.newInstance().newXPath(); 
 		
 		NodeList item = (NodeList)xpath.evaluate("//item", document, XPathConstants.NODESET); 
 		NodeList addr1 = (NodeList)xpath.evaluate("//item/addr1", document, XPathConstants.NODESET); 
 		NodeList contentid = (NodeList)xpath.evaluate("//item/contentid", document, XPathConstants.NODESET); 
 		NodeList firstimage = (NodeList)xpath.evaluate("//item/firstimage", document, XPathConstants.NODESET); 
 		NodeList overview = (NodeList)xpath.evaluate("//item/overview", document, XPathConstants.NODESET); 
 		NodeList title = (NodeList)xpath.evaluate("//item/title", document, XPathConstants.NODESET); 
		
 		FoodBean bean = new FoodBean(); 
 		
 		bean.setAddr1(addr1.item(0).getTextContent()); 
 		bean.setContentid(contentid.item(0).getTextContent()); 
 		bean.setFirstimage(firstimage.item(0).getTextContent()); 
 		bean.setOverview(overview.item(0).getTextContent());
 		bean.setTitle(title.item(0).getTextContent());
 		
 		list.add(bean); 
 		
 		return list;
 		
	}

}
