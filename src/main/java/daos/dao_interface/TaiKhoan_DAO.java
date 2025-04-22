package daos.dao_interface;

import model.TaiKhoan;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TaiKhoan_DAO extends Remote {
    ArrayList<TaiKhoan> getalltbTK() throws RemoteException;
    boolean insertTaiKhoan(TaiKhoan tk) throws RemoteException;
    String getMaTKMax() throws RemoteException;
}