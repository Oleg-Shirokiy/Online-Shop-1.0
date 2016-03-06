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
    private String exCategoryID;
    private String categoryName;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getExCategoryID() {
        return exCategoryID;
    }

    public void setExCategoryID(String exCategoryID) {
        this.exCategoryID = exCategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }


}
