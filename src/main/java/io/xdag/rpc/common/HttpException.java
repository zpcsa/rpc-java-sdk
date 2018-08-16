package io.xdag.rpc.common;

import java.io.IOException;

import io.xdag.rpc.http.Response;

/**
 * SDK异常封装类，封装了http响应数据
 */
public final class HttpException extends IOException {
	private static final long serialVersionUID = 1L;
	public final Response response;
    private String error;


    public HttpException(Response response) {
        super(response != null ? response.getInfo() : null);
        this.response = response;
    }

    public HttpException(Exception e) {
        this(e, null);
    }

    public HttpException(Exception e, String msg) {
        super(msg, e);
        this.response = null;
        this.error = msg;
    }

    public String url() {
        return response.url();
    }

    public int code() {
        return response == null ? -1 : response.statusCode;
    }

    public String error() {
        if (error != null) {
            return error;
        }
        if (response == null || response.statusCode / 100 == 2 || !response.isJson()) {
            return null;
        }
        Error e = null;
        try {
            e = response.jsonToObject(Error.class);
        } catch (HttpException e1) {
            e1.printStackTrace();
        }
        error = e == null ? "" : e.getMessage();
        return error;
    }
}
