package br.com.codeitairlines.entities;

import java.io.Serializable;

public final class Aviao extends PontoReferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Aviao() {

	}	

	@Override
	public boolean getEhAviao() {
		return true;
	}
}