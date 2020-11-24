package br.com.codeitairlines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TripulacaoTecnica implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Tripulante> tripulacao = new ArrayList<>();

	public TripulacaoTecnica(Piloto piloto, Oficial primeiroOficial, Oficial segundoOficial) throws Exception {
		if (piloto == null)
			throw new Exception("A tripulação técnica deve ter um piloto!");

		if (primeiroOficial == null || segundoOficial == null)
			throw new Exception("A tripulação técnica deve ter dois oficiais!");

		tripulacao.addAll(Arrays.asList(piloto, primeiroOficial, segundoOficial));
	}

	public List<Tripulante> getTripulacao() {
		return tripulacao;
	}
}