package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class OrderLog implements Serializable {

    /** identifier field */
    private Long pkOrderLogId;

    /** persistent field */
    private Integer productQuantity;

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
    private com.VegetableShoppingCentre.pojo.OrderDetail orderDetail;

    /** full constructor */
    public OrderLog(Long pkOrderLogId, Integer productQuantity, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.Product product, com.VegetableShoppingCentre.pojo.OrderDetail orderDetail) {
        this.pkOrderLogId = pkOrderLogId;
        this.productQuantity = productQuantity;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.product = product;
        this.orderDetail = orderDetail;
    }

    /** default constructor */
    public OrderLog() {
    }

    /** minimal constructor */
    public OrderLog(Long pkOrderLogId, Integer productQuantity, Long createdby, Date createddate, String isactive, com.VegetableShoppingCentre.pojo.Product product, com.VegetableShoppingCentre.pojo.OrderDetail orderDetail) {
        this.pkOrderLogId = pkOrderLogId;
        this.productQuantity = productQuantity;
        this.createdby = createdby;
        this.createddate = createddate;
        this.isactive = isactive;
        this.product = product;
        this.orderDetail = orderDetail;
    }

    public Long getPkOrderLogId() {
        return this.pkOrderLogId;
    }

    public void setPkOrderLogId(Long pkOrderLogId) {
        this.pkOrderLogId = pkOrderLogId;
    }

    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
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

    public com.VegetableShoppingCentre.pojo.OrderDetail getOrderDetail() {
        return this.orderDetail;
    }

    public void setOrderDetail(com.VegetableShoppingCentre.pojo.OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkOrderLogId", getPkOrderLogId())
            .toString();
    }

}
