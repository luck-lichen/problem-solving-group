package com.threeclear.pollution.config;
    
    
import com.baomidou.mybatisplus.extension.api.IErrorCode;
public enum MyErrorCode implements IErrorCode {
	/*
	* 在这里添加自定义的错误响应码
	* */
	DEFAULT_FAILED(-1,"失败"),
	MYTEST_NUll(-2,"参数不能为空"),
	MYTEST_DATEFALL(-3,"日期格式错误 示例: 2021-01-01")
	;
	private final long code;
	private final String msg;

	MyErrorCode(long code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public long getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return String.format(" ErrorCode:{code=%s, msg=%s} ", code, msg);
	}
}
