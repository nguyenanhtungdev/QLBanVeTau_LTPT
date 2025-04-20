package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

@Entity
@Table(name = "KhachHang")
public class KhachHang {

	@Id
	@Column(name = "maKH", length = 9, columnDefinition = "CHAR(9)")
	private String maKhachHang;
	@Column(name = "hoTen", nullable = false, columnDefinition = "NVARCHAR(100)")
	private String hoTen;
	@Column(name = "soDienThoai", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	private String soDienThoai;
	@Column(name = "email", nullable = false, columnDefinition = "VARCHAR(50)")
	private String email;
	@Column(name = "gioiTinh", nullable = false)
	private boolean gioiTinh;
	@Column(name = "CCCD", length = 12, columnDefinition = "CHAR(12)", nullable = false)
	private String CCCD;
	@Column(name = "ngaySinh", nullable = false, columnDefinition = "DATE")
	private LocalDate ngaySinh;
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VeTau> veTaus;
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhieuHoanTien> phieuHoanTiens;
	@Enumerated(EnumType.STRING)
	@Column(name = "loaiKH", nullable = false, columnDefinition = "NVARCHAR(20)")
	private LoaiKhachHang loaiKH;
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HoaDon> hoaDons;
	@OneToMany(mappedBy = "maThongTinGiuCho", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ThongTinGiuCho> thongTinGiuChos;
	public static enum LoaiKhachHang {
		TRE_EM(1.0), SINH_VIEN(0.05), HOC_SINH(0.1), NGUOI_GIA(0.15), NGUOI_KHUYET_TAT(0.2), KHACH_THUONG(0);

		private final double discount;

		// Constructor cho enum
		LoaiKhachHang(double discount) {
			this.discount = discount;
		}

		public double getDiscount() {
			return discount;
		}

		public static LoaiKhachHang chuyenDoiLoaiKH(String loaiKH) {
			switch (loaiKH) {
			case "Trẻ em":
				return LoaiKhachHang.TRE_EM;
			case "Học sinh":
				return LoaiKhachHang.HOC_SINH;
			case "Sinh viên":
				return LoaiKhachHang.SINH_VIEN;
			case "Người già":
				return LoaiKhachHang.NGUOI_GIA;
			case "Khuyết tật":
				return LoaiKhachHang.NGUOI_KHUYET_TAT;
			case "Khách thường":
				return LoaiKhachHang.KHACH_THUONG;
			default:
				showError("Loại khách hàng không hợp lệ: " + loaiKH);
				return null;
			}
		}

		public static String chuyenDoiTuEnumSangChuoi(LoaiKhachHang loaiKH) {
			switch (loaiKH) {
			case TRE_EM:
				return "Trẻ em";
			case HOC_SINH:
				return "Học sinh";
			case SINH_VIEN:
				return "Sinh viên";
			case NGUOI_GIA:
				return "Người già";
			case NGUOI_KHUYET_TAT:
				return "Khuyết tật";
			case KHACH_THUONG:
				return "Khách thường";
			default:
				showError("Loại khách hàng không hợp lệ: " + loaiKH);
				return null;
			}
		}

		public static String chuyenDoiDiscountToString(double discount) {
			return String.format("%.0f%%", discount * 100);
		}

		public static LoaiKhachHang fromInt(int value) {
			switch (value) {
			case 0:
				return TRE_EM;
			case 1:
				return SINH_VIEN;
			case 2:
				return HOC_SINH;
			case 3:
				return NGUOI_GIA;
			case 4:
				return NGUOI_KHUYET_TAT;
			case 5:
				return KHACH_THUONG;

			default:
				throw new IllegalArgumentException("Out of range");
			}
		}

		@Override
		public String toString() {
			switch (this) {
			case TRE_EM:
				return "Trẻ em";
			case HOC_SINH:
				return "Học sinh";
			case SINH_VIEN:
				return "Sinh viên";
			case NGUOI_GIA:
				return "Người già";
			case NGUOI_KHUYET_TAT:
				return "Khuyết tật";
			case KHACH_THUONG:
				return "Khách thường";
			default:
				return null;
			}
		}
	}

	// Phương thức hiển thị thông báo lỗi
	private static void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	public KhachHang(String maKhachHang, String hoTen, String soDienThoai, String email, boolean gioiTinh, String CCCD,
			LocalDate ngaySinh, LoaiKhachHang loaiKH) {
		this.setMaKhachHang(maKhachHang);
		this.setHoTen(hoTen);
		this.setSoDienThoai(soDienThoai);
		this.setEmail(email);
		this.setGioiTinh(gioiTinh);
		this.setCCCD(CCCD);
		this.setNgaySinh(ngaySinh);
		this.setLoaiKH(loaiKH);
	}

	public KhachHang() {
	}

	public KhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public KhachHang(String maKhachHang, String hoTen, String soDienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		if (maKhachHang != null && maKhachHang.matches("^KH\\d{7}$")) {
			this.maKhachHang = maKhachHang;
		} else {
			showError("Mã khách hàng phải có dạng 'KHxxxxxxx', với 'xxxxxxx' là các chữ số.");
		}
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (hoTen != null && hoTen.matches("^[a-zA-Z\\p{L} ]+$")) {
			this.hoTen = hoTen;
		} else {
			showError("Họ tên khách hàng chỉ được chứa các chữ cái và khoảng trắng.");
		}

	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (soDienThoai != null && soDienThoai.matches("^\\d{10}$")) {
			this.soDienThoai = soDienThoai;
		} else {
			showError("Độ dài chuỗi phải tuân thủ là 10 ký tự. ");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && email.matches("^[a-zA-Z0-9._-]+@gmail.com$")) {
			this.email = email;
		} else {
			showError("Định dạng email không hợp lệ! ");
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
			showError("Định dạng CCCD không hợp lệ! ");
		}
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		if (ngaySinh.isBefore(LocalDate.now()) && Period.between(ngaySinh, LocalDate.now()).getYears() >= 5) {
			this.ngaySinh = ngaySinh;
		} else {
			showError("Ngày sinh không hợp lệ!");
		}
	}

	public LoaiKhachHang getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(LoaiKhachHang loaiKH) {
		this.loaiKH = loaiKH;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		KhachHang khachHang = (KhachHang) obj;
		return this.maKhachHang.equals(khachHang.maKhachHang); // So sánh bằng mã khách hàng
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang); // Sử dụng mã khách hàng để tính hashCode
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", gioiTinh=" + gioiTinh + ", CCCD=" + CCCD + ", ngaySinh=" + ngaySinh
				+ ", loaiKH=" + loaiKH + "]";
	}
}
