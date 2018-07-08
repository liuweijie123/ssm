package com.lwj.exception;

public class CustomException extends Exception {
		/**
	 * 
	 */
	private static final long serialVersionUID = 5406155299990575999L;
		//异常信息
		private String message;
		
		public CustomException(String message){
			super(message);
			this.message=message;
		}
	 
	 
		public String getMessage() {
			return message;
		}
	 
	 
		public void setMessage(String message) {
			this.message = message;
		}


}
