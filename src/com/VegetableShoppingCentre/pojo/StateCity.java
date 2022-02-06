package com.VegetableShoppingCentre.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class StateCity implements Serializable {

    /** identifier field */
    private Long pkStateCity;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String city;

    /** nullable persistent field */
    private Long createdby;

    /** nullable persistent field */
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
    private com.VegetableShoppingCentre.pojo.StateCity stateCity;

    /** persistent field */
    private Set stateCities;

    /** persistent field */
    private Set addresses;

    /** full constructor */
    public StateCity(Long pkStateCity, String state, String city, Long createdby, Date createddate, Long modifiedby, Date modifieddate, String isactive, String ef1, String ef2, com.VegetableShoppingCentre.pojo.StateCity stateCity, Set stateCities, Set addresses) {
        this.pkStateCity = pkStateCity;
        this.state = state;
        this.city = city;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
        this.isactive = isactive;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.stateCity = stateCity;
        this.stateCities = stateCities;
        this.addresses = addresses;
    }

    /** default constructor */
    public StateCity() {
    }

    /** minimal constructor */
    public StateCity(Long pkStateCity, com.VegetableShoppingCentre.pojo.StateCity stateCity, Set stateCities, Set addresses) {
        this.pkStateCity = pkStateCity;
        this.stateCity = stateCity;
        this.stateCities = stateCities;
        this.addresses = addresses;
    }

    public Long getPkStateCity() {
        return this.pkStateCity;
    }

    public void setPkStateCity(Long pkStateCity) {
        this.pkStateCity = pkStateCity;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public com.VegetableShoppingCentre.pojo.StateCity getStateCity() {
        return this.stateCity;
    }

    public void setStateCity(com.VegetableShoppingCentre.pojo.StateCity stateCity) {
        this.stateCity = stateCity;
    }

    public Set getStateCities() {
        return this.stateCities;
    }

    public void setStateCities(Set stateCities) {
        this.stateCities = stateCities;
    }

    public Set getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set addresses) {
        this.addresses = addresses;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkStateCity", getPkStateCity())
            .toString();
    }

}
