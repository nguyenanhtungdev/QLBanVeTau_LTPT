package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {

	@Id
	@Column(name = "maTaiKhoan", nullable = false, length = 50)
	private String maTaiKhoan;

	@Column(name = "tenDangNhap", nullable = false, unique = true, length = 50)
	private String tenDangNhap;

	@Column(name = "matKhau", nullable = false, length = 100)
	private String matKhau;

	@Column(name = "trangThai", nullable = false)
	private boolean trangThai;

	@Column(name = "ngayTaoTaiKhoan")
	private LocalDateTime ngayTaoTaiKhoan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	public TaiKhoan() {
	}

	public TaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public TaiKhoan(String maTaiKhoan, String tenDangNhap, String matKhau, boolean trangThai,
					LocalDateTime ngayTaoTaiKhoan, NhanVien nhanVien) {
		this.setMaTaiKhoan(maTaiKhoan);
		this.setTenDangNhap(tenDangNhap);
		this.setMatKhau(matKhau);
		this.setTrangThai(trangThai);
		this.setNgayTaoTaiKhoan(ngayTaoTaiKhoan);
		this.nhanVien = nhanVien;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		if (tenDangNhap != null && !tenDangNhap.trim().isEmpty() && tenDangNhap.matches("^[a-zA-Z0-9._]+$")) {
			this.tenDangNhap = tenDangNhap;
		} else {
			throw new IllegalArgumentException("Tên đăng nhập không hợp lệ!");
		}
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		matKhau = matKhau.trim();
		if (matKhau != null && matKhau.length() >= 8
				&& matKhau.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$")) {
			this.matKhau = matKhau;
		} else {
			throw new IllegalArgumentException("Mật khẩu không hợp lệ!");
		}
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public LocalDateTime getNgayTaoTaiKhoan() {
		return ngayTaoTaiKhoan;
	}

	public void setNgayTaoTaiKhoan(LocalDateTime ngayTaoTaiKhoan) {
		if (ngayTaoTaiKhoan.isBefore(LocalDateTime.now()) || ngayTaoTaiKhoan.isEqual(LocalDateTime.now())) {
			this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
		} else {
			throw new IllegalArgumentException("Ngày tạo tài khoản không hợp lệ!");
		}
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", trangThai=" + trangThai + ", ngayTaoTaiKhoan=" + ngayTaoTaiKhoan + ", nhanVien=" + nhanVien + "]";
	}
}
