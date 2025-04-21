package daos.dao_interface;

import model.CaLam;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CaLam_DAO extends Remote {
    List<CaLam> getAll() throws RemoteException;

    CaLam getByMaCa(String maCaLam) throws RemoteException;

    boolean add(CaLam entity) throws RemoteException;

    boolean update(CaLam entity) throws RemoteException;



}
