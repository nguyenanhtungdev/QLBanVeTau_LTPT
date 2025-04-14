package vn.banvetau.QLBanVeTau;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class TestCreateDB {
    @Test
    void TestCreateDB(){
        EntityManager em = Persistence.createEntityManagerFactory("MSSQL")
                .createEntityManager();
    }
}
