package model;

import daos.dao_impl.KhachHang_DAOImpl;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "PhieuHoanTien")
public class PhieuHoanTien implements Serializable {

	@Id
	@Column(name = "maPhieuHoanTien", nullable = false,columnDefinition = "CHAR(8)")
	private String maPhieuHoanTien;
	@Column(name = "ngayHoanTien", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime ngayHoanTien;
	@Column(name = "lyDoHoanTra", length = 255, columnDefinition = "NVARCHAR(100)")
	private String lyDoHoanTien;
	@Column(name = "ghiChu", length = 255, columnDefinition = "NVARCHAR(255)")
	private String ghiChu;
	@Column(name = "tiLeHoanTien", nullable = false, columnDefinition = "FLOAT")
	private float tiLeHoanTien;
	@ManyToOne()
	@JoinColumn(name = "maKH", nullable = false, columnDefinition = "CHAR(9)")
	private KhachHang khachHang;
	public PhieuHoanTien() {
	}

	public PhieuHoanTien(String maPhieuHoanTien) {
		this.maPhieuHoanTien = maPhieuHoanTien;
	}

	public PhieuHoanTien(String maPhieuHoanTien, LocalDateTime ngayHoanTien, float tiLeHoanTien, String lyDoHoanTien,
			String ghiChu, KhachHang khachHang) {
		this.maPhieuHoanTien = maPhieuHoanTien;
		setNgayHoanTien(ngayHoanTien);
		setTiLeHoanTien(tiLeHoanTien);
		setLyDoHoanTien(lyDoHoanTien);
		this.ghiChu = ghiChu;
		this.khachHang = khachHang;
	}

	public String getMaPhieuHoanTien() {
		return maPhieuHoanTien;
	}

	public void setMaPhieuHoanTien(String maPhieuHoanTien) {
		this.maPhieuHoanTien = maPhieuHoanTien;
	}

	public LocalDateTime getNgayHoanTien() {
		return ngayHoanTien;
	}

	public void setNgayHoanTien(LocalDateTime ngayHoanTien) {
		if (ngayHoanTien.isBefore(LocalDateTime.now()) || ngayHoanTien.isEqual(LocalDateTime.now())) {
			this.ngayHoanTien = ngayHoanTien;
		} else {
			throw new IllegalArgumentException("Ngày hoàn tiền không hợp lệ!");
		}
	}

	public String getLyDoHoanTra() {
		return lyDoHoanTien;
	}

	public String getLyDoHoanTien() {
		return lyDoHoanTien;
	}

	public void setLyDoHoanTien(String lyDoHoanTien) {
		this.lyDoHoanTien = lyDoHoanTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		if (ghiChu == null || ghiChu.length() <= 255) {
			this.ghiChu = ghiChu;
		} else {
			throw new IllegalArgumentException("Ghi chú quá dài!");
		}
	}

	public float getTiLeHoanTien() {
		return tiLeHoanTien;
	}

	public void setTiLeHoanTien(float tiLeHoanTien) {
		// Ràng buộc: tỉ lệ hoàn tiền phải >= 0 và <= 100
		if (tiLeHoanTien >= 0 && tiLeHoanTien <= 100) {
			this.tiLeHoanTien = tiLeHoanTien;
		} else {
			throw new IllegalArgumentException("Tỉ lệ hoàn tiền không hợp lệ!");
		}
	}

	public KhachHang getKhachHang() {
		return khachHang.getSoDienThoai() == null
				? khachHang = KhachHang_DAOImpl.getInstance().getByMaKhachHang(khachHang.getMaKhachHang())
				: khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public double tinhSoTienHoanTra(double tongTienThanhToan) {
		return tongTienThanhToan * (tiLeHoanTien / 100);
	}

	@Override
	public String toString() {
		return "PhieuHoanTien [maPhieuHoanTien=" + maPhieuHoanTien + ", ngayHoanTien=" + ngayHoanTien
				+ ", lyDoHoanTien=" + lyDoHoanTien + ", ghiChu=" + ghiChu + ", tiLeHoanTien=" + tiLeHoanTien
				+ ", khachHang=" + khachHang + "]";
	}

}
