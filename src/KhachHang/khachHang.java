package KhachHang;

public class khachHang {
	String makh, hoten, diachi, sdt;

	public khachHang() {
		super();
	}

	public khachHang(String makh, String hoten, String diachi, String sdt) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
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
	
}
