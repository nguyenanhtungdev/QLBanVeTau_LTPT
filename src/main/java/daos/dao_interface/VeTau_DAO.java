package daos.dao_interface;

import model.VeTau;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VeTau_DAO extends Remote {
    List<VeTau> getAll() throws RemoteException;
    String getVeTauMax() throws RemoteException;
    VeTau getByMaVeTau(String maVeTau) throws RemoteException;
    VeTau getByMaVeTauChuyenTau(String maVeTau) throws RemoteException;
    boolean themVeTau(VeTau veTau) throws RemoteException;
    boolean capNhatTrangThaiVeTau(String maKH, String maHoaDon) throws RemoteException;
    VeTau getByMaHoaDon(String maHoaDon) throws RemoteException;
}