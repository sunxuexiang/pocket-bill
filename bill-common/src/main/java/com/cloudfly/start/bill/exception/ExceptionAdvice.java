package com.cloudfly.start.bill.exception;

import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: pocket-bill
 * @BelongsPackage: com.cloudfly.start.bill.utils
 * @Author: wangyun
 * @CreateTime: 2022-12-09  17:23
 * @Description: TODO
 */
@RestController
@ControllerAdvice
public class ExceptionAdvice {



    public static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(BillSystemException.class)
    public R handleException(Exception e) {
        logger.error(ExceptionUtils.getStackTrace(e));
        return R.error("系统执行异常："+e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public R handleException(RuntimeException e) {
        logger.error(ExceptionUtils.getStackTrace(e));
        return R.error("系统运行异常："+e.getMessage());
    }

    @ExceptionHandler(BillBusinessException.class)
    @ResponseBody
    public R doBusinessException(Exception e) {
        logger.error(ExceptionUtils.getStackTrace(e));
        return R.error("系统业务异常："+e.getMessage());
    }
}


