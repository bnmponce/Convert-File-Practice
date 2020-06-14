/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.model.convert;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.model.convert.exception.ConvertException;
import com.jalasoft.practice.model.convert.parameter.ConvertFileParam;
import com.jalasoft.practice.model.result.Result;

public interface IConvert {
    Result convert(ConvertFileParam param) throws InvalidDataException, ConvertException;
}
