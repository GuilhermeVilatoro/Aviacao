package br.com.codeitairlines.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class TripulacaoVoo implements Serializable {

	private static final long serialVersionUID = 1L;

	private TripulacaoTecnica tripulacaoTecnica;
	private TripulacaoCabine tripulacaoCabine;
	
	private List<Tripulante> tripulacaoVoo = new ArrayList<>();

	public TripulacaoVoo(TripulacaoTecnica tripulacaoTecnica, TripulacaoCabine tripulacaoCabine) throws Exception {
		if (tripulacaoTecnica == null)
			throw new Exception("O vôo deverá ter uma tripulação técnica!");

		if (tripulacaoCabine == null)
			throw new Exception("O vôo deverá ter uma tripulação de cabine!");

		this.tripulacaoTecnica = tripulacaoTecnica;
		this.tripulacaoCabine = tripulacaoCabine;
		
		tripulacaoVoo.addAll(tripulacaoTecnica.getTripulacao());
		tripulacaoVoo.addAll(tripulacaoCabine.getTripulacao());		
	}

	public TripulacaoTecnica getTripulacaoTecnica() {
		return tripulacaoTecnica;
	}

	public TripulacaoCabine getTripulacaoCabine() {
		return tripulacaoCabine;
	}
	
	public List<Tripulante> getTripulacaoVoo(){
		return tripulacaoVoo; 
	}
}