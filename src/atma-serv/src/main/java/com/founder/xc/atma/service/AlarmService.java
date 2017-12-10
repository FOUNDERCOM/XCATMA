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

package com.founder.xc.atma.service;

import java.util.List;

import com.founder.xc.atma.entity.Alarm;

/**
 * Description: 报警服务.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
public interface AlarmService {

    /**
     * Query.
     * @param condition condition
     * @param start start
     * @param limit limit
     * @return list
     */
    List<Alarm> query(Alarm condition, Integer start, Integer limit);

    /**
     * Count.
     * @param condition condition
     * @return count
     */
    int count(Alarm condition);

    /**
     * Create
     * @param entity entity
     */
    void create(Alarm entity);

    /**
     * Update.
     * @param entity entity
     */
    void update(Alarm entity);
}
