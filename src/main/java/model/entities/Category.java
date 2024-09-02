package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cdCategory;
    private String nmCategory;
    public Category(){}
    public Category(int cdCategory, String nmCategory) {
        this.cdCategory = cdCategory;
        this.nmCategory = nmCategory;
    }

    public int getCdCategory() {
        return cdCategory;
    }

    public void setCdCategory(int cdCategory) {
        this.cdCategory = cdCategory;
    }

    public String getNmCategory() {
        return nmCategory;
    }

    public void setNmCategory(String nmCategory) {
        this.nmCategory = nmCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getCdCategory() == category.getCdCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdCategory());
    }

    @Override
    public String toString() {
        return "Category{" +
                "cdCategory=" + cdCategory +
                ", nmCategory='" + nmCategory + '\'' +
                '}';
    }
}
