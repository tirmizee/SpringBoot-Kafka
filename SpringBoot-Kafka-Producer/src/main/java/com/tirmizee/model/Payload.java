package com.tirmizee.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Payload implements Serializable {

	private static final long serialVersionUID = -3375622401995520342L;
	
	private Long id;
	private String message;
	private Inner inner;
	
	@Data
	public class Inner {
		private Long id;
		private String message;
	}

}
