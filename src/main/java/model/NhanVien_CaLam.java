package model;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "NhanVien_CaLam")
public class NhanVien_CaLam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "thoiGianNhanCa", nullable = false)
	private LocalDateTime thoiGianNhanCa;

	@Column(name = "thoiGianKetThucCa", nullable = false)
	private LocalDateTime thoiGianKetThucCa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNV", nullable = false)
	private NhanVien nhanVien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCa", nullable = false)
	private CaLam caLam;

	public NhanVien_CaLam() {
	}

	public NhanVien_CaLam(LocalDateTime thoiGianNhanCa, LocalDateTime thoiGianKetThucCa,
						  NhanVien nhanVien, CaLam caLam) {
		setThoiGianNhanCa(thoiGianNhanCa);
		setThoiGianKetThucCa(thoiGianKetThucCa);
		this.nhanVien = nhanVien;
		this.caLam = caLam;
	}

	public Long getId() {
		return id;
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
