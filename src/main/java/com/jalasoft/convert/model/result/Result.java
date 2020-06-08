/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.model.result;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class Result {
    private String pathResult;

    public Result(String pathResult) {
        this.pathResult = pathResult;
    }

    public String getPathResult() {
        return pathResult;
    }

    public void setPathResult(String pathResult) {
        this.pathResult = pathResult;
    }
}
