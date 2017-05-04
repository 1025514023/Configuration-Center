package xzfm.common.boot.web;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by wangxizhong on 16/12/17.
 */
public class ResponseData<T> implements Serializable {
    private boolean success;
    private int code;
    private String message;
    private T data;
    private Timestamp rtime;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Timestamp getRtime() {
        return rtime;
    }

    public void setRtime(Timestamp rtime) {
        this.rtime = rtime;
    }

    public ResponseData(boolean success, int code, String message, T data, Timestamp timestamp) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.rtime = timestamp;
    }


    public static <T> ResponseData<T> ok(T date) {
        return new ResponseData<>(true, 200, "", date, new Timestamp(System.currentTimeMillis()));
    }

    public static ResponseData<String> error(int code, String message) {
        return new ResponseData<>(false, code, message, "", new Timestamp(System.currentTimeMillis()));
    }
}
