package cn.tedu.service.impl;

public class EmptyNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9103532718949646847L;

	public EmptyNameException() {
		super();
	}

	public EmptyNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyNameException(String message) {
		super(message);
	}

	public EmptyNameException(Throwable cause) {
		super(cause);
	}

}
