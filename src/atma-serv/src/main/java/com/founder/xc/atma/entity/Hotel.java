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

/**
 * Description: Hotel.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "LY_HOTEL")
@SuppressWarnings("unused")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "H_LVGUANDAIMA")
    private String id;

    /** See the DB. */
    @Column(name = "H_LVGUANMINGCHENG")
    private String name;

    /** See the DB. */
    @Column(name = "H_FARENMINGCHENG")
    private String legal;

    /** See the DB. */
    @Column(name = "H_LVGUANZONGJINGLI")
    private String manager;

    /** See the DB. */
    @Column(name = "H_LVGUANZHIANZERENREN")
    private String charger;

    /** See the DB. */
    @Column(name = "H_XIANGZHI")
    private String add;

    /** See the DB. */
    @Column(name = "H_LVGUANLIANXIDIANHUA")
    private String mainTel;

    /** See the DB. */
    @Column(name = "H_BAOANBUDIANHUA")
    private String chargerTel;

    /** See the DB. */
    @Column(name = "H_PAICHUSUOBM")
    private String stationId;

    /** See the DB. */
    @Column(name = "H_PAICHUSUO")
    private String stationName;

    /** See the DB. */
    @Column(name = "H_FENXIANJUDAIMA")
    private String bureauId;

    /** See the DB. */
    @Column(name = "H_FENXIANJU")
    private String bureauName;

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
     * Get the legal.
     *
     * @return return the legal
     */
    public String getLegal() {
        return legal;
    }

    /**
     * Set legal.
     *
     * @param legal the legal to set
     */
    public void setLegal(String legal) {
        this.legal = legal;
    }

    /**
     * Get the manager.
     *
     * @return return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Set manager.
     *
     * @param manager the manager to set
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Get the charger.
     *
     * @return return the charger
     */
    public String getCharger() {
        return charger;
    }

    /**
     * Set charger.
     *
     * @param charger the charger to set
     */
    public void setCharger(String charger) {
        this.charger = charger;
    }

    /**
     * Get the add.
     *
     * @return return the add
     */
    public String getAdd() {
        return add;
    }

    /**
     * Set add.
     *
     * @param add the add to set
     */
    public void setAdd(String add) {
        this.add = add;
    }

    /**
     * Get the mainTel.
     *
     * @return return the mainTel
     */
    public String getMainTel() {
        return mainTel;
    }

    /**
     * Set mainTel.
     *
     * @param mainTel the mainTel to set
     */
    public void setMainTel(String mainTel) {
        this.mainTel = mainTel;
    }

    /**
     * Get the chargerTel.
     *
     * @return return the chargerTel
     */
    public String getChargerTel() {
        return chargerTel;
    }

    /**
     * Set chargerTel.
     *
     * @param chargerTel the chargerTel to set
     */
    public void setChargerTel(String chargerTel) {
        this.chargerTel = chargerTel;
    }

    /**
     * Get the stationId.
     *
     * @return return the stationId
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * Set stationId.
     *
     * @param stationId the stationId to set
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * Get the stationName.
     *
     * @return return the stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Set stationName.
     *
     * @param stationName the stationName to set
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * Get the bureauId.
     *
     * @return return the bureauId
     */
    public String getBureauId() {
        return bureauId;
    }

    /**
     * Set bureauId.
     *
     * @param bureauId the bureauId to set
     */
    public void setBureauId(String bureauId) {
        this.bureauId = bureauId;
    }

    /**
     * Get the bureauName.
     *
     * @return return the bureauName
     */
    public String getBureauName() {
        return bureauName;
    }

    /**
     * Set bureauName.
     *
     * @param bureauName the bureauName to set
     */
    public void setBureauName(String bureauName) {
        this.bureauName = bureauName;
    }
}
