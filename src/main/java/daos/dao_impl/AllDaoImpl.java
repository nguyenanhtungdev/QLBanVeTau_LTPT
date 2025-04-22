package daos.dao_impl;

import daos.dao_interface.*;
import lombok.Getter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

@Getter
public class AllDaoImpl extends UnicastRemoteObject implements AllDao {

    private final CaLam_DAO caLamDao = new CaLam_DAOImpl();
    private final ChiTiet_HoaDon_DAO chiTietHoaDonDao = new ChiTiet_HoaDon_DAOImpl();
    private final ChuyenTau_DAO chuyenTauDao = new ChuyenTau_DAOImpl();
    private final GheTau_DAO gheTauDao = new GheTau_DAOImpl();
    private final GiaVe_DAO giaVeDao = new GiaVe_DAOImpl();
    private final HoaDon_DAO hoaDonDao = new HoaDon_DAOImpl();
    private final KhachHang_DAO khachHangDao = new KhachHang_DAOImpl();
    private final KhuyenMai_DAO khuyenMaiDao = new KhuyenMai_DAOImpl();
    private final NhanVien_CaLam_DAO nhanVienCaLamDao = new NhanVien_CaLam_DAOImpl();
    private final NhanVien_DAO nhanVienDao = new NhanVien_DAOImpl();
    private final PhieuHoanTien_DAO phieuHoanTienDao = new PhieuHoanTien_DAOImpl();
    private final TaiKhoan_DAO taiKhoanDao = new TaiKhoan_DAOImpl();
    private final Tau_DAO tauDao = new Tau_DAOImpl();
    private final ToaTau_DAO toaTauDao = new ToaTau_DAOImpl();
    private final VeTau_DAO veTauDao = new VeTau_DAOImpl();
    private final GhiNhanLogin ghiNhanLogin = new GhiNhanLoginImpl();

    public AllDaoImpl() throws RemoteException{
    }

    @Override
    public CaLam_DAO getCaLam_DAO() throws RemoteException {
        return null;
    }

    @Override
    public ChiTiet_HoaDon_DAO getChiTiet_HoaDon_DAO() throws RemoteException {
        return null;
    }

    @Override
    public ChuyenTau_DAO getChuyenTau_DAO() throws RemoteException {
        return null;
    }

    @Override
    public GheTau_DAO getGheTau_DAO() throws RemoteException {
        return null;
    }

    @Override
    public GiaVe_DAO getGiaVe_DAO() throws RemoteException {
        return null;
    }

    @Override
    public HoaDon_DAO getHoaDon_DAO() throws RemoteException {
        return null;
    }

    @Override
    public KhachHang_DAO getKhachHang_DAO() throws RemoteException {
        return null;
    }

    @Override
    public KhuyenMai_DAO getKhuyenMai_DAO() throws RemoteException {
        return null;
    }

    @Override
    public NhanVien_CaLam_DAO getNhanVien_CaLam_DAO() throws RemoteException {
        return null;
    }

    @Override
    public NhanVien_DAO getNhanVien_DAO() throws RemoteException {
        return null;
    }

    @Override
    public PhieuHoanTien_DAO getPhieuHoanTien_DAO() throws RemoteException {
        return null;
    }

    @Override
    public TaiKhoan_DAO getTaiKhoan_DAO() throws RemoteException {
        return null;
    }

    @Override
    public Tau_DAO getTau_DAO() throws RemoteException {
        return null;
    }

    @Override
    public ToaTau_DAO getToaTau_DAO() throws RemoteException {
        return null;
    }

    @Override
    public VeTau_DAO getVeTau_DAO() throws RemoteException {
        return null;
    }

    @Override
    public void ghiNhanLogin(String tenNguoiDung, LocalDateTime thoiGian, String noiDung) throws RemoteException {
        ghiNhanLogin.ghiNhanLogin(tenNguoiDung, thoiGian, noiDung);
    }
}
