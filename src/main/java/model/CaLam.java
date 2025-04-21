package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "CaLam")
public class CaLam implements Serializable {

	@Id
	@Column(name = "maCa", columnDefinition = "char(4)", nullable = false)
	private String maCa;

	@Column(name = "tenCa", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenCa;

	@Column(name = "thoiGianBatDau", nullable = false, columnDefinition = "DATETIME")
	private LocalTime thoiGianBatDau;

	@Column(name = "thoiGianKetThuc", nullable = false, columnDefinition = "DATETIME")
	private LocalTime thoiGianKetThuc;

	@Column(name = "ghiChu", columnDefinition = "nvarchar(255)", nullable = true)
	private String ghiChu;

	public CaLam() {
	}

	public CaLam(String maCa) {
		setMaCa(maCa);
	}

	public CaLam(String maCa, String tenCa, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc, String ghiChu) {
		setMaCa(maCa);
		setTenCa(tenCa);
		this.thoiGianBatDau = thoiGianBatDau;
		setThoiGianKetThuc(thoiGianKetThuc);
		setGhiChu(ghiChu);
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		if (!maCa.matches("^CA\\d{2}$")) {
			throw new IllegalArgumentException("Mã ca làm phải bắt đầu bằng CA và theo sau là hai ký số");
		}
		this.maCa = maCa;
	}

	public String getTenCa() {
		return tenCa;
	}

	public void setTenCa(String tenCa) {
		if (!tenCa.matches("^(SA|TR|TO|KH)$")) {
			throw new IllegalArgumentException("Tên ca làm phải là 1 trong các giá trị “SA”, “TR”, “TO” hoặc “KH”");
		}
		this.tenCa = tenCa;
	}

	public LocalTime getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
		if (this.thoiGianKetThuc != null && thoiGianBatDau.isAfter(this.thoiGianKetThuc)) {
			throw new IllegalArgumentException("Thời gian bắt đầu ca làm phải trước thời gian kết thúc ca làm");
		}
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public LocalTime getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(LocalTime thoiGianKetThuc) {
		if (this.thoiGianBatDau != null && thoiGianKetThuc.isBefore(this.thoiGianBatDau)) {
			throw new IllegalArgumentException("Thời gian kết thúc ca làm phải sau thời gian bắt đầu ca làm");
		}
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CaLam))
			return false;
		CaLam other = (CaLam) obj;
		return Objects.equals(maCa, other.maCa);
	}

	@Override
	public String toString() {
		return "CaLam {maCa: " + maCa + ", tenCa: " + tenCa + ", thoiGianBatDau: " + thoiGianBatDau
				+ ", thoiGianKetThuc: " + thoiGianKetThuc + ", ghiChu: " + ghiChu + "}";
	}
}
