package HangDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_BrandMobile {
	private static Connection cn;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_phone", "root", "G1234567");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

	public ArrayList<BrandMobile> loadData() {
		Connection cn = getCon();
		String sql = "select * from tb_company";
		ArrayList<BrandMobile> ls = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BrandMobile st = new BrandMobile();
				st.setID_Company(rs.getString("ID_Company"));
				st.setName(rs.getString("Name"));

				ls.add(st);
			}
			cn.close();
		} catch (SQLException e) {

		}
		return ls;
	}

//	Them
	public boolean insertBrandMobile(String ID_Company, String Name) {
		Connection cn = getCon();
		String sql = "Insert into tb_company (ID_Company, Name) " + "values(?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID_Company);
			ps.setString(2, Name);

			ps.executeUpdate();
			cn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

//	update
	public boolean updateBrandMobile(String ID_Company, String Name) {
		Connection cn = getCon();
		int rs = 0;
		String sql = "update tb_company set Name= ? where ID_Company =?";
		ArrayList<BrandMobile> lsBrandMobile = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, Name);
			ps.setString(2, ID_Company);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return (rs == 1) ? true : false;
	}

// 	DELETE
	public boolean delBrandMobile(String ID_Company) {
		Connection cn = getCon();
		int rs = 0;
		String sql = "delete from tb_company where ID_Company=?";
		ArrayList<BrandMobile> lsBrandMobile = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID_Company);
			rs = ps.executeUpdate();

		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public static void main(String[] args) {
		System.out.print(getCon());
		;
	}
}
