package daos.dao_interface;

import model.GiaVe;

import java.util.List;

public interface GiaVe_DAO {
    public List<GiaVe> getAll();

    public boolean add(GiaVe giaVe);

    public boolean update(GiaVe giaVe);

    public boolean delete(String maGiaVe);

    public GiaVe getByMaGiaVe(String maGiaVe);
}
