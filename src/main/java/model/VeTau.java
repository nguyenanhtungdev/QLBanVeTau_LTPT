package model;

import java.time.LocalDateTime;
import java.time.Year;

public class VeTau {

	private String maVeTau;
	private boolean loaiVe;
	private LocalDateTime ngayHetHan;
	private boolean daHuy;
	private GheTau gheTau;
	private boolean isKhuHoi;
	private KhachHang khachHang;

	public VeTau() {
	}

	public VeTau(String maVeTau, boolean loaiVe, LocalDateTime ngayHetHan, boolean daHuy, GheTau gheTau, boolean isKhuHoi,KhachHang khachHang) {
		setMaVeTau(maVeTau);
		this.loaiVe = loaiVe;
		this.ngayHetHan = ngayHetHan;
		this.daHuy = daHuy;
		this.gheTau = gheTau;
		this.khachHang = khachHang;
		this.isKhuHoi = isKhuHoi;
	}

	public VeTau(String maVeTau) {
		this.maVeTau = maVeTau;
	}

	public String getMaVeTau() {
		return maVeTau;
	}

	public void setMaVeTau(String maVeTau) {
		if (maVeTau != null && !maVeTau.matches("^VT") && !maVeTau.matches("\\d{4}$")) {
			this.maVeTau = maVeTau;
		} else {
			throw new IllegalArgumentException(
					"Mã vé tàu phải có dạng 'VTYYXXXX' với YY là 2 chữ số cuối năm hiện tại và XXXX là các chữ số.");
		}
	}

	public boolean isLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(boolean loaiVe) {
		this.loaiVe = loaiVe;
	}

	public LocalDateTime getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDateTime ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public boolean isDaHuy() {
		return daHuy;
	}

	public void setDaHuy(boolean daHuy) {
		this.daHuy = daHuy;
	}

	public GheTau getGheTau() {
		return gheTau.getTenLoaiGheTau() == null ? gheTau = GheTau_DAO.getInstance().getByMaGheTau(gheTau.getMaGheTau())
				: gheTau;
	}
	public KhachHang getKhachHang() {
		return khachHang = KhachHang_DAO.getInstance().getByMaKhachHang(khachHang.getMaKhachHang());
	}
	
	public boolean isKhuHoi() {
		return isKhuHoi;
	}

	public void setKhuHoi(boolean isKhuHoi) {
		this.isKhuHoi = isKhuHoi;
	}

	public void setGheTau(GheTau gheTau) {
		this.gheTau = gheTau;
	}
	
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "VeTau [maVeTau=" + maVeTau + ", loaiVe=" + loaiVe + ", ngayHetHan=" + ngayHetHan + ", daHuy=" + daHuy
				+ ", gheTau=" + gheTau + ", isKhuHoi=" + isKhuHoi + ", khachHang=" + khachHang + "]";
	}

}
