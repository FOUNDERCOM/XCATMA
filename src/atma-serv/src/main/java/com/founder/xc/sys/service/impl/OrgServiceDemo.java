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

package com.founder.xc.sys.service.impl;

import com.founder.xc.sys.dto.OrgDTO;
import com.founder.xc.sys.service.OrgService;
import com.lee.jwaf.token.Org;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: TODO.<br>
 * Created by Jimmybly Lee on 2017/12/12.
 *
 * @author Jimmybly Lee
 */
@Transactional
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SuppressWarnings("unused")
public class OrgServiceDemo implements OrgService {
    @Override
    public List<Org> query(String name) {
        List<Org> result = new LinkedList<>();

        Org org = new OrgDTO();
        org.setCode("a");
        org.setName("AAA");
        result.add(org);

        org = new OrgDTO();
        org.setCode("b");
        org.setName("BBB");
        result.add(org);

        org = new OrgDTO();
        org.setCode("c");
        org.setName("CCC");
        result.add(org);

        org = new OrgDTO();
        org.setCode("d");
        org.setName("DDD");
        result.add(org);

        return result;
    }
}
