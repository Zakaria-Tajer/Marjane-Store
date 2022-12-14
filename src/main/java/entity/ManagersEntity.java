package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "managers", schema = "marjpromo")
@NamedQuery(name = "hashPassword", query = "UPDATE ManagersEntity m SET m.password = ?1 WHERE m.managerId = ?2")
@NamedQuery(name = "getManagerId", query = "SELECT m FROM ManagersEntity m WHERE m.email = ?1")
@NamedQuery(name = "getCountsManager", query = "SELECT  count(m) FROM ManagersEntity m")
@NamedQuery(name = "managerEmail", query = "SELECT m FROM ManagersEntity m WHERE m.email= ?1")
public class ManagersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manager_id")
    private int managerId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "unique_id")
    private String uniqueId;
    @Basic
    @Column(name = "city_responsable_for")
    private int cityResponsableFor;
    @Basic
    @Column(name = "category_respo_for")
    private int categoryRespoFor;
    @ManyToOne
    @JoinColumn(name = "city_responsable_for", referencedColumnName = "center_id", nullable = false, insertable = false, updatable = false)
    private CentersEntity centersByCityResponsableFor;
    @ManyToOne
    @JoinColumn(name = "category_respo_for", referencedColumnName = "category_id", nullable = false, insertable = false, updatable = false)
    private CategoryEntity categoryByCategoryRespoFor;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getCityResponsableFor() {
        return cityResponsableFor;
    }

    public void setCityResponsableFor(int cityResponsableFor) {
        this.cityResponsableFor = cityResponsableFor;
    }

    public int getCategoryRespoFor() {
        return categoryRespoFor;
    }

    public void setCategoryRespoFor(int categoryRespoFor) {
        this.categoryRespoFor = categoryRespoFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagersEntity that = (ManagersEntity) o;

        if (managerId != that.managerId) return false;
        if (cityResponsableFor != that.cityResponsableFor) return false;
        if (categoryRespoFor != that.categoryRespoFor) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (uniqueId != null ? !uniqueId.equals(that.uniqueId) : that.uniqueId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (uniqueId != null ? uniqueId.hashCode() : 0);
        result = 31 * result + cityResponsableFor;
        result = 31 * result + categoryRespoFor;
        return result;
    }

    public CentersEntity getCentersByCityResponsableFor() {
        return centersByCityResponsableFor;
    }

    public void setCentersByCityResponsableFor(CentersEntity centersByCityResponsableFor) {
        this.centersByCityResponsableFor = centersByCityResponsableFor;
    }

    public CategoryEntity getCategoryByCategoryRespoFor() {
        return categoryByCategoryRespoFor;
    }

    public void setCategoryByCategoryRespoFor(CategoryEntity categoryByCategoryRespoFor) {
        this.categoryByCategoryRespoFor = categoryByCategoryRespoFor;
    }
}
