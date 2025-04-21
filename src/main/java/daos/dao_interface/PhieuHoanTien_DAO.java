package daos.dao_interface;

import model.PhieuHoanTien;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PhieuHoanTien_DAO extends Remote {
    boolean themPhieuHoanTien(PhieuHoanTien phieuHoanTien) throws RemoteException;
    String getMaPhieuHoanTienMax() throws RemoteException;
    PhieuHoanTien layPhieuHoanTienBangMa(String maPhieuHoanTien) throws RemoteException;
    String getMaPhieuHoanTienByMaHoaDon(String maHoaDon) throws RemoteException;
    String getMaHoaDonByMaPhieuHoanTien(String maPhieuHoanTien) throws RemoteException;
    String getTenKhachHangByMaPhieuHoanTien(String maPhieuHoanTien) throws RemoteException;
}