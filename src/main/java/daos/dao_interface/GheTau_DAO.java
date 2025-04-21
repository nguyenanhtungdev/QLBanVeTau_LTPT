package daos.dao_interface;

import model.GheTau;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface GheTau_DAO extends Remote {
    List<GheTau> getAll() throws RemoteException;

    GheTau getByMaGheTau(String maGheTau) throws RemoteException;

    ArrayList<GheTau> getDsGheTau(String maToaTau) throws RemoteException;

    boolean updateTrangThaiGheTau(String maGheTau, String trangThaiMoi) throws RemoteException;

    List<GheTau> getGheTauTheoMaToaTau(String maToaTau) throws RemoteException;


}
