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

package com.founder.xc.atma.controller;

import com.founder.xc.atma.entity.Alarm;
import com.founder.xc.atma.entity.Reciever;
import com.founder.xc.atma.service.AlarmService;
import com.lee.jwaf.action.AbstractControllerSupport;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Description: TODO.<br>
 * Created by Jimmybly Lee on 2017/12/12.
 *
 * @author Jimmybly Lee
 */
@Controller("AlarmController")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class AlarmController extends AbstractControllerSupport {

    @Resource
    private AlarmService service;

    public void query() {
        final Alarm condition = workDTO.convertJsonToBeanByKey("condition", Alarm.class);
        workDTO.setResult(service.query(condition, workDTO.getStart(), workDTO.getLimit()));
        workDTO.setTotle(service.count(condition));
    }

    public void create() {
        service.create(workDTO.<String>get("id"));
    }
}
