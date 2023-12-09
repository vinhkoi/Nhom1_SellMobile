package KhachHang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class Process_KH {
	public static Connection cn = null;
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_phone","root","G1234567");
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			
		}
		return cn;
	}
//	lấy dữ liệu vào bảng
	public ArrayList<khachHang> loadData(){
		Connection cn = getCon();
		String sql = "select * from tb_customer";
		ArrayList<khachHang> lists = new ArrayList<>();
		try{
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				khachHang kh = new khachHang();
				kh.setMakh(rs.getString("Ma_KH"));
				kh.setHoten(rs.getString("Ho_Ten_KH"));
				kh.setDiachi(rs.getString("Dia_chi"));
				kh.setSdt(rs.getString("SDT"));
	
				lists.add(kh);
			}
			cn.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return lists;
	}
//	tìm kiếm
	public ArrayList<khachHang> getKH_byMaKH(String makh){
		Connection cn = getCon();
		String sql = "select * from  tb_customer where Ma_KH = ? ";
		ArrayList<khachHang> lsStaffDep = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, makh);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				khachHang kh = new khachHang();
				kh.setMakh(rs.getString("Ma_KH"));
				kh.setHoten(rs.getString("Ho_Ten_KH"));
				kh.setDiachi(rs.getString("Dia_chi"));
				kh.setSdt(rs.getString("SDT"));
				
				
				lsStaffDep.add(kh);
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
		return lsStaffDep;
		
	}
//	thêm
	public boolean insertKH(String makh, String hoten, String diachi, String sdt) {
		Connection cn = getCon();
		String sql = "Insert into tb_customer (Ma_KH, Ho_ten_KH, Dia_chi, SDT) "+" values(?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, makh);
			ps.setString(2, hoten);
			ps.setString(3, diachi);
			ps.setString(4, sdt);
			
			ps.executeUpdate();
			cn.close();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
//	sửa
	public boolean updateKH(String makh, String hoten, String diachi, String sdt) {
		Connection cn = getCon();
		int rs = 0;
		String sql = "update tb_customer set  Ho_ten_KH= ?, Dia_chi=?, SDT=? where Ma_KH =?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, hoten);
			ps.setString(2, diachi);
			ps.setString(3, sdt);
			ps.setString(4, makh);
			
			rs= ps.executeUpdate();
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return(rs==1) ? true:false;
	}
	//xóa
		public boolean delKH(String makh) {
			// TODO Auto-generated method stub
			Connection cn = getCon();
			int rs=0;
			String sql = "delete from  tb_customer where Ma_KH=?";
			try {
				PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
				ps.setString(1, makh);
				rs = ps.executeUpdate();
				
			} catch (SQLException e) {
				return false;
			}
			return (rs==1) ? true : false;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getCon();
	}

}
