package shop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "categories")
public class Category extends BaseModel{
    @ManyToOne
    Category parentCategory;

    int level;
    private String exCategoryID;
    private String name;

    @ManyToMany
    private List<AttributeTemplate> attributeTemplateList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<AttributeTemplate> getAttributeTemplateList() {
        return attributeTemplateList;
    }

    public void setAttributeTemplateList(List<AttributeTemplate> attributeTemplateList) {
        this.attributeTemplateList = attributeTemplateList;
    }

}
