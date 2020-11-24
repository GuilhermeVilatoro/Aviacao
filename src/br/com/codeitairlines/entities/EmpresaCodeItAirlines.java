package br.com.codeitairlines.entities;

import java.io.Serializable;

public final class EmpresaCodeItAirlines implements Serializable {

	private static final long serialVersionUID = 1L;

	private TripulacaoVoo tripulacaoVoo;
	private Terminal terminal;
	private Aviao aviao;

	public EmpresaCodeItAirlines(TripulacaoVoo tripulacaoVoo, Terminal terminal, Aviao aviao) throws Exception {
		if (tripulacaoVoo == null)
			throw new Exception("A empresa deverá ter pelo uma tripulação de vôo!");

		if (terminal == null)
			throw new Exception("A empresa deverá possuir um terminal de embarque!");

		if (aviao == null)
			throw new Exception("A empresa deverá ter um avião!");

		this.tripulacaoVoo = tripulacaoVoo;
		this.terminal = terminal;
		this.aviao = aviao;
	}

	public TripulacaoVoo getTripulacaoVoo() {
		return tripulacaoVoo;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public void validarPoliticasEmpresa() throws Exception {
		if (isRegraPilotoComissaria())
			throw new Exception("Regra Piloto e Comissária inválida!");

		if (isRegraChefeServicoOficial())
			throw new Exception("Regra Chefe e Oficial inválida!");

		if (isRegraPresidiario())
			throw new Exception("Regra Presidiário inválida!");
	}

	private boolean isRegraPilotoComissaria() {

		long qtdTripulantesTerminal = terminal.getTripulacao().stream()
				.filter(t -> t.getEhPiloto() || t.getEhComissaria()).count();

		long qtdPilotoComissariaAviao = aviao.getTripulacao().stream()
				.filter(t -> t.getEhPiloto() || t.getEhComissaria()).count();

		return ((terminal.getTripulacao().size() >= 2 && terminal.getTripulacao().size() == qtdTripulantesTerminal)
				|| (aviao.getTripulacao().size() >= 2 && aviao.getTripulacao().size() == qtdPilotoComissariaAviao));
	}

	private boolean isRegraChefeServicoOficial() {
		long qtdTripulantesTerminal = terminal.getTripulacao().stream()
				.filter(t -> t.getEhChefeServico() || t.getEhOficial()).count();

		long qtdPilotoComissariaAviao = aviao.getTripulacao().stream()
				.filter(t -> t.getEhChefeServico() || t.getEhOficial()).count();

		return ((terminal.getTripulacao().size() >= 2 && terminal.getTripulacao().size() == qtdTripulantesTerminal)
				|| (aviao.getTripulacao().size() >= 2 && aviao.getTripulacao().size() == qtdPilotoComissariaAviao));
	}

	private boolean isRegraPresidiario() {
		boolean temPresidiarioSemPolicialTerminal = terminal.getTripulacao().stream().anyMatch(
				t -> t.getEhPresidiario()) && terminal.getTripulacao().stream().noneMatch(t -> t.getEhPolicial());

		boolean temPresidiarioSemPolicialAviao = aviao.getTripulacao().stream().anyMatch(t -> t.getEhPresidiario())
				&& aviao.getTripulacao().stream().noneMatch(t -> t.getEhPolicial());

		return ((terminal.getTripulacao().size() >= 2 && temPresidiarioSemPolicialTerminal)
				|| (aviao.getTripulacao().size() >= 2 && temPresidiarioSemPolicialAviao));
	}
}