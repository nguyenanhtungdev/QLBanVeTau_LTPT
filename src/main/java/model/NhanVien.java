<<<<<<< HEAD
package model;

import java.time.LocalDate;
import java.time.Period;

public class NhanVien {

	private String maNV;
	private String hoTenNV;
	private LocalDate ngaySinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private boolean gioiTinh;
	private String CCCD;
	private float heSoLuong;
	private boolean trangThai;
	private String tenChucVu;
	private LocalDate ngayVaoLam;

	public NhanVien(String maNV, String hoTenNV, LocalDate ngaySinh, String soDienThoai, String email, String diaChi,
			boolean gioiTinh, String CCCD, float heSoLuong, boolean trangThai, String tenChucVu, LocalDate ngayVaoLam) {
		this.setMaNV(maNV);
		this.setHoTenNV(hoTenNV);
		this.setNgaySinh(ngaySinh);
		this.setSoDienThoai(soDienThoai);
		this.setEmail(email);
		this.setDiaChi(diaChi);
		this.setGioiTinh(gioiTinh);
		this.setCCCD(CCCD);
		this.setHeSoLuong(heSoLuong);
		this.setTrangThai(trangThai);
		this.setTenChucVu(tenChucVu);
		this.setNgayVaoLam(ngayVaoLam);
	}

	public NhanVien() {
	}

	public NhanVien(String maNV) {
		this.setMaNV(maNV);
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		maNV = maNV.trim(); // Nhớ là phải xóa đi cái khoảng trắng
		if (maNV != null && maNV.matches("^NV\\d{5}$")) {
			this.maNV = maNV;
		} else {
			throw new IllegalArgumentException("Mã nhân viên phải có dạng 'NVxxxxx', với 'xxxxx' là các chữ số.");
		}
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		if (hoTenNV != null && hoTenNV.matches("^[a-zA-Z\\p{L} ]+$")) {
			this.hoTenNV = hoTenNV;
		} else {
			throw new IllegalArgumentException("Họ tên nhân viên chỉ được chứa các chữ cái và khoảng trắng.");
		}
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		int temp_Age = Period.between(ngaySinh, LocalDate.now()).getYears();
		if (ngaySinh.isBefore(LocalDate.now()) && (temp_Age >= 18 && temp_Age <= 60)) {
            this.ngaySinh = ngaySinh;
        } else {
            throw new IllegalArgumentException("Ngày sinh không hợp lệ. ");
        }
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (soDienThoai != null && soDienThoai.matches("^\\d{10}$")) {
			this.soDienThoai = soDienThoai;
		} else {
			throw new IllegalArgumentException("Độ dài chuỗi phải tuân thủ là 10 ký tự. ");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && email.matches("^[a-zA-Z0-9._-]+@gmail.com$")) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Định dạng email không hợp lệ! ");
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		if (diaChi != null && diaChi.matches("^[\\p{L}0-9/., ]+$")) {
		    this.diaChi = diaChi;
		} else {
		    throw new IllegalArgumentException("Định dạng địa chỉ không hợp lệ!");
		}
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String CCCD) {
		if (CCCD != null && CCCD.matches("^\\d{12}$")) {
			this.CCCD = CCCD;
		} else {
			throw new IllegalArgumentException("Định dạng CCCD không hợp lệ! ");
		}
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		if (heSoLuong >= 0) {
			this.heSoLuong = Math.round(heSoLuong * 100.0) / 100.0f; // Giới hạn tối đa 2 chữ số thập phân
		} else {
			throw new IllegalArgumentException("Hệ số lương phải là số dương.");
		}
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTenNV=" + hoTenNV + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", CCCD=" + CCCD
				+ ", heSoLuong=" + heSoLuong + ", trangThai=" + trangThai + "]";
	}

}
=======
package model;

import java.time.LocalDate;
import java.time.Period;

public class NhanVien {

	private String maNV;
	private String hoTenNV;
	private LocalDate ngaySinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private boolean gioiTinh;
	private String CCCD;
	private float heSoLuong;
	private boolean trangThai;
	private String tenChucVu;
	private LocalDate ngayVaoLam;

	public NhanVien(String maNV, String hoTenNV, LocalDate ngaySinh, String soDienThoai, String email, String diaChi,
			boolean gioiTinh, String CCCD, float heSoLuong, boolean trangThai, String tenChucVu, LocalDate ngayVaoLam) {
		this.setMaNV(maNV);
		this.setHoTenNV(hoTenNV);
		this.setNgaySinh(ngaySinh);
		this.setSoDienThoai(soDienThoai);
		this.setEmail(email);
		this.setDiaChi(diaChi);
		this.setGioiTinh(gioiTinh);
		this.setCCCD(CCCD);
		this.setHeSoLuong(heSoLuong);
		this.setTrangThai(trangThai);
		this.setTenChucVu(tenChucVu);
		this.setNgayVaoLam(ngayVaoLam);
	}

	public NhanVien() {
	}

	public NhanVien(String maNV) {
		this.setMaNV(maNV);
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		maNV = maNV.trim(); // Nhớ là phải xóa đi cái khoảng trắng
		if (maNV != null && maNV.matches("^NV\\d{5}$")) {
			this.maNV = maNV;
		} else {
			throw new IllegalArgumentException("Mã nhân viên phải có dạng 'NVxxxxx', với 'xxxxx' là các chữ số.");
		}
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		if (hoTenNV != null && hoTenNV.matches("^[a-zA-Z\\p{L} ]+$")) {
			this.hoTenNV = hoTenNV;
		} else {
			throw new IllegalArgumentException("Họ tên nhân viên chỉ được chứa các chữ cái và khoảng trắng.");
		}
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		int temp_Age = Period.between(ngaySinh, LocalDate.now()).getYears();
		if (ngaySinh.isBefore(LocalDate.now()) && (temp_Age >= 18 && temp_Age <= 60)) {
            this.ngaySinh = ngaySinh;
        } else {
            throw new IllegalArgumentException("Ngày sinh không hợp lệ. ");
        }
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (soDienThoai != null && soDienThoai.matches("^\\d{10}$")) {
			this.soDienThoai = soDienThoai;
		} else {
			throw new IllegalArgumentException("Độ dài chuỗi phải tuân thủ là 10 ký tự. ");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && email.matches("^[a-zA-Z0-9._-]+@gmail.com$")) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Định dạng email không hợp lệ! ");
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		if (diaChi != null && diaChi.matches("^[\\p{L}0-9/., ]+$")) {
		    this.diaChi = diaChi;
		} else {
		    throw new IllegalArgumentException("Định dạng địa chỉ không hợp lệ!");
		}
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String CCCD) {
		if (CCCD != null && CCCD.matches("^\\d{12}$")) {
			this.CCCD = CCCD;
		} else {
			throw new IllegalArgumentException("Định dạng CCCD không hợp lệ! ");
		}
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		if (heSoLuong >= 0) {
			this.heSoLuong = Math.round(heSoLuong * 100.0) / 100.0f; // Giới hạn tối đa 2 chữ số thập phân
		} else {
			throw new IllegalArgumentException("Hệ số lương phải là số dương.");
		}
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTenNV=" + hoTenNV + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", CCCD=" + CCCD
				+ ", heSoLuong=" + heSoLuong + ", trangThai=" + trangThai + "]";
	}

}
>>>>>>> c105a37e67cbf3cae62f7d2ba7590e75df9fe850
