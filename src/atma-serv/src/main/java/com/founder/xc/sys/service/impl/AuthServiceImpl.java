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

import com.easymap.management.api.OrganizationManager;
import com.easymap.management.api.UserManager;
import com.easymap.management.entity.Function;
import com.easymap.management.newapi.FunctionManager;
import com.easymap.management.user.User;
import com.founder.xc.sys.dto.AtmaToken;
import com.founder.xc.sys.dto.FuncDTO;
import com.founder.xc.sys.service.AuthService;
import com.lee.jwaf.token.FuncTree;
import com.lee.jwaf.token.Token;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 权限服务.<br>
 * Created by Jimmybly Lee on 2017/9/28.
 *
 * @author Jimmybly Lee
 */
public class AuthServiceImpl implements AuthService {
    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 6718746124995812410L;

    /**
     * User Mgmt.
     */
    @Resource(name = "userMgmt")
    private UserManager userMgmt;

    /** Org Mgmt. */
    @Resource(name = "orgMgmt")
    private OrganizationManager orgMgmt;

    /** Func Mgmt. */
    @Resource(name = "funcMgmt")
    private FunctionManager funcMgmt;

    @Override
    public String checkAccountAndPwd(String account, String pwd) {
        //noinspection CheckStyle
        try {
            return userMgmt.validUser(account, pwd) ? account : null;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Token getTokenByUserId(String userId) {
        final AtmaToken token = new AtmaToken();
        //noinspection CheckStyle
        try {
            final User userByServ = userMgmt.getUser(userId);

            token.org().setCode(userByServ.getOrgId());
            token.org().setName(orgMgmt.findOrganizationById(userByServ.getOrgId()).getName());

            token.user().setAccount(userId);
            token.user().setName(userByServ.getName());
            token.user().setOrg(token.org());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final List<FuncTree> funcList = new LinkedList<>();
        //noinspection CheckStyle
        try {
            final List<Function> list = funcMgmt.getFunctionByUserId(userId);
            for (Function f : list) {
                final FuncDTO func = new FuncDTO();
                func.setId(Integer.parseInt(f.getCode()));
                func.setName(f.getName());
                func.setCode(f.getUrl());
                funcList.add(func);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // function list
        token.funcs().addAll(funcList);
        return token;
    }
}
