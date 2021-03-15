package br.com.sigo.authentication.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	Date Date;
	String Message;
	String Descricao;
	
	
	public ExceptionResponse(java.util.Date date, String message, String descricao) {
    	Date = date;
		Message = message;
		Descricao = descricao;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	
	
}
