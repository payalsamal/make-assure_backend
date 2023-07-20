package com.make.assure.exceptions;

import lombok.Data;

@Data
public class BusinessException extends BaseException {

	private static final long serialVersionUID = -8667174472090058466L;

	private final String funcCode;
	private final String funcDesc;

	private final String errorCode;
	private final String errorMsg;

	public BusinessException(String message) {
		super(message, new Throwable(message));
		funcCode =funcDesc=errorCode=errorMsg="";
	}

	public BusinessException(Throwable cause) {
		super(cause);
		funcCode =funcDesc=errorCode=errorMsg="";

	}

	public BusinessException(String errorCode, String errorMsg, Throwable cause) {
		super(errorMsg, cause);
		funcCode =funcDesc="";
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
	}

	public BusinessException(String errorCode, String errorMsg, String funcCode, String funcDesc, Throwable cause) {
		super(funcDesc, cause);
		this.funcCode = funcCode;
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
		this.funcDesc=funcDesc;
	}


}
