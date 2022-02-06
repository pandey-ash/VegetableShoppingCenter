package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class UserInfo implements Serializable {

    /** identifier field */
    private Long pkUserId;

    /** persistent field */
    private String firstname;

    /** persistent field */
    private String lastname;

    /** persistent field */
    private String email;

    /** persistent field */
    private String password;

    /** persistent field */
    private String gender;

    /** persistent field */
    private Long mobileNo;

    /** persistent field */
    private String isadmin;

    /** persistent field */
    private Long createdby;

    /** persistent field */
    private Date createddate;

    /** nullable persistent field */
    private Long modifiedby;

    /** nullable persistent field */
    private Date modifieddate;

    /** nullable persistent field */
    private String isactive;

    /** nullable persistent field */
    private String ef1;

    /** nullable persistent field */
    private String ef2;

    /** persistent field */
    private Set orderDetails;

    /** persistent field */
    private Set addresses;

    /** persistent field */
    private Set carts;

    /** full constructor */
    public UserInfo(Long pkUserId, String firstname, String lastname, String email, String password, String gender, Long mobileNo, String isadmin, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, Set orderDetails, Set addresses, Set carts) {
        this.pkUserId = pkUserId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.isadmin = isadmin;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.orderDetails = orderDetails;
        this.addresses = addresses;
        this.carts = carts;
    }

    /** default constructor */
    public UserInfo() {
    }

    /** minimal constructor */
    public UserInfo(Long pkUserId, String firstname, String lastname, String email, String password, String gender, Long mobileNo, String isadmin, Long createdby, Date createddate, Set orderDetails, Set addresses, Set carts) {
        this.pkUserId = pkUserId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.isadmin = isadmin;
        this.createdby = createdby;
        this.createddate = createddate;
        this.orderDetails = orderDetails;
        this.addresses = addresses;
        this.carts = carts;
    }

    public Long getPkUserId() {
        return this.pkUserId;
    }

    public void setPkUserId(Long pkUserId) {
        this.pkUserId = pkUserId;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getIsadmin() {
        return this.isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
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

    public Set getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set addresses) {
        this.addresses = addresses;
    }

    public Set getCarts() {
        return this.carts;
    }

    public void setCarts(Set carts) {
        this.carts = carts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkUserId", getPkUserId())
            .toString();
    }

}
