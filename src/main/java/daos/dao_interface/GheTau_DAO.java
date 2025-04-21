package daos.dao_interface;

import model.GheTau;

import java.util.List;

public interface GheTau_DAO {
    public List<GheTau> getAll();

    public boolean add(GheTau gheTau);

    public boolean update(GheTau gheTau);

    public boolean delete(String maGheTau);

    public GheTau getByMaGheTau(String maGheTau);
}
