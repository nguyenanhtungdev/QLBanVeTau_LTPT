package model;

import daos.dao_impl.ToaTau_DAOImpl;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GheTau implements Serializable {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "maGheTau", nullable = false, columnDefinition = "CHAR(7)")
	private String maGheTau;

	@Column(name = "tenLoaiGheTau", nullable = false, columnDefinition = "NVARCHAR(15)")
	private String tenLoaiGheTau;

	@Column(name = "soThuTuGhe", nullable = true)
	private int soThuTuGhe;

	@Column(name = "trangThai", nullable = false, columnDefinition = "NVARCHAR(20)")
	private String trangThai;

	@OneToMany(mappedBy = "gheTau")
	private List<VeTau> veTaus;

	@ManyToOne
	@JoinColumn(name = "maToaTau", nullable = false, columnDefinition = "CHAR(8)")
	private ToaTau toaTau;

	public GheTau() {
	}

	public GheTau(String maGheTau) {
		this.maGheTau = maGheTau;
	}

	public GheTau(String maGheTau, String tenLoaiGheTau, int soThuTuGhe, String trangThai, ToaTau toaTau) {
		this.setMaGheTau(maGheTau);
		this.setTenLoaiGheTau(tenLoaiGheTau);
		this.setsoThuTuGhe(soThuTuGhe);
		this.setTrangThai(trangThai);
		this.toaTau = toaTau;
	}

	public String getMaGheTau() {
		return maGheTau;
	}

	public void setMaGheTau(String maGheTau) {
		maGheTau = maGheTau.trim();
		if (maGheTau != null && maGheTau.matches("^GT\\d{4}$")) {
			this.maGheTau = maGheTau;
		} else {
			throw new IllegalArgumentException("Mã ghế tàu phải có dạng 'GTXXXX', với 'XXXX' là các chữ số.");
		}
	}

	public String getTenLoaiGheTau() {
		return tenLoaiGheTau;
	}

	public void setTenLoaiGheTau(String tenLoaiGheTau) {
		if (tenLoaiGheTau.equals("Ghế") || tenLoaiGheTau.equals("Giường nằm")) {
			this.tenLoaiGheTau = tenLoaiGheTau;
		} else {
			throw new IllegalArgumentException("Tên loại ghế tàu không hợp lệ!");
		}
	}

	public int getsoThuTuGhe() {
		return soThuTuGhe;
	}

	public void setsoThuTuGhe(int soThuTuGhe) {
		// Ràng buộc: phải lớn hơn 0
		if (soThuTuGhe > 0) {
			this.soThuTuGhe = soThuTuGhe;
		} else {
			throw new IllegalArgumentException("Số thứ tự toa không hợp lệ!");
		}
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		if (trangThai.equals("DA_THANH_TOAN") || trangThai.equals("TRONG") || trangThai.equals("DANG_BAO_TRI")
				|| trangThai.equals("DANG_GIU_CHO")) {
			this.trangThai = trangThai;
		} else {
			throw new IllegalArgumentException("Trạng thái không hợp lệ!");
		}
	}

	public ToaTau getToaTau() throws RemoteException {
		return toaTau.getLoaiToa() == null ? toaTau = ToaTau_DAOImpl.getInstance().getByMaToaTau(toaTau.getMaToaTau())
				: toaTau;
	}

	public void setToaTau(ToaTau toaTau) {
		this.toaTau = toaTau;
	}

	@Override
	public String toString() {
		return "GheTau {maGheTau: " + maGheTau + ", tenLoaiGheTau: " + tenLoaiGheTau + ", soThuTuGhe: " + soThuTuGhe
				+ ", trangThai: " + trangThai + ", toaTau: " + toaTau + "}";
	}

}
