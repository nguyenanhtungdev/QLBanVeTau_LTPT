package daos.dao_interface;

import java.rmi.Remote;

import model.PhieuHoanTien;

public interface PhieuHoanTien_DAO extends Remote{
    boolean themPhieuHoanTien(PhieuHoanTien phieuHoanTien) throws Exception;
    String getMaPhieuHoanTienMax() throws Exception;
    PhieuHoanTien layPhieuHoanTienBangMa(String maPhieuHoanTien) throws Exception;
    String getMaPhieuHoanTienByMaHoaDon(String maHoaDon) throws Exception;
    String getMaHoaDonByMaPhieuHoanTien(String maPhieuHoanTien) throws Exception;
    String getTenKhachHangByMaPhieuHoanTien(String maPhieuHoanTien) throws Exception;
}
