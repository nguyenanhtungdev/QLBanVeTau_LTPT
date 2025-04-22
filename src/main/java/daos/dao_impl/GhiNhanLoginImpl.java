package daos.dao_impl;

import daos.dao_interface.GhiNhanLogin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class GhiNhanLoginImpl extends UnicastRemoteObject implements GhiNhanLogin {

    protected GhiNhanLoginImpl() throws RemoteException {
    }

    public void ghiNhanLogin(String tenNguoiDung, LocalDateTime thoiGian, String noiDung) throws RemoteException {
        System.out.println("[LOGIN] Người dùng: " + tenNguoiDung);
        System.out.println(" - Thời gian: " + thoiGian);
        System.out.println(" - Nội dung: " + noiDung);
        System.out.println(" - Login thành công!" + noiDung);
    }
}
