package daos.dao_interface;

import model.Tau;
import model.Tau.TrangThaiTau;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface Tau_DAO extends Remote {
    List<Tau> getAll() throws RemoteException;
    Tau getByMaTau(String maTau) throws RemoteException;
    boolean add(Tau tau) throws RemoteException;
    boolean update(Tau tau) throws RemoteException;
    boolean capNhapTTTau(String maTau, TrangThaiTau trangThaiMoi) throws RemoteException;
    Tau layTTTauTheoMa(String maTau) throws RemoteException;
    List<Tau> layTTTauTheoTrangThai(TrangThaiTau trangThai) throws RemoteException;
    Tau getTauByMaChuyenTau(String maChuyenTau) throws RemoteException;
    Map<String, Integer> layThongTinGhe(String maTau) throws RemoteException;
}