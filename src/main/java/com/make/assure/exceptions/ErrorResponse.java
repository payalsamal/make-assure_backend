package com.make.assure.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {


	private String errorCode;
	private String errorMsg;
	private String funcCode;
	private String funcDesc;
	private String errorID;
	private List<FieldErrors> errors;

	public ErrorResponse(String errorCode, String errorMsg, String errorID) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorID = errorID;
	}
	public ErrorResponse(String localizedMessage) {

	}
	public ErrorResponse(String errorCode, String errorMsg, String funcCode, String funcDesc, String errorID) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.funcCode = funcCode;
		this.funcDesc = funcDesc;
		this.errorID = errorID;
	}
	

}
