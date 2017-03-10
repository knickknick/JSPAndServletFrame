package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.User;
import JDBC.DBhelper;;

public class ItemsDAO {
	
	
	
	public boolean testRegister(String u,String pa,String e,String ph){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>(); // �û�����
		
		try {
			conn = DBhelper.getConnection();
			String sql01 ="select * from usermessage" ;
			String sql02 ="insert into usermessage values(?,?,?,?)" ;
			stmt = conn.prepareStatement(sql01);
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user1 = new User();
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setEmail(rs.getString("email"));
				user1.setPhonenumber(rs.getInt("phonenumber"));
				list.add(user1.getUsername());// ��������ע����û����뼯��
			}
			if(list.contains(u)){
System.out.println("ִ�е��ǵ�һ��");
			return false;
			}else{
				boolean rs02 = true;
				PreparedStatement stmt02 = null;
				stmt02 = conn.prepareStatement(sql02);
				stmt02.setString(1,u);
				stmt02.setString(2,pa);
				stmt02.setString(3,e);
				stmt02.setInt(4,Integer.parseInt(ph));
				rs02 = stmt02.execute();
System.out.println("ִ�е��ǵ�����");
				return true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
System.out.println("ִ�е��ǵ�����");
			return false;
		}finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}
	
	public boolean testLogin(String username,String password){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map map = new HashMap(); // �û�����
		
		
		try {
			conn = DBhelper.getConnection();
			String sql ="select * from usermessage" ;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user1 = new User();
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setEmail(rs.getString("email"));
				user1.setPhonenumber(rs.getInt("phonenumber"));
				map.put(user1.getUsername(),user1.getPassword());// ��������ע����û����뼯��
			}
			//�ж��û������������Ƿ���ȷ
			if(map.containsKey(username)){
				if(map.get(username).equals(password)){
				return true;	
				}else{
				return false;
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}
}
