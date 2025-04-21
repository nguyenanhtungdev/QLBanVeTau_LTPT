package daos.dao_interface;

import model.ToaTau;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ToaTau_DAO extends Remote {
    List<ToaTau> getAll() throws RemoteException;
    ToaTau getByMaToaTau(String maToaTau) throws RemoteException;
    ArrayList<ToaTau> getDsToaTau(String maTau) throws RemoteException;
    ArrayList<ToaTau> getToaTauTheoMaTau(String maTau) throws RemoteException;
}