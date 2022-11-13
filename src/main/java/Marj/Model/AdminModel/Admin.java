package Marj.Model.AdminModel;

import Marj.Data.AdminConst;
import Marj.Data.AdminsCount;
import Marj.Model.Dao.DbConnection;
import Marj.PrstManager.Prst;
import entity.AdminEntity;
import entity.CentersEntity;
import entity.ManagersEntity;
import entity.PromotionsEntity;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Admin extends DbConnection {

    Prst prstManager = new Prst();

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
    public List<AdminEntity> getListAdminsCenters() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<AdminEntity> adminsCenetersLists = new ArrayList<>();
        try {
            transaction.begin();

            TypedQuery<AdminEntity> adminQuery = entityManager.createNamedQuery("getAllAdminsAssociatedCenters", AdminEntity.class);
            adminQuery.setParameter(1, "admin");

            for (AdminEntity admin : adminQuery.getResultList()) {

                adminsCenetersLists.add(admin);
            }


            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
        return adminsCenetersLists;
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

    public int countAdmin() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        int adminCount = 0;
        try {
            transaction.begin();

            TypedQuery<AdminEntity> adminQuery = entityManager.createNamedQuery("getCountsAdmin", AdminEntity.class);
            adminQuery.setParameter(1, "admin");

            if (adminQuery.getResultList() != null) {
                adminCount = Integer.parseInt(String.valueOf(adminQuery.getResultList().toString().charAt(1)));
                AdminsCount.setCount(adminCount);
            }
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return adminCount;

    }

    public int countManagers() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        int managerCount = 0;
        try {
            transaction.begin();

            TypedQuery<ManagersEntity> managerQuery = entityManager.createNamedQuery("getCountsManager", ManagersEntity.class);

            System.out.println("result = " + Arrays.toString(new List[]{managerQuery.getResultList()}));
            if (managerQuery.getResultList() != null) {
                managerCount = Integer.parseInt(String.valueOf(managerQuery.getResultList().toString()).substring(1, managerQuery.getResultList().toString().length() - 1));
                AdminsCount.setCount(managerCount);
            }
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return managerCount;

    }

    public int countPromotions() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        int promotionsCount = 0;
        try {
            transaction.begin();

            TypedQuery<PromotionsEntity> promotionsQuery = entityManager.createNamedQuery("getPromotionsManager", PromotionsEntity.class);

            if (promotionsQuery.getResultList() != null) {
                promotionsCount = Integer.parseInt(String.valueOf(promotionsQuery.getResultList().toString()).substring(1, promotionsQuery.getResultList().toString().length() - 1));

            }
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return promotionsCount;

    }

    public int countNewAdmins() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        int newAdminsCount = 0;
        try {
            transaction.begin();

            TypedQuery<AdminEntity> newAdminsQuery = entityManager.createNamedQuery("getCountsNewAdmin", AdminEntity.class);
            newAdminsQuery.setParameter(1, "admin");
            newAdminsQuery.setParameter(2, LocalDate.now());

            if (newAdminsQuery.getResultList() != null) {
                newAdminsCount = Integer.parseInt(String.valueOf(newAdminsQuery.getResultList().toString()).substring(1, newAdminsQuery.getResultList().toString().length() - 1));

            }
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        return newAdminsCount;

    }

    public void deleteAdminById(int adminId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Query deleteAdminsQuery = entityManager.createQuery("DELETE FROM AdminEntity WHERE adminId = ?1");
            deleteAdminsQuery.setParameter(1, adminId);

            int exe = deleteAdminsQuery.executeUpdate();

            if(exe > 0){
                System.out.println("Deleted");
            }
//            entityManager.remove(deleteAdminsQuery);
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
