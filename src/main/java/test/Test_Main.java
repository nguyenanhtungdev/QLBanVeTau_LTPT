package test;

import constant.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Test_Main {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", Config.get("DATABASE_URL"));
        properties.put("jakarta.persistence.jdbc.user", Config.get("DATABASE_USER"));
        properties.put("jakarta.persistence.jdbc.password", Config.get("DATABASE_PASSWORD"));

        entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL", properties);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Kết nối thành công!");
        entityManager.close();
    }
}
