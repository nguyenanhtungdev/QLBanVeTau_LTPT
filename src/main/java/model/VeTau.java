package model;

import daos.dao_impl.GheTau_DAOImpl;
import daos.dao_impl.KhachHang_DAOImpl;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VeTau implements Serializable {
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "maVeTau", length = 8, columnDefinition = "CHAR(8)", nullable = false)
	private String maVeTau;

	@Column(name = "loaiVe", nullable = false, columnDefinition = "NVARCHAR(10)")
	private boolean loaiVe;

	@Column(name = "ngayHetHan", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime ngayHetHan;

	@Column(name = "daHuy", nullable = false)
	private boolean daHuy;

	@ManyToOne
	@JoinColumn(name = "maGheTau", nullable = false, columnDefinition = "CHAR(7)")
	private GheTau gheTau;

	@ManyToOne
	@JoinColumn(name = "maKH", nullable = false, columnDefinition = "CHAR(9)")
	private KhachHang khachHang;

	@Column(name = "isKhuHoi", nullable = false)
	private boolean isKhuHoi;

	@OneToOne(mappedBy = "veTau")
	private ChiTiet_HoaDon chiTietHoaDon;
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

	public GheTau getGheTau() throws RemoteException {
		return gheTau.getTenLoaiGheTau() == null ? gheTau = GheTau_DAOImpl.getInstance().getByMaGheTau(gheTau.getMaGheTau())
				: gheTau;
	}
	public KhachHang getKhachHang() throws RemoteException {
		return khachHang = KhachHang_DAOImpl.getInstance().getByMaKhachHang(khachHang.getMaKhachHang());
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
