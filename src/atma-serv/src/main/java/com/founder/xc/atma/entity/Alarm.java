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
 * Description: 报警信息.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "ATMA_ALARM")
@SuppressWarnings("unused")
public class Alarm implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "ALARM_ID")
    @GeneratedValue(generator = "atma_uuid")
    @GenericGenerator(name = "atma_uuid", strategy = "uuid2")
    private String id;

    /** Hotel ID.*/
    @Column(name = "HOTEL_ID")
    private String hotelId;

    /** See the DB. */
    @Column(name = "HOTEL_NAME")
    private String hotelName;

    /** See the DB. */
    @Column(name = "HOTEL_LEGAL")
    private String hotelLegal;

    /** See the DB. */
    @Column(name = "HOTEL_MANAGER")
    private String hotelManager;

    /** See the DB. */
    @Column(name = "HOTEL_CHARGER")
    private String hotelCharger;

    /** See the DB. */
    @Column(name = "HOTEL_ADD")
    private String hotelAdd;

    /** See the DB. */
    @Column(name = "HOTEL_MAIN_TEL")
    private String hotelMainTel;

    /** See the DB. */
    @Column(name = "HOTEL_CHARGER_TEL")
    private String hotelChargerTel;

    /** See the DB. */
    @Column(name = "HOTEL_STATION_ID")
    private String hotelStationId;

    /** See the DB. */
    @Column(name = "HOTEL_STATION_NAME")
    private String hotelStationName;

    /** See the DB. */
    @Column(name = "HOTEL_BUREAU_ID")
    private String hotelBureauId;

    /** See the DB. */
    @Column(name = "HOTEL_BUREAU_NAME")
    private String hotelBureauName;

    /** Rec ID.*/
    @Column(name = "REC_ID")
    private String recId;

    /** See the DB. */
    @Column(name = "REC_NAME")
    private String recName;

    /** See the DB. */
    @Column(name = "REC_SEX")
    private String recSex;

    /** See the DB. */
    @Column(name = "REC_NATION")
    private String recNation;

    /** See the DB. */
    @Column(name = "REC_BIRTHDAY")
    private String recBirthday;

    /** See the DB. */
    @Column(name = "REC_CID")
    private String recCid;

    /** See the DB. */
    @Column(name = "REC_AREA_CODE")
    private String recAreaCode;

    /** See the DB. */
    @Column(name = "REC_CHECK_IN_TIME")
    private String recCheckInTime;

    /** See the DB. */
    @Column(name = "REC_CHECK_OUT_TIME")
    private String recCheckOutTime;

    /** See the DB. */
    @Column(name = "REC_ROOM_NUM")
    private String recRoomNum;

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
     * Get the hotelId.
     *
     * @return return the hotelId
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * Set hotelId.
     *
     * @param hotelId the hotelId to set
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * Get the hotelName.
     *
     * @return return the hotelName
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Set hotelName.
     *
     * @param hotelName the hotelName to set
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Get the hotelLegal.
     *
     * @return return the hotelLegal
     */
    public String getHotelLegal() {
        return hotelLegal;
    }

    /**
     * Set hotelLegal.
     *
     * @param hotelLegal the hotelLegal to set
     */
    public void setHotelLegal(String hotelLegal) {
        this.hotelLegal = hotelLegal;
    }

    /**
     * Get the HotelManager.
     *
     * @return return the HotelManager
     */
    public String getHotelManager() {
        return hotelManager;
    }

    /**
     * Set HotelManager.
     *
     * @param HotelManager the HotelManager to set
     */
    public void setHotelManager(String HotelManager) {
        this.hotelManager = HotelManager;
    }

    /**
     * Get the HotelCharger.
     *
     * @return return the HotelCharger
     */
    public String getHotelCharger() {
        return hotelCharger;
    }

    /**
     * Set HotelCharger.
     *
     * @param HotelCharger the HotelCharger to set
     */
    public void setHotelCharger(String HotelCharger) {
        this.hotelCharger = HotelCharger;
    }

    /**
     * Get the HotelAdd.
     *
     * @return return the HotelAdd
     */
    public String getHotelAdd() {
        return hotelAdd;
    }

    /**
     * Set HotelAdd.
     *
     * @param HotelAdd the HotelAdd to set
     */
    public void setHotelAdd(String HotelAdd) {
        this.hotelAdd = HotelAdd;
    }

    /**
     * Get the HotelMainTel.
     *
     * @return return the HotelMainTel
     */
    public String getHotelMainTel() {
        return hotelMainTel;
    }

    /**
     * Set HotelMainTel.
     *
     * @param HotelMainTel the HotelMainTel to set
     */
    public void setHotelMainTel(String HotelMainTel) {
        this.hotelMainTel = HotelMainTel;
    }

    /**
     * Get the HotelChargerTel.
     *
     * @return return the HotelChargerTel
     */
    public String getHotelChargerTel() {
        return hotelChargerTel;
    }

    /**
     * Set HotelChargerTel.
     *
     * @param HotelChargerTel the HotelChargerTel to set
     */
    public void setHotelChargerTel(String HotelChargerTel) {
        this.hotelChargerTel = HotelChargerTel;
    }

    /**
     * Get the HotelStationId.
     *
     * @return return the HotelStationId
     */
    public String getHotelStationId() {
        return hotelStationId;
    }

    /**
     * Set HotelStationId.
     *
     * @param HotelStationId the HotelStationId to set
     */
    public void setHotelStationId(String HotelStationId) {
        this.hotelStationId = HotelStationId;
    }

    /**
     * Get the HotelStationName.
     *
     * @return return the HotelStationName
     */
    public String getHotelStationName() {
        return hotelStationName;
    }

    /**
     * Set HotelStationName.
     *
     * @param HotelStationName the HotelStationName to set
     */
    public void setHotelStationName(String HotelStationName) {
        this.hotelStationName = HotelStationName;
    }

    /**
     * Get the HotelBureauId.
     *
     * @return return the HotelBureauId
     */
    public String getHotelBureauId() {
        return hotelBureauId;
    }

    /**
     * Set HotelBureauId.
     *
     * @param HotelBureauId the HotelBureauId to set
     */
    public void setHotelBureauId(String HotelBureauId) {
        this.hotelBureauId = HotelBureauId;
    }

    /**
     * Get the HotelBureauName.
     *
     * @return return the HotelBureauName
     */
    public String getHotelBureauName() {
        return hotelBureauName;
    }

    /**
     * Set HotelBureauName.
     *
     * @param HotelBureauName the HotelBureauName to set
     */
    public void setHotelBureauName(String HotelBureauName) {
        this.hotelBureauName = HotelBureauName;
    }

    /**
     * Get the recId.
     *
     * @return return the recId
     */
    public String getRecId() {
        return recId;
    }

    /**
     * Set recId.
     *
     * @param recId the recId to set
     */
    public void setRecId(String recId) {
        this.recId = recId;
    }

    /**
     * Get the recName.
     *
     * @return return the recName
     */
    public String getRecName() {
        return recName;
    }

    /**
     * Set recName.
     *
     * @param recName the recName to set
     */
    public void setRecName(String recName) {
        this.recName = recName;
    }

    /**
     * Get the recSex.
     *
     * @return return the recSex
     */
    public String getRecSex() {
        return recSex;
    }

    /**
     * Set recSex.
     *
     * @param recSex the recSex to set
     */
    public void setRecSex(String recSex) {
        this.recSex = recSex;
    }

    /**
     * Get the recNation.
     *
     * @return return the recNation
     */
    public String getRecNation() {
        return recNation;
    }

    /**
     * Set recNation.
     *
     * @param recNation the recNation to set
     */
    public void setRecNation(String recNation) {
        this.recNation = recNation;
    }

    /**
     * Get the recBirthday.
     *
     * @return return the recBirthday
     */
    public String getRecBirthday() {
        return recBirthday;
    }

    /**
     * Set recBirthday.
     *
     * @param recBirthday the recBirthday to set
     */
    public void setRecBirthday(String recBirthday) {
        this.recBirthday = recBirthday;
    }

    /**
     * Get the recCid.
     *
     * @return return the recCid
     */
    public String getRecCid() {
        return recCid;
    }

    /**
     * Set recCid.
     *
     * @param recCid the recCid to set
     */
    public void setRecCid(String recCid) {
        this.recCid = recCid;
    }

    /**
     * Get the recAreaCode.
     *
     * @return return the recAreaCode
     */
    public String getRecAreaCode() {
        return recAreaCode;
    }

    /**
     * Set recAreaCode.
     *
     * @param recAreaCode the recAreaCode to set
     */
    public void setRecAreaCode(String recAreaCode) {
        this.recAreaCode = recAreaCode;
    }

    /**
     * Get the recCheckInTime.
     *
     * @return return the recCheckInTime
     */
    public String getRecCheckInTime() {
        return recCheckInTime;
    }

    /**
     * Set recCheckInTime.
     *
     * @param recCheckInTime the recCheckInTime to set
     */
    public void setRecCheckInTime(String recCheckInTime) {
        this.recCheckInTime = recCheckInTime;
    }

    /**
     * Get the recCheckOutTime.
     *
     * @return return the recCheckOutTime
     */
    public String getRecCheckOutTime() {
        return recCheckOutTime;
    }

    /**
     * Set recCheckOutTime.
     *
     * @param recCheckOutTime the recCheckOutTime to set
     */
    public void setRecCheckOutTime(String recCheckOutTime) {
        this.recCheckOutTime = recCheckOutTime;
    }

    /**
     * Get the recRoomNum.
     *
     * @return return the recRoomNum
     */
    public String getRecRoomNum() {
        return recRoomNum;
    }

    /**
     * Set recRoomNum.
     *
     * @param recRoomNum the recRoomNum to set
     */
    public void setRecRoomNum(String recRoomNum) {
        this.recRoomNum = recRoomNum;
    }
}
