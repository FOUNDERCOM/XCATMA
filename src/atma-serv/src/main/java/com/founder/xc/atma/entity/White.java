/* ***************************************************************************
 * EZ.JWAF/EZ.JCWAP: Easy series Production.
 * Including JWAF(Java-based Web Application Framework)
 * and JCWAP(Java-based Customized Web Application Platform).
 * Copyright (C) 2016-2017 the original author or authors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of MIT License as published by
 * the Free Software Foundation;
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the MIT License for more details.
 *
 * You should have received a copy of the MIT License along
 * with this library; if not, write to the Free Software Foundation.
 * ***************************************************************************/

package com.founder.xc.atma.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Description: 白名单.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "ATMA_WHITE_LIST")
@SuppressWarnings("unused")
public class White implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(generator = "atma_uuid")
    @GenericGenerator(name = "atma_uuid", strategy = "uuid2")
    private String id;

    /** Name. */
    @Column(name = "PERSON_NAME")
    private String name;

    /** CID. */
    @Column(name = "PERSON_CID")
    private String cid;

    /** Native Place. */
    @Column(name = "PERSON_NATIVE_PLACE")
    private String nativePlace;

    /** 最近更新人ID. */
    @Column(name = "LATEST_UPDATE_USER_ID")
    private String lastUpdateUserId;
    /** 最近更新人名称. */
    @Column(name = "LATEST_UPDATE_USER_NAME")
    private String lastUpdateUserName;
    /** 最近更新时间. */
    @Column(name = "LATEST_UPDATE_DATE")
    private String lastUpdateDate;
    /** 最近更新IP. */
    @Column(name = "LATEST_UPDATE_IP")
    private String lastUpdateIp;

    /**
     * Get the id.
     *
     * @return return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Set id.
     *
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name.
     *
     * @return return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the cid.
     *
     * @return return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * Set cid.
     *
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * Get the nativePlace.
     *
     * @return return the nativePlace
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * Set nativePlace.
     *
     * @param nativePlace the nativePlace to set
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * Get the lastUpdateUserId.
     *
     * @return return the lastUpdateUserId
     */
    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    /**
     * Set lastUpdateUserId.
     *
     * @param lastUpdateUserId the lastUpdateUserId to set
     */
    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    /**
     * Get the lastUpdateUserName.
     *
     * @return return the lastUpdateUserName
     */
    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    /**
     * Set lastUpdateUserName.
     *
     * @param lastUpdateUserName the lastUpdateUserName to set
     */
    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

    /**
     * Get the lastUpdateDate.
     *
     * @return return the lastUpdateDate
     */
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Set lastUpdateDate.
     *
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get the lastUpdateIp.
     *
     * @return return the lastUpdateIp
     */
    public String getLastUpdateIp() {
        return lastUpdateIp;
    }

    /**
     * Set lastUpdateIp.
     *
     * @param lastUpdateIp the lastUpdateIp to set
     */
    public void setLastUpdateIp(String lastUpdateIp) {
        this.lastUpdateIp = lastUpdateIp;
    }
}
