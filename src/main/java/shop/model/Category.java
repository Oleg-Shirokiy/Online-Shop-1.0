package shop.model;

import javax.persistence.*;
/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "categories")
public class Category extends BaseModel{
    @OneToOne
    Category parentCategory;

    int level;
    private String categoryID;
    private String categoryName;
    private String parentCategoryID;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentCategoryID() {
        return parentCategoryID;
    }

    public void setParentCategoryID(String parentCategoryID) {
        this.parentCategoryID = parentCategoryID;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }


}
