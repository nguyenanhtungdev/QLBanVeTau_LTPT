package daos.dao_interface;

import model.GiaVe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GiaVe_DAO extends Remote {
    List<GiaVe> getAll() throws RemoteException;

    GiaVe getByMaGiaVe(String maGiaVe) throws RemoteException;

    GiaVe getGiaVeTheoChuyenTau(String maGheTau, String maChuyenTau) throws RemoteException;


}
