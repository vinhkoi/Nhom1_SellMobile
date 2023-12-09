package Dienthoai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Phone {
	public static Connection cn = null;
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_phone", "root", "G1234567");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	public static ArrayList<List_Phone> getListPhone (){
		Connection con = getCon();
		String sql = "select * from tb_phone";
		ArrayList<List_Phone> lss = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				List_Phone ph = new List_Phone();
				ph.setID_Phone(rs.getString("ID_Phone"));
				ph.setName(rs.getString("Name"));
				ph.setPrice(rs.getDouble("Price"));
				ph.setAmount(rs.getDouble("Amount"));
				ph.setColor(rs.getString("Color"));
				lss.add(ph);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lss;
	}
	
	public static boolean insertPhone(String ID, String name,double price, double amount,  String color, String company) {
		Connection cn = getCon();
		int rs = 0;
		String sql = "insert into tb_phone (ID_Phone,Name,Price,Amount,Color,Company) values(?,?,?,?,?,?)";
		ArrayList<List_Phone> lsPhone = new ArrayList<>();
			try {
				PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
				ps.setString(1, ID);
				ps.setString(2, name);
				ps.setDouble(3, price);
				ps.setDouble(4, amount);
				ps.setString(5, color);
				ps.setString(6, company);
				rs = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
		return (rs==1) ? true : false;
	}
	
	public ArrayList<List_Phone> getPhone_byIDCompany (String company){
		Connection cn = getCon();
		String sql = "select * from tb_phone where Company=?";
		ArrayList<List_Phone> lsphone = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, company);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {			
				List_Phone ph = new List_Phone();
				ph.setID_Phone(rs.getString("ID_Phone"));
				ph.setName(rs.getString("Name"));
				ph.setPrice(rs.getDouble("Price"));
				ph.setAmount(rs.getDouble("Amount"));
				ph.setColor(rs.getString("Color"));
				lsphone.add(ph);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsphone;
	}
	public static boolean updatePhone(String ID, String name,double price, double amount,  String color, String company) {
		Connection con = getCon();
		int rs = 0;
		String sql = "update tb_phone set Name=?, Price=?, Amount=?, Color=?, Company=? where ID_Phone=?";
		ArrayList<List_Phone> lsphone = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(6, ID);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setDouble(3, amount);
			ps.setString(4, color);
			ps.setString(5, company);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}
	
	public boolean delPhone(String ID) {
		Connection con = getCon();
		int rs=0;
		String sql = "delete from tb_phone where ID_Phone=?";
		ArrayList<List_Phone> lssphone = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, ID);
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rs==1) ? true : false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(getCon());
	}

}
