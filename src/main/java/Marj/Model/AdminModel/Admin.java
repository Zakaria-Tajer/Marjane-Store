package Marj.Model.AdminModel;

import Marj.Data.AdminConst;
import Marj.Model.Dao.DbConnection;
import entity.AdminEntity;
import entity.CentersEntity;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin extends DbConnection {


    public void getAdminEmail(String email) throws SQLException {
//        String adminLoggedUniqueId = null;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            AdminEntity entity = new AdminEntity();

            TypedQuery<AdminEntity> adminQuery = entityManager.createNamedQuery("adminEmail", AdminEntity.class);
            adminQuery.setParameter(1, email);

            for (AdminEntity admin : adminQuery.getResultList()) {
                AdminConst adminData = new AdminConst();

                adminData.setEmail(admin.getEmail());
                adminData.setPassword(admin.getPassword());
                adminData.setUniqueId(admin.getUniqueId());
                adminData.setRole(admin.getRole());
            }

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
//        return adminLoggedUniqueId;
    }

    public String loginAdmin(String email, String password) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            AdminEntity entity = new AdminEntity();

            TypedQuery<AdminEntity> adminQuery = entityManager.createNamedQuery("adminSelection", AdminEntity.class);
            adminQuery.setParameter(1, email);
            adminQuery.setParameter(2, password);

            for (AdminEntity adminEntity : adminQuery.getResultList()) {
                System.out.println(adminEntity);
            }

            transaction.commit();

            if (adminQuery.getResultList().size() > 0) {
                return "founded";
            } else {
                return "auth error";
            }

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }


    public void createAdmin(String email, String password, String uniqueId) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            AdminEntity admin = new AdminEntity();

            admin.setEmail(email);
            admin.setPassword(password);
            admin.setUniqueId(uniqueId);
            admin.setRole("admin");
            entityManager.persist(admin);

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public void assignAdminToAStore(int admin_respo, String city, String center_unique_id) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            CentersEntity centersEntity = new CentersEntity();

            centersEntity.setAdminRespo(admin_respo);
            centersEntity.setCity(city);
            centersEntity.setCenterUniqueId(center_unique_id);
            entityManager.persist(centersEntity);

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    @PersistenceContext
    @PersistenceUnit
    public List<AdminEntity> getAdmins() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<AdminEntity> adminsLists = new ArrayList<>();
        try {
            transaction.begin();

            TypedQuery<AdminEntity> adminQuery = entityManager.createNamedQuery("getAdmins", AdminEntity.class);
            adminQuery.setParameter(1, "admin");

            for (AdminEntity admin : adminQuery.getResultList()) {

                adminsLists.add(admin);
            }

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return adminsLists;
    }

    public int checkIfAdminIsAlreadyAssigned(int adminId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        int adminRespo = 0;

        try {
            transaction.begin();

            TypedQuery<CentersEntity> centerQuery = entityManager.createNamedQuery("checkIfAdminIsAlreadyAssignedToAStore", CentersEntity.class);
            centerQuery.setParameter(1, adminId);

            if (centerQuery.getResultList() != null || centerQuery.getResultList().size() != 0) {
                for (CentersEntity center : centerQuery.getResultList()) {
                    adminRespo = center.getAdminRespo();
                    System.out.println(center.getAdminRespo() + "founded");
                }
            }

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return adminRespo;
    }


}
