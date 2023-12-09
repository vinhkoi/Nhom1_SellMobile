package NhanVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_NV {
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

	public ArrayList<NhanVien> LoadData() {
		Connection cn = getCon();
		String sql = "select * from tb_staff";
		ArrayList<NhanVien> lssstaff = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien ct = new NhanVien();
				ct.setManv(rs.getString("Ma_NV"));
				ct.setHoten(rs.getString("Ho_Ten_NV"));
				ct.setDiachi(rs.getString("DiaChi"));
				ct.setLuong(rs.getDouble("Luong"));
				ct.setSdt(rs.getString("SDT"));
				lssstaff.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lssstaff;
	}

	// search
	public ArrayList<NhanVien> getStaff_byID(String manv) {
		Connection cn = getCon();
		String sql = "select * from tb_staff where Ma_NV = ? ";
		ArrayList<NhanVien> lsStaffDep = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, manv);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien ct = new NhanVien();
				ct.setManv(rs.getString("Ma_NV"));
				ct.setHoten(rs.getString("Ho_Ten_NV"));
				ct.setDiachi(rs.getString("DiaChi"));
				ct.setLuong(rs.getDouble("Luong"));
				ct.setSdt(rs.getString("SDT"));

				lsStaffDep.add(ct);
			}
		}

		catch (SQLException e) {
			// TODO: handle exception
		}
		return lsStaffDep;

	}

	// Insert
	public boolean insertStaff(String manv, String hoten, String diachi, double luong, String sdt) {
		Connection cn = getCon();
		String sql = "Insert into tb_staff (Ma_NV, Ho_Ten_NV, DiaChi, Luong, SDT) " + "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, manv);
			ps.setString(2, hoten);
			ps.setString(3, diachi);
			ps.setDouble(4, luong);
			ps.setString(5, sdt);

			ps.executeUpdate();
			cn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// Update
	public boolean updateStaff(String manv, String hoten, String diachi, String sdt, double luong) {
		Connection cn = getCon();
		int rs = 0;
		String sql = "update tb_staff set Ho_Ten_NV= ?, DiaChi=?, Luong=?, SDT = ? where Ma_NV =?";
		ArrayList<NhanVien> lsStaff = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);

			ps.setString(1, hoten);
			ps.setString(2, diachi);
			ps.setDouble(3, luong);
			ps.setString(4, sdt);
			ps.setString(5, manv);

			rs = ps.executeUpdate();
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return (rs == 1) ? true : false;
	}

	// Delete
	public boolean delStaff(String id) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		int rs = 0;
		String sql = "delete from tb_staff where Ma_NV=?";
		ArrayList<NhanVien> lssStaff = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeUpdate();

		} catch (SQLException e) {
			return false;
		}
		return (rs == 1) ? true : false;
	}

	public static void main(String[] args) {

		getCon();

	}

}
