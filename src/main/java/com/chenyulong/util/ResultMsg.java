package com.chenyulong.util;

public class ResultMsg<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> ResultMsg<T> success(T data) {
        return new ResultMsg<>(data);
    }

    public static <T> ResultMsg<T> error(CodeMsg codeMsg) {
        return new ResultMsg<>(codeMsg);
    }

    private ResultMsg (T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private ResultMsg (CodeMsg codeMsg) {
        if (codeMsg==null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
