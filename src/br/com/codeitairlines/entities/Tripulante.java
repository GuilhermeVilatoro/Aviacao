package br.com.codeitairlines.entities;

import java.io.Serializable;

public abstract class Tripulante implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean getEhMotorista() {
		return false;
	}

	public boolean getEhComissaria() {
		return false;
	}

	public boolean getEhChefeServico() {
		return false;
	}

	public boolean getEhPiloto() {
		return false;
	}

	public boolean getEhOficial() {
		return false;
	}

	public boolean getEhPolicial() {
		return false;
	}

	public boolean getEhPresidiario() {
		return false;
	}
}