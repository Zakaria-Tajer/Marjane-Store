package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "centers", schema = "marjpromo")
@NamedQuery(name = "checkIfAdminIsAlreadyAssignedToAStore", query = "SELECT c FROM CentersEntity c JOIN AdminEntity a WHERE c.adminRespo = ?1 AND c.adminRespo = a.adminId")
@NamedQuery(name = "getCenters", query = "SELECT c FROM CentersEntity c")
public class CentersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "center_id")
    private int centerId;
    @Basic
    @Column(name = "admin_respo")
    private int adminRespo;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "center_unique_id")
    private String centerUniqueId;

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }
    @JoinColumn(name = "admin_respo", referencedColumnName = "admin_id")
    public int getAdminRespo() {
        return adminRespo;
    }

    public void setAdminRespo(int adminRespo) {
        this.adminRespo = adminRespo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCenterUniqueId() {
        return centerUniqueId;
    }

    public void setCenterUniqueId(String centerUniqueId) {
        this.centerUniqueId = centerUniqueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentersEntity that = (CentersEntity) o;

        if (centerId != that.centerId) return false;
        if (adminRespo != that.adminRespo) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (centerUniqueId != null ? !centerUniqueId.equals(that.centerUniqueId) : that.centerUniqueId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = centerId;
        result = 31 * result + adminRespo;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (centerUniqueId != null ? centerUniqueId.hashCode() : 0);
        return result;
    }




}
