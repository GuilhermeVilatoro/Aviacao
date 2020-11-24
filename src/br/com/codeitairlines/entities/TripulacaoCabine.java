package br.com.codeitairlines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TripulacaoCabine implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Tripulante> tripulacao = new ArrayList<>();

	public TripulacaoCabine(ChefeServicoVoo chefeServicoVoo, Comissaria primeiraComissaria,
			Comissaria segundaComissaria) throws Exception {
		if (chefeServicoVoo == null)
			throw new Exception("A tripula��o t�cnica deve ter um chefe de servi�o de v�o!");

		if (primeiraComissaria == null || segundaComissaria == null)
			throw new Exception("A tripula��o de cabine deve ter duas comiss�rias!");

		tripulacao.addAll(Arrays.asList(chefeServicoVoo, primeiraComissaria, segundaComissaria));
	}

	public List<Tripulante> getTripulacao() {
		return tripulacao;
	}
}