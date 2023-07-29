package com.example.result;

import lombok.Getter;

/**
     * 响应码枚举，对应HTTP状态码
     */
    @Getter
    public enum ResultCode {

        SUCCESS(200, "成功"),//成功
        BAD_REQUEST(400, "失败"),
        UNAUTHORIZED(401, "认证失败"),//未认证
        NOT_FOUND(404, "接口不存在"),//接口不存在
        INTERNAL_SERVER_ERROR(500, "服务器内部错误"),//服务器内部错误
        METHOD_NOT_ALLOWED(405,"方法不被允许"),
        ILLEGAL_HEADER(406,"请求头无效"),
        REPLAY_ERROR(410,"请求重复"),
        /*参数错误:1001-1999*/
        PARAMS_IS_INVALID(1001, "参数无效"),
        PARAMS_IS_BLANK(1002, "参数为空");
        /*用户错误2001-2999*/

        private Integer code;
        private String message;

        ResultCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
}
