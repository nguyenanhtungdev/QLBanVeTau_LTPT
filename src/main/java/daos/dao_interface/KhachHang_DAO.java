package daos.dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.KhachHang;

public interface KhachHang_DAO extends Remote{
    List<KhachHang> getAll() throws RemoteException;
    KhachHang getByMaKhachHang(String maKhachHang) throws RemoteException;
    boolean insertKhachHang(KhachHang khachHang) throws RemoteException;
    String getMaKHMax() throws RemoteException;
    KhachHang findKhachHangByCCCDOrSDT(String cccd, String sdt) throws RemoteException;
    boolean updateKhachHang(KhachHang khachHang) throws RemoteException;
}
