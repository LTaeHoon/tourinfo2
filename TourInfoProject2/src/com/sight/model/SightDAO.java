package com.sight.model;

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

public class SightDAO {
	
	public List<SightBean> SightXmlParsing() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		List<SightBean> list = new ArrayList<SightBean>();
		
 		String url = "http://api.visitkorea.or.kr/openapi/"
 				+ "service/rest/KorService/detailCommon?"
 				+ "ServiceKey=EeBjN2xdCzzcqHvefO0rZXaycAim0uGpKxnOX72PY1UpkSZnifzIK1kxLm61XXaQ4pFxhbW%2F%2FZbmQDKFiAFNVA%3D%3D&"
 				+ "contentId=126508&"
 				+ "defaultYN=Y&"
 				+ "addrinfoYN=Y&"
 				+ "firstImageYN=Y&"
 				+ "overviewYN=Y&"
 				+ "MobileOS=ETC&MobileApp=AppTesting"; 
 		
 		// XML Document 객체 생성 
 		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url); 
		 
 		// Xpath 생성 
 		XPath xpath = XPathFactory.newInstance().newXPath(); 
 		
 		NodeList item = (NodeList)xpath.evaluate("//item", document, XPathConstants.NODESET); 
 		NodeList addr1 = (NodeList)xpath.evaluate("//item/addr1", document, XPathConstants.NODESET); 
 		NodeList contentid = (NodeList)xpath.evaluate("//item/contentid", document, XPathConstants.NODESET);
 		NodeList contenttypeid = (NodeList)xpath.evaluate("//item/contenttypeid", document, XPathConstants.NODESET);
 		NodeList firstimage = (NodeList)xpath.evaluate("//item/firstimage", document, XPathConstants.NODESET); 
 		NodeList overview = (NodeList)xpath.evaluate("//item/overview", document, XPathConstants.NODESET); 
 		NodeList title = (NodeList)xpath.evaluate("//item/title", document, XPathConstants.NODESET); 
		
 		SightBean bean = new SightBean(); 
 		
 		bean.setAddr1(addr1.item(0).getTextContent()); 
 		bean.setContentid(contentid.item(0).getTextContent());
 		bean.setContenttypeid(contenttypeid.item(0).getTextContent());
 		bean.setFirstimage(firstimage.item(0).getTextContent()); 
 		bean.setOverview(overview.item(0).getTextContent());
 		bean.setTitle(title.item(0).getTextContent());
 		
 		list.add(bean); 
 		
 		return list;
 		
	}

}
