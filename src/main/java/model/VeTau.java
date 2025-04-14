package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.Year;
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VeTau {
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "maVeTau", length = 8, columnDefinition = "CHAR(8)", nullable = false)
	private String maVeTau;

	@Column(name = "loaiVe", length = 10, nullable = false)
	private boolean loaiVe;

	@Column(name = "ngayHetHan", nullable = false)
	private LocalDateTime ngayHetHan;

	@Column(name = "daHuy", nullable = false)
	private boolean daHuy;

	@ManyToOne
	@JoinColumn(name = "maGheTau", nullable = false, columnDefinition = "CHAR(7)")
	private GheTau gheTau;

	@Column(name = "isKhuHoi", nullable = false)
	private boolean isKhuHoi;

	@Column(name = "maKH", length = 9, columnDefinition = "CHAR(9)")
	private String maKH;

	@Transient
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

    public VeTau(String maVeTau, boolean loaiVe, boolean daHuy) {
		this.maVeTau = maVeTau;
		this.loaiVe = loaiVe;
		this.daHuy = daHuy;
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
