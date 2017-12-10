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
 * Description: 监控条件.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "ATMA_SETTINGS")
@SuppressWarnings("unused")
public class Setting implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "SET_ID")
    @GeneratedValue(generator = "atma_uuid")
    @GenericGenerator(name = "atma_uuid", strategy = "uuid2")
    private String id;

    /** See the DB. */
    @Column(name = "SET_CID_PREFIX")
    private String prefix;

    /** See the DB. */
    @Column(name = "SET_NATION")
    private String nation;

    /** See the DB. */
    @Column(name = "SET_AGE")
    private String age;

    /** See the DB. */
    @Column(name = "SET_SEX")
    private String sex;

    /** 是否启用，1启用，其他，禁用. */
    @Column(name = "IS_ENABLED")
    private Boolean isEnabled;

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
     * Get the prefix.
     *
     * @return return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Set prefix.
     *
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Get the nation.
     *
     * @return return the nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * Set nation.
     *
     * @param nation the nation to set
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * Get the age.
     *
     * @return return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * Set age.
     *
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Get the sex.
     *
     * @return return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set sex.
     *
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Get the isEnabled.
     *
     * @return return the isEnabled
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * Set isEnabled.
     *
     * @param isEnabled the isEnabled to set
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
