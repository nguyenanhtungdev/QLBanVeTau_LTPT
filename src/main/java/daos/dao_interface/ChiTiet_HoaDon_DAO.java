package daos.dao_interface;

import model.ChiTiet_HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTiet_HoaDon_DAO extends Remote {
    List<ChiTiet_HoaDon> getAll() throws RemoteException;

    boolean add(ChiTiet_HoaDon ct) throws RemoteException;

    List<ChiTiet_HoaDon> getByMaHoaDon(String maHoaDon) throws RemoteException;

    List<ChiTiet_HoaDon> getByMaHoaDon(List<String> maHoaDons) throws RemoteException;



}
