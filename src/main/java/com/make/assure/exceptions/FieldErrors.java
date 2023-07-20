package com.make.assure.exceptions;

public class FieldErrors {

	private String fieldName;
	private String message;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FieldErrors(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	

}
