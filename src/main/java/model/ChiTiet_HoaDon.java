package model;

import jakarta.persistence.*;

@Entity
@Table(name = "ChiTiet_HoaDon")
public class ChiTiet_HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "soLuong")
	private int soLuong;
	@ManyToOne()
	@JoinColumn(name = "maHoaDon", nullable = false)
	private HoaDon hoaDon;
	@ManyToOne()
	@JoinColumn(name = "maKhuyenMai", nullable = true)
	private KhuyenMai khuyenMai;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maVeTau")
	private VeTau veTau;

	public ChiTiet_HoaDon() {
	}

	public ChiTiet_HoaDon(int soLuong, HoaDon hoaDon, VeTau veTau) {
		setSoLuong(soLuong);
		this.hoaDon = hoaDon;
		this.veTau = veTau;
	}

	public ChiTiet_HoaDon(int soLuong, HoaDon hoaDon, KhuyenMai khuyenMai, VeTau veTau) {
		setSoLuong(soLuong);
		this.hoaDon = hoaDon;
		this.khuyenMai = khuyenMai;
		this.veTau = veTau;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong <= 0) {
			throw new IllegalArgumentException("Số lượng phải là số nguyên dương lớn hơn 0.");
		}

		this.soLuong = soLuong;
	}

	public HoaDon getHoaDon() {
		return hoaDon.getNgayLapHoaDon() == null ? hoaDon = HoaDon_DAO.getInstance().getByMaHoaDon(hoaDon.getMaHoaDon())
				: hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public VeTau getVeTau() {
		return veTau.getNgayHetHan() == null ? veTau = VeTau_DAO.getInstance().getByMaVeTau(veTau.getMaVeTau()) : veTau;
	}

	public void setVeTau(VeTau veTau) {
		this.veTau = veTau;
	}

	public KhuyenMai getKhuyenMai() {
		if (khuyenMai == null) {
			return khuyenMai;
		} else {
			return (khuyenMai.getTenKhuyenMai() == null)
					? khuyenMai = KhuyenMai_DAO.getInstance().getByMaKhuyenMai(khuyenMai.getMaKhuyenMai())
					: khuyenMai;
		}

	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public double tinhThanhTien(Double giaVeHienTai, Double tiLeGiamGia) {
		return giaVeHienTai - (giaVeHienTai * tiLeGiamGia);
	}

	@Override
	public String toString() {
		return "ChiTiet_HoaDon {soLuong: " + soLuong + ", hoaDon: " + hoaDon + ", khuyenMai: " + khuyenMai + ", veTau: "
				+ veTau + "}";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
