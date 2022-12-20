package com.cloudfly.start.bill.exception;

/**
 * @BelongsProject: pocket-bill
 * @BelongsPackage: com.cloudfly.start.bill.exception
 * @Author: wangyun
 * @CreateTime: 2022-12-09  17:25
 * @Description: TODO
 */
public class BillBusinessException extends RuntimeException {
    /**
     * 错误编码
     */
    private String code;
    public BillBusinessException() {
        super();
    }
    public BillBusinessException(String message) {
        super(message);
    }
    public BillBusinessException(String code, String message) {
        super(message);
        this.code = code;
    }
    public BillBusinessException(Throwable cause) {
        super(cause);
    }
    public BillBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public BillBusinessException(String message, Throwable cause,
                                 boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
    @Override
    public String toString() {
        return this.code + ":" + this.getMessage();
    }
}



