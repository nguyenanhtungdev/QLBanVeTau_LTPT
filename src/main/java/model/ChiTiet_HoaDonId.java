package model;

import java.io.Serializable;
import java.util.Objects;

public class ChiTiet_HoaDonId implements Serializable {

    private String hoaDon;
    private String veTau;

    public ChiTiet_HoaDonId() {
    }

    public ChiTiet_HoaDonId(String hoaDon, String veTau) {
        this.hoaDon = hoaDon;
        this.veTau = veTau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTiet_HoaDonId)) return false;
        ChiTiet_HoaDonId that = (ChiTiet_HoaDonId) o;
        return Objects.equals(hoaDon, that.hoaDon) && Objects.equals(veTau, that.veTau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoaDon, veTau);
    }
}
