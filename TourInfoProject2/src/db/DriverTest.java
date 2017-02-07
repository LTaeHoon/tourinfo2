package db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 준비작업 : Java Build Path에서 라이브러리 등록
 *    - Oracle 드라이버(ojdbc6.jar) 지정 
 */
public class DriverTest {
	private static final String FILE="C:\\NCS\\jdbc.properties";

	public Connection con() throws SQLException, IOException{
		Properties prop = new Properties(); 
		FileInputStream fis = new FileInputStream(FILE);
		prop.load(new BufferedInputStream(fis));
		
		// 속성 단위 처리 
		String driver, url, uid, upwd;

		driver = prop.getProperty("driver"); // driver value 리턴
		url = prop.getProperty("url");
		uid = prop.getProperty("username");
		upwd = prop.getProperty("password");
				
		Connection con = null;
		try {
			//1. 드라이버 로딩
			Class.forName(driver);
			//2. 데이터베이스 연결
			con=DriverManager.getConnection(url,uid,upwd);
			/*
			 * 첫번째 인자 : 연결한 DB URL
			 * 두번째 인자 : DB 사용자
			 * 세번째 인자 : DB 사용자 비번
			 */
			System.out.println("JDBC DRIVER 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC DRIVER 로딩 실패");
			e.printStackTrace();
		}
		
		return con; //DB 연동 객체 반환
		
	}
	/*
	 * 자바에서 오라클 연동에 필요한 요소
	 *   SID : ORCL(데이터베이스이름)
	 *   PORT : 1521
	 *   HOST : 127.0.0.1(개인 고정IP)
	 *   URL : jdbc:oracle:thin:@127.0.0.1:1521:ORCL
	 *   DRIVER : oracle.jdbc.driver.OracleDriver
	 */

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties(); 
		FileInputStream fis = new FileInputStream(FILE);
		prop.load(new BufferedInputStream(fis));
		
		// 속성 단위 처리 
		String driver, url, uid, upwd;

		driver = prop.getProperty("driver"); // driver value 리턴
		url = prop.getProperty("url");
		uid = prop.getProperty("username");
		upwd = prop.getProperty("password");
				
		Connection con = null;
		try {
			//1. 드라이버 로딩
			Class.forName(driver);
			//2. 데이터베이스 연결
			con=DriverManager.getConnection(url,uid,upwd);
			/*
			 * 첫번째 인자 : 연결한 DB URL
			 * 두번째 인자 : DB 사용자
			 * 세번째 인자 : DB 사용자 비번
			 */
			System.out.println("JDBC DRIVER 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC DRIVER 로딩 실패");
			e.printStackTrace();
		}finally{
			con.close(); // 연결 객체 닫기
		}
	}

}




