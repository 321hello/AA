package com.mydev.mystu.jee4exam.conf;


/**
 * 应用异常编码
 *
 * @author
 * @since
 */
public class ExceptionCode {

    public static final Integer REQUEST_SUCCESS_CODE = 200;

    public static final Integer REQUEST_ERROR_CODE = -1; //请求错误，客户端对服务器返回的消息进行提示

    /**
     * request 相关
     */
    public static final CodeMessage PARAM_NULL = new CodeMessage(1, "参数为空");
    public static final CodeMessage PARAM_ILLEGAL = new CodeMessage(2, "参数非法");
    public static final CodeMessage DATA_NOT_FOUND = new CodeMessage(3, "数据不存在");


    /**
     * session, code 相关
     */

    public static final CodeMessage REMOTE_CALL_FAILURE = new CodeMessage(91, "第三方接口调用失败");
    public static final CodeMessage INTERFACE_USE_FAILURE = new CodeMessage(92, "接口调用失败");


    public static final CodeMessage UNKNOWN_ERROR = new CodeMessage(999, "系统异常");

    public static final CodeMessage PROGRAM_CLOSED = new CodeMessage(31, "该功能尚未开放");

    public static final CodeMessage NO_ENOUGH_INFO = new CodeMessage(-1, "暂未找到更多%s,添加更多个人信息试试。");

}