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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.xc.atma.entity.Alarm;
import com.founder.xc.atma.service.AlarmService;
import com.lee.util.ObjectUtils;
import com.lee.util.StringUtils;

/**
 * Description: 报警实现.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Transactional
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class AlarmServiceImpl implements AlarmService {

    // CSOFF: MemberName
    /**
     * Hibernate 数据库操作管理器.
     **/
    @PersistenceContext(unitName = "atma_mgmt")
    private EntityManager em;
    // CSON: MemberName

    @Override
    public List<Alarm> query(Alarm condition, Integer start, Integer limit) {
        String hql = " from Alarm as a";
        hql += makeQuery(null, condition);
        final Query query = em.createQuery(hql);
        query.setFirstResult(start).setMaxResults(limit);
        makeQuery(query, condition);
        //noinspection unchecked
        return query.getResultList();
    }

    @Override
    public int count(Alarm condition) {
        String hql = " select count(a) from Alarm as a";
        hql += makeQuery(null, condition);
        final Query query = em.createQuery(hql);
        makeQuery(query, condition);
        return ((Number) query.getSingleResult()).intValue();
    }

    /**
     * Make query.
     *
     * @param query     query
     * @param condition condition
     * @return hql by condition
     */
    @SuppressWarnings("CheckStyle")
    private String makeQuery(Query query, Alarm condition) {
        String hql = "where 1 = 1";
        if (!StringUtils.isEmpty(condition.getHotelName())) {
            hql += " and a.hotelName like :hotelName";
        }
        if (!StringUtils.isEmpty(condition.getHotelStationId())) {
            hql += " and a.hotelStationId = :hotelStationId";
        }
        if (!StringUtils.isEmpty(condition.getHotelBureauId())) {
            hql += " and a.hotelBureauid = :hotelBureauId";
        }
        if (!StringUtils.isEmpty(condition.getRecName())) {
            hql += " and a.recName like :recName";
        }
        if (!StringUtils.isEmpty(condition.getRecSex())) {
            hql += " and a.recSex = :recSex";
        }
        if (!StringUtils.isEmpty(condition.getRecNation())) {
            hql += " and a.recNation = :recNation";
        }
        if (!StringUtils.isEmpty(condition.getRecCid())) {
            hql += " and a.recCid like :recCid";
        }
        if (!StringUtils.isEmpty(condition.getRecRoomNum())) {
            hql += " and a.recRoomNum = :recRoomNum";
        }
        if (ObjectUtils.isEmpty(query)) {
            return hql;
        }

        if (!StringUtils.isEmpty(condition.getHotelName())) {
            query.setParameter("hotelName", "%" + condition.getHotelName() + "%");
        }
        if (!StringUtils.isEmpty(condition.getHotelStationId())) {
            query.setParameter("hotelStationId", condition.getHotelStationId());
        }
        if (!StringUtils.isEmpty(condition.getHotelBureauId())) {
            query.setParameter("hotelBureauid", condition.getHotelBureauId());
        }
        if (!StringUtils.isEmpty(condition.getRecName())) {
            query.setParameter("recName", condition.getRecName());
        }
        if (!StringUtils.isEmpty(condition.getRecSex())) {
            query.setParameter("recSex", condition.getRecSex());
        }
        if (!StringUtils.isEmpty(condition.getRecNation())) {
            query.setParameter("recNation", condition.getRecNation());
        }
        if (!StringUtils.isEmpty(condition.getRecCid())) {
            query.setParameter("recCid", condition.getRecCid());
        }
        if (!StringUtils.isEmpty(condition.getRecRoomNum())) {
            query.setParameter("recRoomNum", condition.getRecRoomNum());
        }
        return hql;
    }

    @Override
    public void create(Alarm entity) {
        em.persist(entity);
    }

    @Override
    public void update(Alarm entity) {
        em.merge(entity);
    }
}
