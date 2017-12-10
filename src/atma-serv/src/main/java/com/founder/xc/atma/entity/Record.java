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
 * Description: 记录.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "LY_CGUESTER")
@SuppressWarnings("unused")
public class Record implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "DJ_LVKEDAIMA")
    private String id;

    /** See the DB. */
    @Column(name = "DJ_XINGMING")
    private String name;

    /** See the DB. */
    @Column(name = "DJ_XINGBIE")
    private String sex;

    /** See the DB. */
    @Column(name = "DJ_MINZU")
    private String nation;

    /** See the DB. */
    @Column(name = "DJ_CHUSHENGRIQI")
    private String birthday;

    /** See the DB. */
    @Column(name = "DJ_ZHENGJIANHAOMA")
    private String cid;

    /** See the DB. */
    @Column(name = "DJ_SHENGSHIXIAN")
    private String areaCode;

    /** See the DB. */
    @Column(name = "DJ_RUZHUSHIJIAN")
    private String checkInTime;

    /** See the DB. */
    @Column(name = "DJ_TUIFANGSHIJIAN")
    private String checkOutTime;

    /** See the DB. */
    @Column(name = "DJ_RUZHUFANGHAO")
    private String roomNum;

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
     * Get the birthday.
     *
     * @return return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Set birthday.
     *
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
     * Get the areaCode.
     *
     * @return return the areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Set areaCode.
     *
     * @param areaCode the areaCode to set
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Get the checkInTime.
     *
     * @return return the checkInTime
     */
    public String getCheckInTime() {
        return checkInTime;
    }

    /**
     * Set checkInTime.
     *
     * @param checkInTime the checkInTime to set
     */
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * Get the checkOutTime.
     *
     * @return return the checkOutTime
     */
    public String getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * Set checkOutTime.
     *
     * @param checkOutTime the checkOutTime to set
     */
    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    /**
     * Get the roomNum.
     *
     * @return return the roomNum
     */
    public String getRoomNum() {
        return roomNum;
    }

    /**
     * Set roomNum.
     *
     * @param roomNum the roomNum to set
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
