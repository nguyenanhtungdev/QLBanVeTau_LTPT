package daos.dao_interface;

import model.ThongTinTram;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ThongTinTram_DAO extends Remote {
    ThongTinTram getByMaNhaGa(String maNhaGa) throws RemoteException;
}