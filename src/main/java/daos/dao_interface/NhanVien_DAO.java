package daos.dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.NhanVien;

public interface NhanVien_DAO extends Remote{
    List<NhanVien> getAll() throws RemoteException;
    NhanVien getByMaNhanVien(String maNhanVien) throws RemoteException;
    boolean update(NhanVien nhanVien) throws RemoteException;
    List<NhanVien> findNhanVienByTen(String ten) throws RemoteException;
    List<NhanVien> findNhanVienBySdt(String sdt) throws RemoteException;
    List<NhanVien> findNhanVienByCCCD(String cccd) throws RemoteException;
    boolean insertNhanVien(NhanVien nhanVien) throws RemoteException;
    boolean insertNhanVien(Object[] nhanVien) throws RemoteException;
    String getMaNVMax() throws RemoteException;
}
