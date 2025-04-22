package daos.dao_interface;

import model.CaLam;
import model.ChiTiet_HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

public interface AllDao extends Remote {
    CaLam_DAO getCaLam_DAO() throws RemoteException;
    ChiTiet_HoaDon_DAO getChiTiet_HoaDon_DAO() throws RemoteException;
    ChuyenTau_DAO getChuyenTau_DAO() throws RemoteException;
    GheTau_DAO getGheTau_DAO() throws RemoteException;
    GiaVe_DAO getGiaVe_DAO() throws RemoteException;
    HoaDon_DAO getHoaDon_DAO() throws RemoteException;
    KhachHang_DAO getKhachHang_DAO() throws RemoteException;
    KhuyenMai_DAO getKhuyenMai_DAO() throws RemoteException;
    NhanVien_CaLam_DAO getNhanVien_CaLam_DAO() throws RemoteException;
    NhanVien_DAO getNhanVien_DAO() throws RemoteException;
    PhieuHoanTien_DAO getPhieuHoanTien_DAO() throws RemoteException;
    TaiKhoan_DAO getTaiKhoan_DAO() throws RemoteException;
    Tau_DAO getTau_DAO() throws RemoteException;
    ToaTau_DAO getToaTau_DAO() throws RemoteException;
    VeTau_DAO getVeTau_DAO() throws RemoteException;

    void ghiNhanLogin(String tenNguoiDung, LocalDateTime thoiGian, String noiDung) throws RemoteException;
}
