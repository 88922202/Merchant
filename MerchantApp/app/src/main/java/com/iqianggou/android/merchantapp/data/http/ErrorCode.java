package com.iqianggou.android.merchantapp.data.http;

/**
 * Created by ubuntu on 16-9-20.
 */
public class ErrorCode {

    public static final int NO_NETWORK = -1;

    public static final int NO_METHOD = 0;

    public static final int SERVER_ERROR = 1;

    public static final int PARSE_ERROR = 2;

    public static final int CONNECT_ERROR = 3;

    public static final int AUTHORIZATION_ERROR = 4;

    //客户端自定义错误
    public static final int APP_JSON_PARSE_ERROR = 100;

    //http 标准错误码
    public static final int TIMEOUT = 408;

    //服务端自定义
    public static final int CODE_SUCCESS = 10000;

    public static final int CODE_RESULT_EMPTY = 10001;

    public static final int CODE_SUCCESS_LARGEST = 10099;

    public static final int CODE_AUTH_OVERDUE = 20004;

    public static final int CODE_COUPON_REJECT = 80001;
}
