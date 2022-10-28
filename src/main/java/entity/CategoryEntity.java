package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category", schema = "marjpromo")
@NamedQuery(name = "getAllCategories", query = "SELECT c FROM CategoryEntity c")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "category_name")
    private String categoryName;
    @Basic
    @Column(name = "category_uniqueId")
    private String categoryUniqueId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryUniqueId() {
        return categoryUniqueId;
    }

    public void setCategoryUniqueId(String categoryUniqueId) {
        this.categoryUniqueId = categoryUniqueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryId != that.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        if (categoryUniqueId != null ? !categoryUniqueId.equals(that.categoryUniqueId) : that.categoryUniqueId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryUniqueId != null ? categoryUniqueId.hashCode() : 0);
        return result;
    }
}
