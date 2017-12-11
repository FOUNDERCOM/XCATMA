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

package com.founder.xc.sys.dto;

import com.lee.jwaf.token.Org;

import java.io.Serializable;

/**
 * Description: Org.<br>
 * Created by Jimmybly Lee on 2017/12/10.
 *
 * @author Jimmybly Lee
 */
@SuppressWarnings("unused")
public class OrgDTO implements Org, Serializable {

    private static final long serialVersionUID = 2494748680229395013L;

    /** Name. */
    private String name;
    /** Code. */
    private String code;

    /**
     * Get the id.
     *
     * @return return the id
     */
    @Override
    @Deprecated
    public Integer getId() {
        return null;
    }

    /**
     * Set id.
     *
     * @param id the id to set
     */
    @Override
    @Deprecated
    public void setId(Integer id) {
    }

    /**
     * Get the name.
     *
     * @return return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the code.
     *
     * @return return the code
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * Set code.
     *
     * @param code the code to set
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }
}
