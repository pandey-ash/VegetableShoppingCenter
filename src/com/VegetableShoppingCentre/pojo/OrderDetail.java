package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class OrderDetail implements Serializable {

    /** identifier field */
    private Long pkOrderDetail;

    /** persistent field */
    private Integer totalProduct;

    /** persistent field */
    private Long totalAmount;

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
    private com.VegetableShoppingCentre.pojo.UserInfo userInfo;

    /** persistent field */
    private com.VegetableShoppingCentre.pojo.Address address;

    /** persistent field */
    private Set orderLogs;

    /** full constructor */
    public OrderDetail(Long pkOrderDetail, Integer totalProduct, Long totalAmount, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.UserInfo userInfo, com.VegetableShoppingCentre.pojo.Address address, Set orderLogs) {
        this.pkOrderDetail = pkOrderDetail;
        this.totalProduct = totalProduct;
        this.totalAmount = totalAmount;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.userInfo = userInfo;
        this.address = address;
        this.orderLogs = orderLogs;
    }

    /** default constructor */
    public OrderDetail() {
    }

    /** minimal constructor */
    public OrderDetail(Long pkOrderDetail, Integer totalProduct, Long totalAmount, Long createdby, Date createddate, String isactive, com.VegetableShoppingCentre.pojo.UserInfo userInfo, com.VegetableShoppingCentre.pojo.Address address, Set orderLogs) {
        this.pkOrderDetail = pkOrderDetail;
        this.totalProduct = totalProduct;
        this.totalAmount = totalAmount;
        this.createdby = createdby;
        this.createddate = createddate;
        this.isactive = isactive;
        this.userInfo = userInfo;
        this.address = address;
        this.orderLogs = orderLogs;
    }

    public Long getPkOrderDetail() {
        return this.pkOrderDetail;
    }

    public void setPkOrderDetail(Long pkOrderDetail) {
        this.pkOrderDetail = pkOrderDetail;
    }

    public Integer getTotalProduct() {
        return this.totalProduct;
    }

    public void setTotalProduct(Integer totalProduct) {
        this.totalProduct = totalProduct;
    }

    public Long getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
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

    public com.VegetableShoppingCentre.pojo.UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(com.VegetableShoppingCentre.pojo.UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public com.VegetableShoppingCentre.pojo.Address getAddress() {
        return this.address;
    }

    public void setAddress(com.VegetableShoppingCentre.pojo.Address address) {
        this.address = address;
    }

    public Set getOrderLogs() {
        return this.orderLogs;
    }

    public void setOrderLogs(Set orderLogs) {
        this.orderLogs = orderLogs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkOrderDetail", getPkOrderDetail())
            .toString();
    }

}
