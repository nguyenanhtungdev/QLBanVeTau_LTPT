package daos.dao_interface;

import model.ChuyenTau;

import java.util.List;

public interface ChuyenTau_DAO {
    public List<ChuyenTau> getAll();

    public boolean add(ChuyenTau chuyenTau);

    public boolean update(ChuyenTau chuyenTau);

    public boolean delete(String maChuyenTau);

    public ChuyenTau getByMaChuyenTau(String maChuyenTau);

    public List<ChuyenTau> getByGaDen(String gaDen);

    public List<ChuyenTau> getByGaKhoiHanh(String gaKhoiHanh);
}
