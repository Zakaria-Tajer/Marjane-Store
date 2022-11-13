package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "admin", schema = "marjpromo")
@NamedQuery(name = "adminSelection", query = "SELECT a FROM AdminEntity a WHERE a.email= ?1 AND a.password= ?2")
@NamedQuery(name = "adminEmail", query = "SELECT a FROM AdminEntity a WHERE a.email= ?1")
@NamedQuery(name = "getAdmins", query = "SELECT a FROM AdminEntity a WHERE a.role = ?1 ")
@NamedQuery(name = "getCountsAdmin", query = "SELECT  count(a) FROM AdminEntity a WHERE a.role = ?1")
@NamedQuery(name = "getCountsNewAdmin", query = "SELECT  count(a) FROM AdminEntity a WHERE a.role = ?1 AND a.newCommers = ?2")
@NamedQuery(name = "getAllAdminsAssociatedCenters", query = "SELECT a FROM AdminEntity a JOIN CentersEntity c WHERE a.role = ?1")
public class AdminEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_respo")
    @Basic
    @Id
    @Column(name = "admin_id")
    private int adminId;
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
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "new_commers")
    private Date newCommers;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (adminId != that.adminId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (uniqueId != null ? !uniqueId.equals(that.uniqueId) : that.uniqueId != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (uniqueId != null ? uniqueId.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    public Date getNewCommers() {
        return newCommers;
    }

    public void setNewCommers(Date newCommers) {
        this.newCommers = newCommers;
    }
}
