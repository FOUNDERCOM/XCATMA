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
 * Description: 短信接受者.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "ATMA_RECIEVER")
@SuppressWarnings("unused")
public class Reciever implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "REC_ID")
    @GeneratedValue(generator = "atma_uuid")
    @GenericGenerator(name = "atma_uuid", strategy = "uuid2")
    private String id;

    /** Name.*/
    @Column(name = "REC_NAME")
    private String name;

    /** Tel.*/
    @Column(name = "REC_TEL")
    private String tel;

    /** Org id..*/
    @Column(name = "ORG_ID")
    private String orgId;

    /** Org name. */
    @Column(name = "ORG_NAME")
    private String orgName;

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
     * Get the tel.
     *
     * @return return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set tel.
     *
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Get the orgId.
     *
     * @return return the orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * Set orgId.
     *
     * @param orgId the orgId to set
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * Get the orgName.
     *
     * @return return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Set orgName.
     *
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
