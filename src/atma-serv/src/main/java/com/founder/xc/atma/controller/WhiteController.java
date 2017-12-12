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

import com.founder.xc.atma.entity.Reciever;
import com.founder.xc.atma.entity.White;
import com.founder.xc.atma.service.RecieverService;
import com.founder.xc.atma.service.WhiteService;
import com.founder.xc.sys.dto.UserDTO;
import com.founder.xc.utils.ClientIPUtils;
import com.lee.jwaf.action.AbstractControllerSupport;
import com.lee.util.DateUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description: TODO.<br>
 * Created by Jimmybly Lee on 2017/12/12.
 *
 * @author Jimmybly Lee
 */
@Controller("WhiteController")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class WhiteController extends AbstractControllerSupport {

    /** Serv.*/
    @Resource
    private WhiteService service;

    /**
     * Query.
     */
    public void query() {
        final White condition = workDTO.convertJsonToBeanByKey("condition", White.class);
        workDTO.setResult(service.query(condition, workDTO.getStart(), workDTO.getLimit()));
        workDTO.setTotle(service.count(condition));
    }

    /**
     * Create.
     */
    public void create() {
        final White entity = prepareEntity();
        service.create(entity);
    }

    /**
     * Update.
     */
    public void update() {
        final White entity = prepareEntity();
        service.update(entity);
    }

    /**
     * Get entity.
     * @return entity
     */
    private White prepareEntity() {
        final White entity = workDTO.convertJsonToBeanByKey("entity", White.class);
        //noinspection CheckStyle
        entity.setLastUpdateUserId(((UserDTO)sessionDTO.currentToken().user()).getAccount());
        entity.setLastUpdateUserName(sessionDTO.currentToken().user().getName());
        entity.setLastUpdateDate(DateUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        entity.setLastUpdateIp(ClientIPUtils.getClientIp(servletRequest));
        return entity;
    }

    /**
     * Remove.
     */
    public void remove() {
        service.remove(workDTO.<String>get("id"));
    }
}
