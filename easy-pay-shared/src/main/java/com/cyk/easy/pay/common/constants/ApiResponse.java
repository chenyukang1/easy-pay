package com.cyk.easy.pay.common.constants;


/**
 * @author yukang.chen
 */
public class ApiResponse<T> {

    private int code;

    private String message;

    private T data;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setMessage("success");
        apiResponse.setData(data);
        return apiResponse;
    }

    public static <T> ApiResponse<T> fail(String msg) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(500);
        apiResponse.setMessage(msg);
        return apiResponse;
    }

    public boolean isSuccess() {
        return this.code == 200;
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
}
