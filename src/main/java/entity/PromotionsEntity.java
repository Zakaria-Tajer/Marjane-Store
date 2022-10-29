package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "promotions", schema = "marjpromo", catalog = "")
@NamedQuery(name = "promotionsList", query = "SELECT p FROM PromotionsEntity p")
public class PromotionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "promotion_id")
    private int promotionId;
    @Basic
    @Column(name = "reduction")
    private int reduction;
    @Basic
    @Column(name = "center_id")
    private int centerId;
    @Basic
    @Column(name = "stock")
    private int stock;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "promotion_unique_id")
    private String promotionUniqueId;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "promotion_expiring_date")
    private Date promotionExpiringDate;

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPromotionUniqueId() {
        return promotionUniqueId;
    }

    public void setPromotionUniqueId(String promotionUniqueId) {
        this.promotionUniqueId = promotionUniqueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionsEntity that = (PromotionsEntity) o;

        if (promotionId != that.promotionId) return false;
        if (reduction != that.reduction) return false;
        if (centerId != that.centerId) return false;
        if (stock != that.stock) return false;
        if (categoryId != that.categoryId) return false;
        if (promotionUniqueId != null ? !promotionUniqueId.equals(that.promotionUniqueId) : that.promotionUniqueId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promotionId;
        result = 31 * result + reduction;
        result = 31 * result + centerId;
        result = 31 * result + stock;
        result = 31 * result + categoryId;
        result = 31 * result + (promotionUniqueId != null ? promotionUniqueId.hashCode() : 0);
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPromotionExpiringDate() {
        return promotionExpiringDate;
    }

    public void setPromotionExpiringDate(Date promotionExpiringDate) {
        this.promotionExpiringDate = promotionExpiringDate;
    }
}