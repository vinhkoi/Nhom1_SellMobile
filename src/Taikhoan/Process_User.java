package Taikhoan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_User {
	
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/db_phone", "root", "G1234567");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		return con;
	}
	public static ArrayList<User> GetListUser(){
		Connection con = getCon();
		String sql = "select * from tb_user";
		ArrayList<User> ListUser = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User us = new User();
				us.setID(rs.getString("ID"));
				us.setUserName(rs.getString("UserName"));
				us.setPassword(rs.getString("PassWord"));
				ListUser.add(us);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ListUser;
	}
	public static Boolean InsertUser(String ID,String UserName,String Password) {
		Connection con = getCon();
		int rs =0;
		String sql = "Insert into tb_user(ID,UserName,PassWord)"+"values(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, UserName);
			ps.setString(3, Password);
			rs = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			return false;
		} 	
		return (rs == 1) ? true : false;
	}
	public static boolean Delete(String UserName) {
		Connection con = getCon();
		int rs=0;
		String sql = "delete from tb_user where UserName=?";
		ArrayList<User> lssUser = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, UserName);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return(rs==1)? true:false;
	}
	public boolean updateUser(String ID,String UserName,String PassWord) {
		Connection con = getCon();
		int rs = 0;
		String sql = "Update tb_user set UserName=?, PassWord=? where ID=?";
		ArrayList<User> lssUser = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, UserName);
			ps.setString(2, PassWord);
			ps.setString(3, ID);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return (rs == 1) ? true:false;
	}
	public static void main(String[] args) {
		System.out.println(getCon());
		System.out.println(GetListUser());

		
	}

}
