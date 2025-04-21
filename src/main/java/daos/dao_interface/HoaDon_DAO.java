package daos.dao_interface;

import model.HoaDon;

public interface HoaDon_DAO {
    public boolean add(HoaDon hoaDon);

    public boolean update(HoaDon hoaDon);

    public boolean delete(String maHoaDon);

    public HoaDon getByMaHoaDon(String maHoaDon);
}
