package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ThongTinTram")
public class ThongTinTram implements Serializable {

	@Id
	@Column(name = "maNhaGa", nullable = false, columnDefinition = "char(7)")
	private String maNhaGa;

	@Column(name = "tenNhaGa", nullable = false, columnDefinition = "nvarchar(50)")
	private String tenNhaGa;

	@Column(name = "diaChi", nullable = false, columnDefinition = "nvarchar(30)")
	private String diaChi;

	@Column(name = "dienThoai", nullable = false, columnDefinition = "nchar(10)")
	private String dienThoai;

	@Column(name = "email", nullable = false, columnDefinition = "varchar(50)")
	private String email;

	@Column(name = "tenNganHang", nullable = true, columnDefinition = "nvarchar(50)")
	private String tenNganHang;

	@Column(name = "soTaiKhoan", nullable = true, columnDefinition = "varchar(13)")
	private String soTaiKhoan;

	@Column(name = "maSoThue", nullable = false, columnDefinition = "char(10)")
	private String maSoThue;

	@OneToMany(mappedBy = "thongTinTram", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HoaDon> hoaDons;

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
		this.soTaiKhoan = soTaiKhoản;
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
		return soTaiKhoan;
	}

	public void setSoTaiKhoản(String soTaiKhoản) {
		this.soTaiKhoan = soTaiKhoan;
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
				+ dienThoai + ", email=" + email + ", tenNganHang=" + tenNganHang + ", soTaiKhoản=" + soTaiKhoan
				+ ", maSoThue=" + maSoThue + "]";
	}
}
