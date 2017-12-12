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

import com.founder.xc.atma.entity.White;
import com.founder.xc.atma.service.WhiteService;
import com.lee.util.ObjectUtils;
import com.lee.util.StringUtils;

/**
 * Description: Impl.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@Transactional
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class WhiteServiceImpl implements WhiteService {

    // CSOFF: MemberName
    /**
     * Hibernate 数据库操作管理器.
     **/
    @PersistenceContext(unitName = "atma_mgmt")
    private EntityManager em;
    // CSON: MemberName

    @Override
    public List<White> query(White condition, Integer start, Integer limit) {
        String hql = "from White as w";
        hql += makeQuery(null, condition);
        final Query query = em.createQuery(hql);
        query.setFirstResult(start).setMaxResults(limit);
        makeQuery(query, condition);
        //noinspection unchecked
        return query.getResultList();
    }

    @Override
    public int count(White condition) {
        String hql = "select count(w) from White as w";
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
     * @return hql of condition
     */
    private String makeQuery(Query query, White condition) {
        String hql = " where 1 = 1";
        if (!StringUtils.isEmpty(condition.getName())) {
            hql += " and w.name like :name";
        }
        if (!StringUtils.isEmpty(condition.getCid())) {
            hql += " and w.cid like :cid";
        }
        if (!StringUtils.isEmpty(condition.getNativePlace())) {
            hql += " and w.nativePlace like :nativePlace";
        }
        if (ObjectUtils.isEmpty(query)) {
            return hql;
        }
        if (!StringUtils.isEmpty(condition.getName())) {
            query.setParameter("name", "%" + condition.getName() + "%");
        }
        if (!StringUtils.isEmpty(condition.getCid())) {
            query.setParameter("cid", condition.getCid() + "%");
        }
        if (!StringUtils.isEmpty(condition.getNativePlace())) {
            query.setParameter("nativePlace", "%" + condition.getNativePlace() + "%");
        }
        return hql;
    }

    @Override
    public void create(White entity) {
        em.persist(entity);
    }

    @Override
    public void update(White entity) {
        em.merge(entity);
    }

    @Override
    public void remove(String id) {
        em.remove(em.find(White.class, id));
    }
}
