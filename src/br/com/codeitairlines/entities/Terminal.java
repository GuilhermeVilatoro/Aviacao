package br.com.codeitairlines.entities;

import java.io.Serializable;
import java.util.Arrays;

public final class Terminal extends PontoReferencia implements Serializable {

	private static final long serialVersionUID = 1L;

	public Terminal(TripulacaoVoo tripulacaoVoo, Policial policial, Presidiario presidiario) throws Exception {
		if (tripulacaoVoo == null)
			throw new Exception("A tripulaçao de vôo deve estar no terminal de embarque!");

		if (policial == null)
			throw new Exception("Deve existir um policial no terminal de embarque!");

		tripulacao.addAll(tripulacaoVoo.getTripulacaoVoo());
		tripulacao.addAll(Arrays.asList(policial, presidiario));
	}	

	@Override
	public boolean getEhTerminal() {
		return true;
	}
}