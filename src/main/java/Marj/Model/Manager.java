package Marj.Model;

import Marj.Data.AdminConst;
import Marj.Data.ManagerData;
import Marj.Model.Dao.DbConnection;
import entity.AdminEntity;
import entity.ManagersEntity;
import entity.PromotionsEntity;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager extends DbConnection {


    public void getManagerEmail(String email) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypedQuery<ManagersEntity> ManagerQuery = entityManager.createNamedQuery("managerEmail", ManagersEntity.class);
            ManagerQuery.setParameter(1, email);

            for (ManagersEntity manager : ManagerQuery.getResultList()) {
                ManagerData.setEmail(manager.getEmail());
                ManagerData.setPassword(manager.getPassword());
                ManagerData.setUniqueId(manager.getUniqueId());
                ManagerData.setCentersByCityResponsableFor(manager.getCentersByCityResponsableFor().getCity());
                ManagerData.setCategoryByCategoryRespoFor(manager.getCategoryByCategoryRespoFor().getCategoryName());
                ManagerData.setCityResponsableFor(manager.getCityResponsableFor());
            }

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public List<PromotionsEntity> getManagerPromotions(int centerId) throws SQLException {

        List<PromotionsEntity> promotions = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            TypedQuery<PromotionsEntity> PromoManagerQuery = entityManager.createNamedQuery("getCenterIdProm", PromotionsEntity.class);
            PromoManagerQuery.setParameter(1, centerId);

            for (PromotionsEntity promos : PromoManagerQuery.getResultList()) {
                promotions.add(promos);
            }

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return promotions;
    }
}
