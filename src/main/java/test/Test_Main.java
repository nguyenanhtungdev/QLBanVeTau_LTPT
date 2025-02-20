package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

public class Test_Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("MSSQL")
                .createEntityManager();
        EntityTransaction tr = entityManager.getTransaction();
        Faker faker = new Faker();
    }
}
