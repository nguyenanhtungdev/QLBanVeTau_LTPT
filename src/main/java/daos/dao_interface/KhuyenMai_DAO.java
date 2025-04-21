package daos.dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.KhuyenMai;
import model.KhuyenMai.TinhTrangKhuyenMai;

public interface KhuyenMai_DAO extends Remote{
    List<KhuyenMai> getAll() throws RemoteException;
    KhuyenMai getByMaKhuyenMai(String maKhuyenMai) throws RemoteException;
    boolean add(KhuyenMai entity) throws RemoteException;
    boolean update(KhuyenMai entity) throws RemoteException;
    List<KhuyenMai> getKhuyenMaiTheoTrangThai(TinhTrangKhuyenMai tinhTrang) throws RemoteException;
    String getMaxMaKhuyenMai() throws RemoteException;
    List<KhuyenMai> getKhuyenMaiHetHanTrong7Ngay() throws RemoteException;
}
