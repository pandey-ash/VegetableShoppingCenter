package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Category implements Serializable {

    /** identifier field */
    private Long pkCategoryId;

    /** persistent field */
    private String categoryName;

    /** persistent field */
    private String description;

    /** persistent field */
    private Integer level;

    /** persistent field */
    private String isRoot;

    /** persistent field */
    private Long createdby;

    /** persistent field */
    private Date createddate;

    /** nullable persistent field */
    private Long modifiedby;

    /** nullable persistent field */
    private Date modifieddate;

    /** persistent field */
    private String isactive;

    /** nullable persistent field */
    private String ef1;

    /** nullable persistent field */
    private String ef2;

    /** persistent field */
    private com.VegetableShoppingCentre.pojo.Category category;

    /** persistent field */
    private Set products;

    /** persistent field */
    private Set categories;

    /** full constructor */
    public Category(Long pkCategoryId, String categoryName, String description, Integer level, String isRoot, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.Category category, Set products, Set categories) {
        this.pkCategoryId = pkCategoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.level = level;
        this.isRoot = isRoot;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.category = category;
        this.products = products;
        this.categories = categories;
    }

    /** default constructor */
    public Category() {
    }

    /** minimal constructor */
    public Category(Long pkCategoryId, String categoryName, String description, Integer level, String isRoot, Long createdby, Date createddate, String isactive, com.VegetableShoppingCentre.pojo.Category category, Set products, Set categories) {
        this.pkCategoryId = pkCategoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.level = level;
        this.isRoot = isRoot;
        this.createdby = createdby;
        this.createddate = createddate;
        this.isactive = isactive;
        this.category = category;
        this.products = products;
        this.categories = categories;
    }

    public Long getPkCategoryId() {
        return this.pkCategoryId;
    }

    public void setPkCategoryId(Long pkCategoryId) {
        this.pkCategoryId = pkCategoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIsRoot() {
        return this.isRoot;
    }

    public void setIsRoot(String isRoot) {
        this.isRoot = isRoot;
    }

    public Long getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Long getModifiedby() {
        return this.modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getModifieddate() {
        return this.modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getEf1() {
        return this.ef1;
    }

    public void setEf1(String ef1) {
        this.ef1 = ef1;
    }

    public String getEf2() {
        return this.ef2;
    }

    public void setEf2(String ef2) {
        this.ef2 = ef2;
    }

    public com.VegetableShoppingCentre.pojo.Category getCategory() {
        return this.category;
    }

    public void setCategory(com.VegetableShoppingCentre.pojo.Category category) {
        this.category = category;
    }

    public Set getProducts() {
        return this.products;
    }

    public void setProducts(Set products) {
        this.products = products;
    }

    public Set getCategories() {
        return this.categories;
    }

    public void setCategories(Set categories) {
        this.categories = categories;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkCategoryId", getPkCategoryId())
            .toString();
    }

}
