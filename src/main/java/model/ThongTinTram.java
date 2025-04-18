package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ThongTinTram")
public class ThongTinTram {

	@Id
	@Column(name = "maNhaGa", nullable = false, length = 50)
	private String maNhaGa;

	@Column(name = "tenNhaGa", length = 100)
	private String tenNhaGa;

	@Column(name = "diaChi", length = 255)
	private String diaChi;

	@Column(name = "dienThoai", length = 20)
	private String dienThoai;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "tenNganHang", length = 100)
	private String tenNganHang;

	@Column(name = "soTaiKhoan", length = 30)
	private String soTaiKhoản;

	@Column(name = "maSoThue", length = 30)
	private String maSoThue;

	public ThongTinTram() {
	}

	public ThongTinTram(String maNhaGa) {
		this.maNhaGa = maNhaGa;
	}

	public ThongTinTram(String maNhaGa, String tenNhaGa, String diaChi, String dienThoai, String email,
						String tenNganHang, String soTaiKhoản, String maSoThue) {
		this.maNhaGa = maNhaGa;
		this.tenNhaGa = tenNhaGa;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.tenNganHang = tenNganHang;
		this.soTaiKhoản = soTaiKhoản;
		this.maSoThue = maSoThue;
	}

	public String getMaNhaGa() {
		return maNhaGa;
	}

	public void setMaNhaGa(String maNhaGa) {
		this.maNhaGa = maNhaGa;
	}

	public String getTenNhaGa() {
		return tenNhaGa;
	}

	public void setTenNhaGa(String tenNhaGa) {
		this.tenNhaGa = tenNhaGa;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenNganHang() {
		return tenNganHang;
	}

	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}

	public String getSoTaiKhoản() {
		return soTaiKhoản;
	}

	public void setSoTaiKhoản(String soTaiKhoản) {
		this.soTaiKhoản = soTaiKhoản;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	@Override
	public String toString() {
		return "ThongTinTram [maNhaGa=" + maNhaGa + ", tenNhaGa=" + tenNhaGa + ", diaChi=" + diaChi + ", dienThoai="
				+ dienThoai + ", email=" + email + ", tenNganHang=" + tenNganHang + ", soTaiKhoản=" + soTaiKhoản
				+ ", maSoThue=" + maSoThue + "]";
	}
}
