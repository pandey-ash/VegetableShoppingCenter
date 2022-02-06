package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cart implements Serializable {

    /** identifier field */
    private Long pkCartId;

    /** persistent field */
    private Integer quantity;

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
    private com.VegetableShoppingCentre.pojo.Product product;

    /** persistent field */
    private com.VegetableShoppingCentre.pojo.UserInfo userInfo;

    /** full constructor */
    public Cart(Long pkCartId, Integer quantity, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.Product product, com.VegetableShoppingCentre.pojo.UserInfo userInfo) {
        this.pkCartId = pkCartId;
        this.quantity = quantity;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.product = product;
        this.userInfo = userInfo;
    }

    /** default constructor */
    public Cart() {
    }

    /** minimal constructor */
    public Cart(Long pkCartId, Integer quantity, Long createdby, Date createddate, String isactive, com.VegetableShoppingCentre.pojo.Product product, com.VegetableShoppingCentre.pojo.UserInfo userInfo) {
        this.pkCartId = pkCartId;
        this.quantity = quantity;
        this.createdby = createdby;
        this.createddate = createddate;
        this.isactive = isactive;
        this.product = product;
        this.userInfo = userInfo;
    }

    public Long getPkCartId() {
        return this.pkCartId;
    }

    public void setPkCartId(Long pkCartId) {
        this.pkCartId = pkCartId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public com.VegetableShoppingCentre.pojo.Product getProduct() {
        return this.product;
    }

    public void setProduct(com.VegetableShoppingCentre.pojo.Product product) {
        this.product = product;
    }

    public com.VegetableShoppingCentre.pojo.UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(com.VegetableShoppingCentre.pojo.UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkCartId", getPkCartId())
            .toString();
    }

}
