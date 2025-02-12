package model;

public class ThongTinVe {
	private HoaDon hoaDon;
	private VeTau veTau;
	private ChuyenTau chuyenTau;

	public ThongTinVe() {
	}

	public ThongTinVe(HoaDon hoaDon, VeTau veTau) {
		this.hoaDon = hoaDon;
		this.veTau = veTau;
	}

	public ThongTinVe(HoaDon hoaDon, VeTau veTau, ChuyenTau chuyenTau) {
		super();
		this.hoaDon = hoaDon;
		this.veTau = veTau;
		this.chuyenTau = chuyenTau;
	}

	public ThongTinVe(VeTau veTau, ChuyenTau chuyenTau) {
		super();
		this.veTau = veTau;
		this.chuyenTau = chuyenTau;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public VeTau getVeTau() {
		return veTau;
	}

	public void setVeTau(VeTau veTau) {
		this.veTau = veTau;
	}

	public ChuyenTau getChuyenTau() {
		return chuyenTau;
	}

	public void setChuyenTau(ChuyenTau chuyenTau) {
		this.chuyenTau = chuyenTau;
	}

	@Override
	public String toString() {
		return "ThongTinVe [hoaDon=" + hoaDon + ", veTau=" + veTau + ", chuyenTau=" + chuyenTau + "]";
	}

}
