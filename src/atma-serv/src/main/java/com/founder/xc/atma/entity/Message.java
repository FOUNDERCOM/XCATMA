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
 * Description: 短信记录.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Entity
@Table(name = "ATMA_MSG")
@SuppressWarnings("unused")
public class Message implements Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** ID.*/
    @Id
    @Column(name = "MSG_ID")
    @GeneratedValue(generator = "atma_uuid")
    @GenericGenerator(name = "atma_uuid", strategy = "uuid2")
    private String id;

    /** See the DB. */
    @Column(name = "MSG_TYPE")
    private Boolean isSendOut;

    /** See the DB. */
    @Column(name = "MSG_CONTEXT")
    private String context;

    /** See the DB. */
    @Column(name = "MSG_FROM_ID")
    private String fromId;

    /** See the DB. */
    @Column(name = "MSG_FROM_NUMBER")
    private String fromNumber;

    /** See the DB. */
    @Column(name = "MSG_FROM_NAME")
    private String fromName;

    /** See the DB. */
    @Column(name = "MSG_TO_ID")
    private String toNumber;

    /** See the DB. */
    @Column(name = "MSG_TO_NUMBER")
    private String toId;

    /** See the DB. */
    @Column(name = "MSG_TO_NAME")
    private String toName;

    /** See the DB. */
    @Column(name = "MSG_DATE")
    private String date;

    /** See the DB. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALARM_ID")
    private Alarm alarm;

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
     * Get the isSendOut.
     *
     * @return return the isSendOut
     */
    public Boolean getIsSendOut() {
        return isSendOut;
    }

    /**
     * Set isSendOut.
     *
     * @param isSendOut the isSendOut to set
     */
    public void setIsSendOut(Boolean isSendOut) {
        this.isSendOut = isSendOut;
    }

    /**
     * Get the context.
     *
     * @return return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * Set context.
     *
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * Get the fromId.
     *
     * @return return the fromId
     */
    public String getFromId() {
        return fromId;
    }

    /**
     * Set fromId.
     *
     * @param fromId the fromId to set
     */
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    /**
     * Get the fromNumber.
     *
     * @return return the fromNumber
     */
    public String getFromNumber() {
        return fromNumber;
    }

    /**
     * Set fromNumber.
     *
     * @param fromNumber the fromNumber to set
     */
    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }

    /**
     * Get the fromName.
     *
     * @return return the fromName
     */
    public String getFromName() {
        return fromName;
    }

    /**
     * Set fromName.
     *
     * @param fromName the fromName to set
     */
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    /**
     * Get the toNumber.
     *
     * @return return the toNumber
     */
    public String getToNumber() {
        return toNumber;
    }

    /**
     * Set toNumber.
     *
     * @param toNumber the toNumber to set
     */
    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    /**
     * Get the toId.
     *
     * @return return the toId
     */
    public String getToId() {
        return toId;
    }

    /**
     * Set toId.
     *
     * @param toId the toId to set
     */
    public void setToId(String toId) {
        this.toId = toId;
    }

    /**
     * Get the toName.
     *
     * @return return the toName
     */
    public String getToName() {
        return toName;
    }

    /**
     * Set toName.
     *
     * @param toName the toName to set
     */
    public void setToName(String toName) {
        this.toName = toName;
    }

    /**
     * Get the date.
     *
     * @return return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set date.
     *
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the alarm.
     *
     * @return return the alarm
     */
    public Alarm getAlarm() {
        return alarm;
    }

    /**
     * Set alarm.
     *
     * @param alarm the alarm to set
     */
    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }
}
