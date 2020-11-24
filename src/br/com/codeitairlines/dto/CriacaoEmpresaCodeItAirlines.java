package br.com.codeitairlines.dto;

import br.com.codeitairlines.entities.Aviao;
import br.com.codeitairlines.entities.ChefeServicoVoo;
import br.com.codeitairlines.entities.Comissaria;
import br.com.codeitairlines.entities.EmpresaCodeItAirlines;
import br.com.codeitairlines.entities.Oficial;
import br.com.codeitairlines.entities.Piloto;
import br.com.codeitairlines.entities.Policial;
import br.com.codeitairlines.entities.Presidiario;
import br.com.codeitairlines.entities.Terminal;
import br.com.codeitairlines.entities.TripulacaoCabine;
import br.com.codeitairlines.entities.TripulacaoTecnica;
import br.com.codeitairlines.entities.TripulacaoVoo;

public class CriacaoEmpresaCodeItAirlines {

	public EmpresaCodeItAirlines criarEmpresa() throws Exception {
		Piloto piloto = new Piloto();
		Oficial oficial = new Oficial();
		
		ChefeServicoVoo chefeServicoVoo = new ChefeServicoVoo();
		Comissaria comissaria = new Comissaria();
		
		Policial policial = new Policial();
		Presidiario presidiario = new Presidiario();

		TripulacaoTecnica tripulacaoTecnica = new TripulacaoTecnica(piloto, oficial, oficial);
		TripulacaoCabine tripulacaoCabine = new TripulacaoCabine(chefeServicoVoo, comissaria, comissaria);
		TripulacaoVoo tripulacaoVoo = new TripulacaoVoo(tripulacaoTecnica, tripulacaoCabine);

		Terminal terminal = new Terminal(tripulacaoVoo, policial, presidiario);
		Aviao aviao = new Aviao();
		return new EmpresaCodeItAirlines(tripulacaoVoo, terminal, aviao);
	}
}