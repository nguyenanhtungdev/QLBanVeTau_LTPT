package daos.dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import model.NhanVien_CaLam;

public interface NhanVien_CaLam_DAO extends Remote{
    List<NhanVien_CaLam> getAll() throws RemoteException;
    boolean saveOrUpdate(NhanVien_CaLam nhanVienCaLam) throws RemoteException;
    List<NhanVien_CaLam> getByNhanVienAndNgay(String maNV, LocalDate ngay) throws RemoteException;
    boolean delete(NhanVien_CaLam nhanVienCaLam) throws RemoteException;
}
