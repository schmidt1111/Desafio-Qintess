package com.qintess.ingressosonline.exception;

public class IngressoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IngressoException(String msg, Throwable ex) {
       super(msg, ex);		
	}
	
	public IngressoException(String msg) {
	       super(msg);		
	}

}
