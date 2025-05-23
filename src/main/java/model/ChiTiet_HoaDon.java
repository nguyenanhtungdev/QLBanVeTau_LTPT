package model;

import daos.dao_impl.HoaDon_DAOImpl;
import daos.dao_impl.KhuyenMai_DAOImpl;
import daos.dao_impl.VeTau_DAOImpl;
import jakarta.persistence.*;

import java.io.Serializable;
import java.rmi.RemoteException;

@Entity
@Table(name = "ChiTiet_HoaDon")
@IdClass(ChiTiet_HoaDonId.class)
public class ChiTiet_HoaDon implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon", nullable = false, columnDefinition = "CHAR(11)")
	private HoaDon hoaDon;

	@Id
	@OneToOne
	@JoinColumn(name = "maVeTau", nullable = false, columnDefinition = "CHAR(8)")
	private VeTau veTau;
	@Column(name = "soLuong", nullable = false)
	private int soLuong;
	@ManyToOne()
	@JoinColumn(name = "maKhuyenMai", nullable = true, columnDefinition = "CHAR(6)")
	private KhuyenMai khuyenMai;
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

	public HoaDon getHoaDon() throws RemoteException {
		return hoaDon.getNgayLapHoaDon() == null ? hoaDon = HoaDon_DAOImpl.getInstance().getByMaHoaDon(hoaDon.getMaHoaDon())
				: hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public VeTau getVeTau() throws RemoteException {
		return veTau.getNgayHetHan() == null ? veTau = VeTau_DAOImpl.getInstance().getByMaVeTau(veTau.getMaVeTau()) : veTau;
	}

	public void setVeTau(VeTau veTau) {
		this.veTau = veTau;
	}

	public KhuyenMai getKhuyenMai() throws RemoteException {
		if (khuyenMai == null) {
			return khuyenMai;
		} else {
			return (khuyenMai.getTenKhuyenMai() == null)
					? khuyenMai = KhuyenMai_DAOImpl.getInstance().getByMaKhuyenMai(khuyenMai.getMaKhuyenMai())
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
}
