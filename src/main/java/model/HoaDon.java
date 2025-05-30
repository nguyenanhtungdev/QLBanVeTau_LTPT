package model;

import daos.dao_impl.KhachHang_DAOImpl;
import daos.dao_impl.NhanVien_DAOImpl;
import daos.dao_impl.ThongTinTram_DAOImpl;
import jakarta.persistence.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

	@Id
	@Column(name = "maHoaDon", length = 11, columnDefinition = "CHAR(11)")
	private String maHoaDon;
	@Column(name = "ngayLapHoaDon", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime ngayLapHoaDon;
	@Column(name = "ghiChu", columnDefinition = "NVARCHAR(255)")
	private String ghiChu;
	@Column(name = "thueVAT", nullable = false, columnDefinition = "FLOAT")
	private float thueVAT;
	@Column(name = "phuongThucThanhToan", nullable = false, columnDefinition = "NVARCHAR(50)")
	private String phuongThucThanhToan;
	@Column(name = "loaiHoaDon", nullable = false, columnDefinition = "NVARCHAR(30)")
	private String loaiHoaDon;

	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChiTiet_HoaDon> chiTietHoaDons;

	@ManyToOne
	@JoinColumn(name = "maKH", columnDefinition = "CHAR(9)")
	private KhachHang khachHang;
	@ManyToOne
	@JoinColumn(name = "maNhaGa", columnDefinition = "CHAR(7)")
	private ThongTinTram thongTinTram;
	@ManyToOne
	@JoinColumn(name = "maNV", columnDefinition = "CHAR(8)")
	private NhanVien nhanVien;
	@OneToOne
	@JoinColumn(name = "maThongTinGiuCho", columnDefinition = "CHAR(7)")
	private ThongTinGiuCho thongTinGiuCho;

	public HoaDon() {
	}

	public HoaDon(String maHoaDon, LocalDateTime ngayLapHoaDon, String ghiChu, float thueVAT,
			String phuongThucThanhToan, String loaiHoaDon, KhachHang khachHang, ThongTinTram thongTinTram,
			NhanVien nhanVien, ThongTinGiuCho thongTinGiuCho) {
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ghiChu = ghiChu;
		this.thueVAT = thueVAT;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.loaiHoaDon = loaiHoaDon;
		this.khachHang = khachHang;
		this.thongTinTram = thongTinTram;
		this.nhanVien = nhanVien;
		this.thongTinGiuCho = thongTinGiuCho;
	}

	public HoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		if (maHoaDon != null && maHoaDon.matches("^HD\\d{4}\\d{5}$")) {
			this.maHoaDon = maHoaDon;
		} else {
			System.out.println(maHoaDon);
			throw new IllegalArgumentException("Mã hóa đơn phải có dạng 'HDmmyyxxxxx'");
		}
	}

	public LocalDateTime getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
		if (!ngayLapHoaDon.isAfter(LocalDateTime.now())) { // chấp nhận cả trường hợp ngày lập hóa đơn bằng hoặc trước
															// thời điểm hiện tại
			this.ngayLapHoaDon = ngayLapHoaDon;
		} else {
			throw new IllegalArgumentException("Ngày lập hóa đơn không hợp lệ.");
		}
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public float getThueVAT() {
		return thueVAT;
	}

	public void setThueVAT(float thueVAT) {
		if (thueVAT > 0) {
			this.thueVAT = thueVAT;
		} else {
			throw new IllegalArgumentException("Thuế VAT phải > 0");
		}
	}

	public double tinhTongTien(ArrayList<Double> dsChiTiet) {
		double tongTien = 0.0;
		for (int i = 0; i < dsChiTiet.size(); i++) {
			tongTien += dsChiTiet.get(i);
		}
		return tongTien;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		// Chưa ràng buộc
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public String getLoaiHoaDon() {
		return loaiHoaDon;
	}

	public void setLoaiHoaDon(String loaiHoaDon) {
		// Chưa ràng buộc
		this.loaiHoaDon = loaiHoaDon;
	}

	public KhachHang getKhachHang() throws RemoteException {
		return khachHang.getHoTen() == null
				? khachHang = KhachHang_DAOImpl.getInstance().getByMaKhachHang(khachHang.getMaKhachHang())
				: khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ThongTinTram getThongTinTram() throws RemoteException {
		return thongTinTram.getTenNhaGa() == null
				? thongTinTram = ThongTinTram_DAOImpl.getInstance().getByMaNhaGa(thongTinTram.getMaNhaGa())
				: thongTinTram;
	}

	public void setThongTinTram(ThongTinTram thongTinTram) {
		this.thongTinTram = thongTinTram;
	}

	public NhanVien getNhanVien() throws RemoteException {
		return nhanVien.getHoTenNV() == null ? nhanVien = NhanVien_DAOImpl.getInstance().getByMaNhanVien(nhanVien.getMaNV())
				: nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ThongTinGiuCho getThongTinGiuCho() {
		// TODO implement DAO for ThongTinGiuCho
		return thongTinGiuCho;
	}

	public void setThongTinGiuCho(ThongTinGiuCho thongTinGiuCho) {
		this.thongTinGiuCho = thongTinGiuCho;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof HoaDon))
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon {maHoaDon: " + maHoaDon + ", ngayLapHoaDon: " + ngayLapHoaDon + ", ghiChu: " + ghiChu
				+ ", thueVAT: " + thueVAT + ", phuongThucThanhToan: " + phuongThucThanhToan + ", loaiHoaDon: "
				+ loaiHoaDon + ", khachHang: " + khachHang + ", thongTinTram: " + thongTinTram + ", nhanVien: "
				+ nhanVien + ", thongTinGiuCho: " + thongTinGiuCho + "}";
	}

}
