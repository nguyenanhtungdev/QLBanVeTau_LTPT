package daos.dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface GhiNhanLogin extends Remote {
    void ghiNhanLogin(String tenNguoiDung, LocalDateTime thoiGian, String noiDung) throws RemoteException;
}
