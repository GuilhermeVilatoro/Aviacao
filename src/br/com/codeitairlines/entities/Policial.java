package br.com.codeitairlines.entities;

import java.io.Serializable;

public final class Policial extends Tripulante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean getEhPolicial() {		
		return true;
	}

	@Override
	public boolean getEhMotorista() {
		return true;
	}
}