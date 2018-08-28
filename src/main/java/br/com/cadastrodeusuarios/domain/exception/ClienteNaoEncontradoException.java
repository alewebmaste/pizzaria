package br.com.cadastrodeusuarios.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontradoException(String msg) {
		super(msg);
	}

}
