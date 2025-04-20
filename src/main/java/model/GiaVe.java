package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GiaVe {
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "maGiaVe", nullable = false, columnDefinition = "CHAR(6)")
	private String maGiaVe;
	//float trong SQL Server thật ra là double-precision (8 byte), chứ không giống float 4 byte trong Java.
	@Column(name = "giaVe", nullable = false)
	private double giaVe;

	@Column(name = "tiLeTangGia", nullable = false, columnDefinition = "FLOAT")
	private float tiLeTangGia;

	@Column(name = "ngayCapNhat", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime ngayCapNhat;

	@Column(name = "ghiChu", columnDefinition = "NVARCHAR(50)")
	private String ghiChu;

	@OneToMany(mappedBy = "giaVe")
	private List<ChuyenTau> chuyenTaus;
	public GiaVe() {
	}

	public GiaVe(String maGiaVe) {
		this.maGiaVe = maGiaVe;
	}

	public GiaVe(String maGiaVe, double giaVe, float tiLeTangGia, LocalDateTime ngayCapNhap, String ghiChu) {
		this.maGiaVe = maGiaVe;
		this.giaVe = giaVe;
		this.tiLeTangGia = tiLeTangGia;
		this.ngayCapNhat = ngayCapNhap;
		this.ghiChu = ghiChu;
	}

	public String getMaGiaVe() {
		return maGiaVe;
	}

	public void setMaGiaVe(String maGiaVe) {
		this.maGiaVe = maGiaVe;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	public float getTiLeTangGia() {
		return tiLeTangGia;
	}

	public void setTiLeTangGia(float tiLeTangGia) {
		this.tiLeTangGia = tiLeTangGia;
	}

	public LocalDateTime getNgayCapNhap() {
		return ngayCapNhat;
	}

	public void setNgayCapNhap(LocalDateTime ngayCapNhap) {
		this.ngayCapNhat = ngayCapNhap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	// Tính giá vé tàu
	public double getGiaVeHienTai(String loaiGhe) {
		double giaVeHienTai = giaVe * (1 + tiLeTangGia / 100);
		if (loaiGhe.equals("VIP")) {
			return giaVeHienTai + giaVeHienTai * 0.6;
		}
		return giaVeHienTai;
	}

	@Override
	public String toString() {
		return "GiaVe [maGiaVe=" + maGiaVe + ", giaVe=" + giaVe + ", tiLeTangGia=" + tiLeTangGia + ", ngayCapNhap="
				+ ngayCapNhat + ", ghiChu=" + ghiChu + "]";
	}

}
