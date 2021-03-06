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

package com.founder.xc.sys.service;

import com.lee.jwaf.token.FuncTree;
import com.lee.jwaf.token.Token;

import java.util.List;

/**
 * Description: 权限服务.<br>
 * Created by Jimmybly Lee on 2017/9/28.
 *
 * @author Jimmybly Lee
 */
@SuppressWarnings("unused")
public interface AuthService {

    /**
     * 校验账号和密码.
     * @param account 账号
     * @param pwd 密码
     * @return user id 获得 空（如果找不到）
     */
    String checkAccountAndPwd(String account, String pwd);

    /**
     * 根据给定的用户ID返回用户令牌.
     * @param userId 用户id
     * @return 用户令牌
     */
    Token getTokenByUserId(String userId);
}
