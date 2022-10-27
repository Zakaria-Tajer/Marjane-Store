package Marj.example;

import entity.AdminEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HibernateTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            AdminEntity entity = new AdminEntity();

            entity.setEmail("admin@example.com");
            entity.setPassword("katlife1234");
            entity.setUniqueId("#dkmedkdm");
            entityManager.persist(entity);

//            entityManager.createNamedQuery("");
            transaction.commit();

        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }
}
