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

package com.founder.xc.atma.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easymap.management.api.OrganizationManager;
import com.easymap.management.unit.Organization;
import com.founder.xc.atma.entity.Alarm;
import com.founder.xc.atma.entity.Message;
import com.founder.xc.atma.entity.Reciever;
import com.founder.xc.atma.service.MsgService;
import com.lee.util.DateUtils;
import com.lee.util.ObjectUtils;
import com.lee.util.StringUtils;

/**
 * Description: 短信服务.<br>
 * Created by Jimmybly Lee on 2017/12/11.
 *
 * @author Jimmybly Lee
 */
@Transactional
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class MsgServiceImpl implements MsgService {

    // CSOFF: MemberName
    /**
     * Hibernate 数据库操作管理器.
     **/
    @PersistenceContext(unitName = "atma_mgmt")
    private EntityManager em;
    // CSON: MemberName

    /**
     * Org service.
     */
    @Resource(name = "orgMgmt")
    private OrganizationManager orgMgmt;

    @Override
    public void createMsg(Alarm alarm) {
        // 获得组织机构并递归处理

    }

    /**
     * 创建短信，存储并发送，递归处理上级部门.
     * @param orgId orgId
     * @param alarm alarm
     */
    private void makeMsg(String orgId, Alarm alarm) {
        if (!StringUtils.isEmpty(orgId)) {
            //noinspection CheckStyle
            try {
                final Organization org = orgMgmt.findOrganizationById(orgId);
                //noinspection unchecked
                final List<Reciever> recrs = em.createQuery("from Reciever as r where r.orgId = :orgId")
                    .setParameter("orgId", org.getId()).getResultList();

                for (Reciever recr : recrs) {
                    final Message msg = new Message();
                    msg.setIsSendOut(true);
                    msg.setContext(makeMsgContext(recr, alarm));
                    msg.setToId(recr.getId());
                    msg.setToName(recr.getName());
                    msg.setToNumber(recr.getTel());
                    msg.setDate(DateUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
                    msg.setAlarm(alarm);
                    em.persist(msg);

                    sendMsg(msg);
                }

                // find parent
                //noinspection CheckStyle
                try {
                    final Organization parent = orgMgmt.findOrganizationById(org.getSsjgdm());
                    if (!ObjectUtils.isEmpty(parent)) {
                        makeMsg(parent.getId(), alarm);
                    }
                } catch (Exception e) {
                    //找不到上级
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Send msg.
     * @param msg msg
     */
    private void sendMsg(Message msg) {

    }

    /**
     * Make msg context.
     * @param recr reciever
     * @param alarm alarm
     * @return context
     */
    private String makeMsgContext(Reciever recr, Alarm alarm) {
        //noinspection StringBufferReplaceableByString
        final StringBuilder msg = new StringBuilder();
        msg.append(recr.getName()).append(" 您好，");
        msg.append("在").append(alarm.getRecCheckInTime()).append("，");
        msg.append("一名为").append(alarm.getRecName()).append("的");
        msg.append("新疆籍");
        msg.append("1".equalsIgnoreCase(alarm.getRecSex()) ? "男子" : "女子");
        msg.append("在").append(alarm.getHotelAdd()).append("的").append(alarm.getRecRoomNum()).append("房间办理了入住");
        return msg.toString();
    }
}
