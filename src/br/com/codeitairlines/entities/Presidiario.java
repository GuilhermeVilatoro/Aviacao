package br.com.codeitairlines.entities;

import java.io.Serializable;

public final class Presidiario extends Tripulante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean getEhPresidiario() {
		return true;
	}
}