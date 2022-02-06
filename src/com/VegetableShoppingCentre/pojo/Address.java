package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Address implements Serializable {

    /** identifier field */
    private Long pkAddressId;

    /** persistent field */
    private String address1;

    /** persistent field */
    private String landmark;

    /** persistent field */
    private Long pincode;

    /** persistent field */
    private Long billerMobileNo;

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
    private com.VegetableShoppingCentre.pojo.StateCity stateCity;

    /** persistent field */
    private Set orderDetails;

    /** full constructor */
    public Address(Long pkAddressId, String address1, String landmark, Long pincode, Long billerMobileNo, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.UserInfo userInfo, com.VegetableShoppingCentre.pojo.StateCity stateCity, Set orderDetails) {
        this.pkAddressId = pkAddressId;
        this.address1 = address1;
        this.landmark = landmark;
        this.pincode = pincode;
        this.billerMobileNo = billerMobileNo;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.userInfo = userInfo;
        this.stateCity = stateCity;
        this.orderDetails = orderDetails;
    }

    /** default constructor */
    public Address() {
    }

    /** minimal constructor */
    public Address(Long pkAddressId, String address1, String landmark, Long pincode, Long billerMobileNo, Long createdby, Date createddate, String isactive, com.VegetableShoppingCentre.pojo.UserInfo userInfo, com.VegetableShoppingCentre.pojo.StateCity stateCity, Set orderDetails) {
        this.pkAddressId = pkAddressId;
        this.address1 = address1;
        this.landmark = landmark;
        this.pincode = pincode;
        this.billerMobileNo = billerMobileNo;
        this.createdby = createdby;
        this.createddate = createddate;
        this.isactive = isactive;
        this.userInfo = userInfo;
        this.stateCity = stateCity;
        this.orderDetails = orderDetails;
    }

    public Long getPkAddressId() {
        return this.pkAddressId;
    }

    public void setPkAddressId(Long pkAddressId) {
        this.pkAddressId = pkAddressId;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLandmark() {
        return this.landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Long getPincode() {
        return this.pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public Long getBillerMobileNo() {
        return this.billerMobileNo;
    }

    public void setBillerMobileNo(Long billerMobileNo) {
        this.billerMobileNo = billerMobileNo;
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

    public com.VegetableShoppingCentre.pojo.StateCity getStateCity() {
        return this.stateCity;
    }

    public void setStateCity(com.VegetableShoppingCentre.pojo.StateCity stateCity) {
        this.stateCity = stateCity;
    }

    public Set getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkAddressId", getPkAddressId())
            .toString();
    }

}
