package Hoadon;

public class Bill {

	public String MaHD, TenKH, TenSP, Ngayban, Nhanvien;
	public Double Giaban, Thanhtien;
	public int Soluong;

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public String getNgayban() {
		return Ngayban;
	}

	public void setNgayban(String ngayban) {
		Ngayban = ngayban;
	}

	public String getNhanvien() {
		return Nhanvien;
	}

	public void setNhanvien(String nhanvien) {
		Nhanvien = nhanvien;
	}

	public Double getGiaban() {
		return Giaban;
	}

	public void setGiaban(Double giaban) {
		Giaban = giaban;
	}

	public int getSoluong() {
		return Soluong;
	}

	public void setSoluong(int soluong) {
		Soluong = soluong;
	}

	public Double getThanhtien() {
		return Thanhtien;
	}

	public void setThanhtien(Double thanhtien) {
		Thanhtien = thanhtien;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(String maHD, String tenKH, String tenSP, String ngayban, String nhanvien, Double giaban,
			Double thanhtien, int soluong) {
		MaHD = maHD;
		TenKH = tenKH;
		TenSP = tenSP;
		Ngayban = ngayban;
		Nhanvien = nhanvien;
		Giaban = giaban;
		Soluong = soluong;
		Thanhtien = thanhtien;
	}

}
