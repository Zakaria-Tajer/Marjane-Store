package Marj.Model.Promotions;

import entity.AdminEntity;
import entity.PromotionsEntity;
import jakarta.persistence.*;

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


    public void makeAPromotions(int reduction, int centerId, int stock, int category,String unique_id, String status) {
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
}
