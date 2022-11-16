package Marj.Model.Promotions;

import entity.AdminEntity;
import entity.PromotionsEntity;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Promotions {


    public List<PromotionsEntity> getPromotions() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<PromotionsEntity> promotionsLists = new ArrayList<>();

        try {
            transaction.begin();

            TypedQuery<PromotionsEntity> promotionQuery = entityManager.createNamedQuery("promotionsList", PromotionsEntity.class);

            promotionsLists.addAll(promotionQuery.getResultList());

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return promotionsLists;
    }


    public void makeAPromotions(int reduction, int centerId, int stock, int category,String unique_id, String status, LocalDate expirationDate) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            PromotionsEntity promotions = new PromotionsEntity();

            promotions.setReduction(reduction);
            promotions.setCenterId(centerId);
            promotions.setStock(stock);
            promotions.setCategoryId(category);
            promotions.setPromotionUniqueId(unique_id);
            promotions.setStatus(status);
            promotions.setPromotionExpiringDate(Date.valueOf(expirationDate));

            entityManager.persist(promotions);

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public String updatePromotionsById(int promotionId, String status) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        String msg = "";
        try {
            transaction.begin();

            Query promotionQuery = entityManager.createQuery("UPDATE PromotionsEntity p SET p.status = ?1 WHERE p.promotionId = ?2");
            promotionQuery.setParameter(1, status);
            promotionQuery.setParameter(2, promotionId);

            int exe = promotionQuery.executeUpdate();

            if(exe > 0){
                System.out.println("updated");
                msg = "updated";
            }
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return msg;
    }

    public List<PromotionsEntity> getPromotionsWithStatusWait() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        List<PromotionsEntity> promotionsLists = new ArrayList<>();
        try {
            transaction.begin();
            TypedQuery<PromotionsEntity> promotionsQuery = entityManager.createNamedQuery("getPromotionsByStatus", PromotionsEntity.class);

            promotionsQuery.setParameter(1, "waiting");

           for (PromotionsEntity entity : promotionsQuery.getResultList()){
               promotionsLists.add(entity);
           }
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return promotionsLists;
    }
}
