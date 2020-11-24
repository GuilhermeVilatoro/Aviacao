package br.com.codeitairlines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class PontoReferencia implements Serializable {

	private static final long serialVersionUID = 1L;

	protected List<Tripulante> tripulacao = new ArrayList<>();

	public List<Tripulante> getTripulacao() {
		return tripulacao;
	}	

	protected void setTripulacao(Optional<Tripulante> tripulante) {
		if (tripulante.isEmpty())
			return;

		this.tripulacao.add(tripulante.get());
	}

	protected void removeTripulacao(Optional<Tripulante> tripulante) {
		if (tripulante.isEmpty())
			return;

		this.tripulacao.remove(tripulante.get());
	}

	public boolean getEhTerminal() {
		return false;
	}

	public boolean getEhAviao() {
		return false;
	}
}
