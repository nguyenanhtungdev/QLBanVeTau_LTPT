package model;

import daos.dao_impl.KhachHang_DAOImpl;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ThongTinGiuCho {
	@Id
	@Column(name = "maThongTinGiuCho", columnDefinition = "char(7)")
	@EqualsAndHashCode.Include
	private String maThongTinGiuCho;

	@Column(name = "ngayDatGiuCho", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime ngayDatGiuCho;

	@Column(name = "ngayHetHanGiuCho", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime ngayHetHanGiuCho;

	@Column(name = "trangThai", nullable = false)
	private int trangThai;

	@Column(name = "ghiChu", columnDefinition = "nvarchar(255)")
	private String ghiChu;

	@ManyToOne(optional = false)
	@JoinColumn(name = "maKH", columnDefinition = "CHAR(9)")
	private KhachHang khachHang;
	@OneToOne(mappedBy = "thongTinGiuCho", cascade = CascadeType.ALL, orphanRemoval = true)
	private HoaDon hoaDon;
	

	public ThongTinGiuCho(String maThongTinGiuCho) {
		this.maThongTinGiuCho = maThongTinGiuCho;
	}

	public ThongTinGiuCho() {

	}

	public String getMaThongTinGiuCho() {
		return maThongTinGiuCho;
	}

	public void setMaThongTinGiuCho(String maThongTinGiuCho) {
		this.maThongTinGiuCho = maThongTinGiuCho;
	}

	public LocalDateTime getNgayDatGiuCho() {
		return ngayDatGiuCho;
	}

	public void setNgayDatGiuCho(LocalDateTime ngayDatGiuCho) {
		this.ngayDatGiuCho = ngayDatGiuCho;
	}

	public LocalDateTime getNgayHetHanGiuCho() {
		return ngayHetHanGiuCho;
	}

	public void setNgayHetHanGiuCho(LocalDateTime ngayHetHanGiuCho) {
		this.ngayHetHanGiuCho = ngayHetHanGiuCho;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public KhachHang getKhachHang() {
		return khachHang.getSoDienThoai() == null
				? khachHang = KhachHang_DAOImpl.getInstance().getByMaKhachHang(khachHang.getMaKhachHang())
				: khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "ThongTinGiuCho {maThongTinGiuCho: " + maThongTinGiuCho + ", ngayDatGiuCho: " + ngayDatGiuCho
				+ ", ngayHetHanGiuCho: " + ngayHetHanGiuCho + ", ghiChu: " + ghiChu + ", khachHang: " + khachHang + "}";
	}

}
