package gongjun.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用来定制响应信息
 */
@Getter
@Setter
@ToString
public class ResponseResult {
    //定义异常，返回给前端的状态码是200，前端可以通过success字段判断是否显示正确的业务数据还是错误码+错误信息
    private boolean success;
    private String code;
    private String message;
    private Object data;

    private ResponseResult(){}

    /**
     * 正常返回业务数据
     * @param data
     * @return
     */
    public static ResponseResult ok(Object data){
        ResponseResult result = new ResponseResult();
        result.success = true;
        result.data = data;
        return result;
    }

    //出现异常时，返回的数据
    public static ResponseResult error(){
        return error("ERR000000", "未知错误,请联系管理员");
    }

    public static ResponseResult error(String code, String message){
        ResponseResult result = new ResponseResult();
        result.code = code;
        result.message = message;
        return result;
    }
}
