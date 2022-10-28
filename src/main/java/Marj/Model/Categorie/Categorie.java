package Marj.Model.Categorie;

import entity.CategoryEntity;
import entity.PromotionsEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Categorie {


    public List<CategoryEntity> getAllCategories(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<CategoryEntity> categorieLists = new ArrayList<>();

        try {
            transaction.begin();

            TypedQuery<CategoryEntity> categorieQuery = entityManager.createNamedQuery("getAllCategories", CategoryEntity.class);

            categorieLists.addAll(categorieQuery.getResultList());

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return categorieLists;
    }


}
