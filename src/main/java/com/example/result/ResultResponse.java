package com.example.result;

    /* *
        * 响应结果返回封装
     * */
public class ResultResponse {


        // 只返回状态
        public static Result success() {
            return new Result()
                    .setResult(ResultCode.SUCCESS);
        }

        // 成功返回数据
        public static Result success(Object data) {
            return new Result()
                    .setResult(ResultCode.SUCCESS, data);


        }

        // 失败
        public static Result failure(ResultCode resultCode) {
            return new Result()
                    .setResult(resultCode);
        }

        // 失败
        public static Result failure(ResultCode resultCode, Object data) {
            return new Result()
                    .setResult(resultCode, data);
        }

        //参数无效
        public static Result paramInvalid(Object data){
            return new Result()
                    .setResult(ResultCode.PARAMS_IS_INVALID, data);
        }




    }
