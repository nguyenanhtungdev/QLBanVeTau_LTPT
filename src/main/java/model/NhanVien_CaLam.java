package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@IdClass(NhanVien_CaLamId.class)
@Table(name = "NhanVien_CaLam")
public class NhanVien_CaLam implements Serializable {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNV", nullable = false, columnDefinition = "CHAR(8)")
	private NhanVien nhanVien;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCa", nullable = false, columnDefinition = "CHAR(4)")
	private CaLam caLam;
	@Column(name = "thoiGianNhanCa", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime thoiGianNhanCa;

	@Column(name = "thoiGianKetThucCa", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime thoiGianKetThucCa;

	public NhanVien_CaLam() {
	}

	public NhanVien_CaLam(LocalDateTime thoiGianNhanCa, LocalDateTime thoiGianKetThucCa,
						  NhanVien nhanVien, CaLam caLam) {
		setThoiGianNhanCa(thoiGianNhanCa);
		setThoiGianKetThucCa(thoiGianKetThucCa);
		this.nhanVien = nhanVien;
		this.caLam = caLam;
	}

	public LocalDateTime getThoiGianNhanCa() {
		return thoiGianNhanCa;
	}

	public void setThoiGianNhanCa(LocalDateTime thoiGianNhanCa) {
		if (thoiGianNhanCa == null) {
			throw new IllegalArgumentException("Thời gian nhận ca không được null.");
		}
		this.thoiGianNhanCa = thoiGianNhanCa;
	}

	public LocalDateTime getThoiGianKetThucCa() {
		return thoiGianKetThucCa;
	}

	public void setThoiGianKetThucCa(LocalDateTime thoiGianKetThucCa) {
		if (thoiGianKetThucCa == null || (thoiGianNhanCa != null && thoiGianKetThucCa.isBefore(thoiGianNhanCa))) {
			throw new IllegalArgumentException("Thời gian kết thúc ca phải sau thời gian nhận ca.");
		}
		this.thoiGianKetThucCa = thoiGianKetThucCa;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public CaLam getCaLam() {
		return caLam;
	}

	public void setCaLam(CaLam caLam) {
		this.caLam = caLam;
	}

	public float soGioLam() {
		if (thoiGianNhanCa != null && thoiGianKetThucCa != null) {
			long minutes = Duration.between(thoiGianNhanCa, thoiGianKetThucCa).toMinutes();
			return minutes / 60.0f;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "NhanVien_CaLam {thoiGianNhanCa: " + thoiGianNhanCa +
				", thoiGianKetThucCa: " + thoiGianKetThucCa +
				", nhanVien: " + (nhanVien != null ? nhanVien.getMaNV() : "null") +
				", caLam: " + (caLam != null ? caLam.getMaCa() : "null") + "}";
	}
}
