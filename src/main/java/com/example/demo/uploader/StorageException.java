package com.example.demo.uploader;


public class StorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9179823448872845475L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
