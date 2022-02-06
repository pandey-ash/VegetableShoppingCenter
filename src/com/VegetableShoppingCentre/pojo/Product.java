package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Product implements Serializable {

    /** identifier field */
    private Long pkProductId;

    /** persistent field */
    private String productName;

    /** persistent field */
    private String description;

    /** nullable persistent field */
    private Double price;

    /** persistent field */
    private Integer availableQuantity;

    /** persistent field */
    private String imagePath;

    /** persistent field */
    private String devileryBy;

    /** persistent field */
    private String isnew;

    /** persistent field */
    private String isupcoming;

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
    private Set carts;

    /** persistent field */
    private Set orderLogs;

    /** full constructor */
    public Product(Long pkProductId, String productName, String description, Double price, Integer availableQuantity, String imagePath, String devileryBy, String isnew, String isupcoming, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.Category category, Set carts, Set orderLogs) {
        this.pkProductId = pkProductId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.imagePath = imagePath;
        this.devileryBy = devileryBy;
        this.isnew = isnew;
        this.isupcoming = isupcoming;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.category = category;
        this.carts = carts;
        this.orderLogs = orderLogs;
    }

    /** default constructor */
    public Product() {
    }

    /** minimal constructor */
    public Product(Long pkProductId, String productName, String description, Integer availableQuantity, String imagePath, String devileryBy, String isnew, String isupcoming, Long createdby, Date createddate, String isactive, com.VegetableShoppingCentre.pojo.Category category, Set carts, Set orderLogs) {
        this.pkProductId = pkProductId;
        this.productName = productName;
        this.description = description;
        this.availableQuantity = availableQuantity;
        this.imagePath = imagePath;
        this.devileryBy = devileryBy;
        this.isnew = isnew;
        this.isupcoming = isupcoming;
        this.createdby = createdby;
        this.createddate = createddate;
        this.isactive = isactive;
        this.category = category;
        this.carts = carts;
        this.orderLogs = orderLogs;
    }

    public Long getPkProductId() {
        return this.pkProductId;
    }

    public void setPkProductId(Long pkProductId) {
        this.pkProductId = pkProductId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailableQuantity() {
        return this.availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDevileryBy() {
        return this.devileryBy;
    }

    public void setDevileryBy(String devileryBy) {
        this.devileryBy = devileryBy;
    }

    public String getIsnew() {
        return this.isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getIsupcoming() {
        return this.isupcoming;
    }

    public void setIsupcoming(String isupcoming) {
        this.isupcoming = isupcoming;
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

    public Set getCarts() {
        return this.carts;
    }

    public void setCarts(Set carts) {
        this.carts = carts;
    }

    public Set getOrderLogs() {
        return this.orderLogs;
    }

    public void setOrderLogs(Set orderLogs) {
        this.orderLogs = orderLogs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkProductId", getPkProductId())
            .toString();
    }

}
