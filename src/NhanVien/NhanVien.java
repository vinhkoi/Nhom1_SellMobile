package NhanVien;

public class NhanVien {

	String manv, hoten, diachi, sdt;
	double luong;
	public NhanVien(String manv, String hoten, String diachi, String sdt, double luong) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.luong = luong;
	}
	public NhanVien() {
		super();
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	
	

	
	
}

