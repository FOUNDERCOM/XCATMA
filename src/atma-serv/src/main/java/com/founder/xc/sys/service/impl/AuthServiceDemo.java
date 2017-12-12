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

import com.founder.xc.sys.dto.AtmaToken;
import com.founder.xc.sys.dto.FuncDTO;
import com.founder.xc.sys.service.AuthService;
import com.lee.jwaf.token.Token;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class AuthServiceDemo implements AuthService {
    @Override
    public String checkAccountAndPwd(String account, String pwd) {
        return account;
    }

    @Override
    public Token getTokenByUserId(String userId) {
        AtmaToken token = new AtmaToken();
        token.user().setAccount("xxx");
        token.user().setName("测试用户");
        token.org().setCode("123");
        token.org().setName("测试部门");
        token.user().setOrg(token.org());

        FuncDTO func = new FuncDTO();
        func.setCode("msg-receive");
        token.funcs().add(func);

        func = new FuncDTO();
        func.setCode("white");
        token.funcs().add(func);

        func = new FuncDTO();
        func.setCode("log");
        token.funcs().add(func);

        func = new FuncDTO();
        func.setCode("alarm");
        token.funcs().add(func);

        func = new FuncDTO();
        func.setCode("alarm-view");
        token.funcs().add(func);

        func = new FuncDTO();
        func.setCode("alarm-edit");
        token.funcs().add(func);
        return token;
    }
}
