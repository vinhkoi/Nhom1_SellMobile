package Hoadon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Bill {
	public static Connection cn = null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_phone", "root", "G1234567");
		} catch (ClassNotFoundException | SQLException e) {
		}
		return cn;
	}

	public ArrayList<Bill> getListBill() {
		Connection cn = getCon();
		String sql = "select * from tb_bill";
		ArrayList<Bill> lists = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bill b = new Bill();
				b.setMaHD(rs.getString("MaHD"));
				b.setTenKH(rs.getString("TenKH"));
				b.setNhanvien(rs.getString("Nguoiban"));
				b.setNgayban(rs.getString("Ngayban"));
				lists.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lists;
	}

	public ArrayList<Bill> getBill_byMaHD(String MaHD) {
		Connection cn = getCon();
		String sql = "SELECT * FROM tb_bill WHERE MaHD = ?";
		ArrayList<Bill> lists = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaHD);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bill b = new Bill();
				b.setMaHD(rs.getString("MaHD"));
				b.setTenKH(rs.getString("TenKH"));
				b.setNhanvien(rs.getString("Nguoiban"));
				b.setNgayban(rs.getString("Ngayban"));
				lists.add(b);

			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	public ArrayList<Bill> getBillInfo_byMaHD(String MaHD) {
		Connection cn = getCon();
		String sql = "SELECT * FROM tb_bill_info WHERE MaHD = ?";
		ArrayList<Bill> lists = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaHD);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bill b = new Bill();
				b.setMaHD(rs.getString("MaHD"));
				b.setTenSP(rs.getString("TenSP"));
				b.setSoluong(rs.getInt("Soluong"));
				b.setGiaban(rs.getDouble("Giaban"));
				b.setThanhtien(rs.getDouble("Thanhtien"));
				lists.add(b);
			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	public boolean insertBill(String MaHD, String TenKH, String Nguoiban, String Ngayban) {
		Connection con = getCon();
		int rs = 0;
		String sql = "INSERT INTO tb_bill VALUE(?,?,?,?)";
		ArrayList<Bill> lst = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, MaHD);
			ps.setString(2, TenKH);
			ps.setString(3, Nguoiban);
			ps.setString(4, Ngayban);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public boolean insertBillInfo(String mahd, String tensp, int soluong, Double giaban, Double thanhtien) {
		Connection con = getCon();
		int rs = 0;
		String sql = "INSERT INTO tb_bill_info VALUE(?,?,?,?,?)";
		ArrayList<Bill> lst = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, mahd);
			ps.setString(2, tensp);
			ps.setInt(3, soluong);
			ps.setDouble(4, giaban);
			ps.setDouble(5, thanhtien);

			rs = ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public boolean updateBill(String MaHD, String TenKH, String Nguoiban, String Ngayban) {
		Connection con = getCon();
		int rs = 0;
		String sql = "Update tb_bill set TenKH=?, Nguoiban=?, Ngayban=? WHERE MaHD=?";
		ArrayList<Bill> lst = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, TenKH);
			ps.setString(2, Nguoiban);
			ps.setString(3, Ngayban);
			ps.setString(4, MaHD);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public boolean updateBillInfo(String MaHD, String TenSP, int Soluong, Double Giaban, Double Thanhtien, String Ma) {
		Connection con = getCon();
		int rs = 0;
		String sql = "Update tb_bill_info set TenSP=?, Soluong=?, Giaban=?, Thanhtien=? WHERE MaHD=? AND TenSP=?";
		ArrayList<Bill> lst = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, TenSP);
			ps.setInt(2, Soluong);
			ps.setDouble(3, Giaban);
			ps.setDouble(4, Thanhtien);
			ps.setString(5, MaHD);
			ps.setString(6, Ma);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public boolean delBill(String MaHD) {
		Connection con = getCon();
		int rs = 0;
		String sql = "delete from tb_bill where MaHD=?";
		ArrayList<Bill> lsst = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, MaHD);
			rs = ps.executeUpdate();

		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public boolean delBillInfo(String MaHD, String SP) {
		Connection con = getCon();
		int rs = 0;
		String sql = "delete from tb_bill_info where MaHD=? AND TenSP=?";
		ArrayList<Bill> lsst = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, MaHD);
			ps.setString(2, SP);
			rs = ps.executeUpdate();

		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	
	
	public static void main(String[] args) {
		System.out.print(getCon());
	}

}
