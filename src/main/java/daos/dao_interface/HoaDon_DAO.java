package daos.dao_interface;

import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.ThongTinVe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface HoaDon_DAO extends Remote {
    ArrayList<ThongTinVe> getHoaDonBySoDienThoaiOrCCCD(String soDienThoaiOrMaVeTau) throws RemoteException;

    List<HoaDon> getAll() throws RemoteException;

    HoaDon getByMaHoaDon(String maHoaDon) throws RemoteException;

    ArrayList<HoaDon> getalltbHDKH() throws RemoteException;

    HoaDon layTTHoaDonTheoMa(String maHoaDon) throws RemoteException;

    List<HoaDon> layTTHoaDonTheoSDT(String soDienThoai) throws RemoteException;

    List<HoaDon> layTTHoaDonTheoDate(LocalDateTime startDate, LocalDateTime endDate) throws RemoteException;

    String getMaHoaDonMax() throws RemoteException;

    boolean addHoaDon(HoaDon hoaDon) throws RemoteException;

    List<Map<String, Object>> getThongTinHoaDon(String maHoaDon) throws RemoteException;

    List<HoaDon> getByFilters(LocalDateTime start, LocalDateTime end, KhachHang[] khachHangs,
                              NhanVien[] nhanViens) throws RemoteException;

    int laySoLuongHoaDon(String maHoaDon) throws RemoteException;

    
}
