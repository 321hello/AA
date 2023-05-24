package com.mydev.mystu.jee4exam.conf;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LayerPageVO<T> implements Serializable {
	private Long count;
	private Integer code;
	private String msg;
	private List<T> data;

	private final static String SUCCESS_RES = "操作成功";

	private final static Integer SUCCESS_CODE = 200;

	public LayerPageVO(Integer code, Long count, String msg, List<T> data) {
		this.code = SUCCESS_CODE;
		this.count = count;
		this.msg = msg;
		this.data = data;
	}
	public LayerPageVO( List<T> data,Long count) {
		this.code = 0;
		this.count = count;
		this.msg = SUCCESS_RES;
		this.data = data;
	}
}
