package JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBhelper {
 
	private static String url = "jdbc:mysql://localhost:3306/usermessage";
	private static String username = "root";
	private static String password = "";
	private String sql ="";
	private static String sql02 ="insert into usermessage values(?,?,?,?)" ;
	//"delete from tb_books where id = 53";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	public static Connection getConnection() throws Exception{
		if(conn == null){
			conn = DriverManager.getConnection(url , username , password ) ;
			return conn;
		}
		return conn;	
	}
	
	public static void main(String[] args) {
		
		try {
			Connection conn = DBhelper.getConnection();
			if(conn != null){
				System.out.print("数据库连接成功！");
				/*boolean rs01 = true;
				PreparedStatement stmt01 = null;
				stmt01 = conn.prepareStatement(sql02);
				stmt01.setString(1,"3");
				stmt01.setString(2,"3");
				stmt01.setString(3,"3");
				stmt01.setInt(4,3);
				rs01 = stmt01.execute();*/
			}else{
			System.out.print("数据库连接失败！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

