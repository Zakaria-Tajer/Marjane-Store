package Marj.Model.SubAdmin;

import Marj.Data.ManagerData;
import entity.CentersEntity;
import entity.ManagersEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class SubAdmin {

    public void createMangers(String email, String password, String uniqueId, int cityResponsableFor, int category) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            ManagersEntity managersEntity = new ManagersEntity();

            managersEntity.setEmail(email);
            managersEntity.setPassword(password);
            managersEntity.setUniqueId(uniqueId);
            managersEntity.setCityResponsableFor(cityResponsableFor);
            managersEntity.setCategoryRespoFor(category);
            entityManager.persist(managersEntity);

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public List<CentersEntity> getCityForManagers() {

        List<CentersEntity> centersList = new ArrayList<>();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypedQuery<CentersEntity> centersQuery = entityManager.createNamedQuery("getCenters", CentersEntity.class);

            centersList.addAll(centersQuery.getResultList());

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return centersList;
    }

    public void updatePassword(String hashedPassword, int managerId) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypedQuery<ManagersEntity> managerQuery = entityManager.createNamedQuery("hashPassword", ManagersEntity.class);
            managerQuery.setParameter(1, hashedPassword);
            managerQuery.setParameter(2, managerId);

            entityManager.merge(managerQuery);

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

    }

    public int getManagerId(String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        int id = 0;
        try {
            transaction.begin();

            TypedQuery<ManagersEntity> managerQuery = entityManager.createNamedQuery("getManagerId", ManagersEntity.class);
            managerQuery.setParameter(1, email);

            ManagerData managerData = new ManagerData();
            System.out.println("mammmamma" + managerQuery.getResultList());

            for (ManagersEntity manager : managerQuery.getResultList()) {
                System.out.println("idddss" + manager.getManagerId());
                ManagerData.setManagerId(manager.getManagerId());
            }

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return id;

    }

}
