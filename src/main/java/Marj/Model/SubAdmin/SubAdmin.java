package Marj.Model.SubAdmin;

import entity.AdminEntity;
import entity.CentersEntity;
import entity.ManagersEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class SubAdmin {

    public void createMangers(String email, String password, String uniqueId, int cityResponsableFor){
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
    public List<CentersEntity> getCityForManagers(){

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

}
