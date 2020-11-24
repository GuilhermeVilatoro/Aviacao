package br.com.codeitairlines.entities;

import java.io.Serializable;

public final class Oficial extends Tripulante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean getEhOficial() {
		return true;
	}
}