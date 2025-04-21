package daos.dao_interface;

import model.ChiTiet_HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTiet_HoaDon_DAO extends Remote {
    public List<ChiTiet_HoaDon> getAll() throws RemoteException;

    public boolean add(ChiTiet_HoaDon ct) throws RemoteException;



}
