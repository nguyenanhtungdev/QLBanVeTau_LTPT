package model;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien_CaLamId implements Serializable {
    private String nhanVien;
    private String caLam;

    public NhanVien_CaLamId() {}

    public NhanVien_CaLamId(String nhanVien, String caLam) {
        this.nhanVien = nhanVien;
        this.caLam = caLam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien_CaLamId)) return false;
        NhanVien_CaLamId that = (NhanVien_CaLamId) o;
        return Objects.equals(nhanVien, that.nhanVien) &&
                Objects.equals(caLam, that.caLam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nhanVien, caLam);
    }
}
