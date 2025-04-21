package daos.dao_interface;

import model.CaLam;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CaLam_DAO extends Remote {
    public List<CaLam> getAll() throws RemoteException;

    public CaLam getByMaCa(String maCaLam) throws RemoteException;

    public boolean add(CaLam entity) throws RemoteException;

    public boolean update(CaLam entity) throws RemoteException;



}
