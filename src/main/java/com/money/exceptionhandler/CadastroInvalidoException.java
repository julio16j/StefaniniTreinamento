package com.money.exceptionhandler;

public class CadastroInvalidoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroInvalidoException(String erro) {
		super("erro");
	}

}
