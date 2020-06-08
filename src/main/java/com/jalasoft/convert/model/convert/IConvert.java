/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.model.convert;

import com.jalasoft.convert.model.convert.exception.ConvertException;
import com.jalasoft.convert.model.convert.exception.ParameterInvalidException;
import com.jalasoft.convert.model.convert.parameter.ConvertParam;
import com.jalasoft.convert.model.result.Result;

public interface IConvert {
    Result convert(ConvertParam param) throws ParameterInvalidException, ConvertException;
}
