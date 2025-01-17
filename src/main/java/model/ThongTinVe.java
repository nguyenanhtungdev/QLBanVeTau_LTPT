package model;

public class ThongTinVe {
	private HoaDon hoaDon;
	private VeTau veTau;

	public ThongTinVe() {
	}

	public ThongTinVe(HoaDon hoaDon, VeTau veTau) {
		this.hoaDon = hoaDon;
		this.veTau = veTau;
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

	@Override
	public String toString() {
		return "ThongTinVe [hoaDon=" + hoaDon + ", veTau=" + veTau + "]";
	}

}
