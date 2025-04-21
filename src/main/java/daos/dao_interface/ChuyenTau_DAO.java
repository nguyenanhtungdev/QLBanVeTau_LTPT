package daos.dao_interface;

import model.ChuyenTau;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ChuyenTau_DAO extends Remote {
    List<ChuyenTau> getAll() throws RemoteException;

    ChuyenTau getByMaChuyenTau(String id) throws RemoteException;

    boolean add(ChuyenTau entity) throws RemoteException;

    boolean update(ChuyenTau entity) throws RemoteException;

    ArrayList<ChuyenTau> timKiemChuyenTau(String gaDi, String gaDen, String ngayDi) throws RemoteException;

    ArrayList<ChuyenTau> timKiemChuyenTauTheoGa(String gaDi, String gaDen) throws RemoteException;

}
