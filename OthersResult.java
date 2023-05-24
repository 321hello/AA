package com.mydev.mystu.jee4exam.conf;


import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

@Data
public class OthersResult<T> implements Serializable {

//    private CodeMessage meta;
    private Integer code;
    private String message;
    private T data;

    private final static String SUCCESS_RES = "操作成功";

    private final static Integer SUCCESS_CODE = 200;

    public OthersResult(T data) {
        this(SUCCESS_CODE, SUCCESS_RES, data);
    }

    public OthersResult(Integer code, String message) {
        this(code, message, null);
    }

    public OthersResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> OthersResult<T> success(T data) {
        return new OthersResult<>(data);
    }

    public static <T> OthersResult<T> fail(Integer code, String message, T data) {
        return new OthersResult<>(code, message, data);
    }

    public static <T> OthersResult<T> fail(CodeMessage codeMessage) {
        return new OthersResult<>(codeMessage.getCode(), codeMessage.getMessage());
    }

    public static <T> OthersResult<T> fail(Integer code, String message) {
        return new OthersResult<>(code, message);
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * 可以详细显示对象的各个属性值
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}