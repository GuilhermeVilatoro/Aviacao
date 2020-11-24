package br.com.codeitairlines.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.codeitairlines.dto.CriacaoEmpresaCodeItAirlines;

public class EmpresaCodeItAirlinesTests {

	private SmartForTwo carro;

	private EmpresaCodeItAirlines empresa;

	List<Tripulante> tripulacao = new ArrayList<>();

	Optional<Tripulante> piloto;
	Optional<Tripulante> oficial;
	Optional<Tripulante> chefeServicoVoo;
	Optional<Tripulante> comissaria;
	Optional<Tripulante> policial;
	Optional<Tripulante> presidiario;

	@Before
	public void setUp() throws Exception {
		empresa = new CriacaoEmpresaCodeItAirlines().criarEmpresa();

		tripulacao = empresa.getTerminal().getTripulacao();

		piloto = tripulacao.stream().filter(t -> t.getEhPiloto()).findFirst();
		oficial = tripulacao.stream().filter(t -> t.getEhOficial()).findFirst();
		chefeServicoVoo = tripulacao.stream().filter(t -> t.getEhChefeServico()).findFirst();
		comissaria = tripulacao.stream().filter(t -> t.getEhComissaria()).findFirst();
		policial = tripulacao.stream().filter(t -> t.getEhPolicial()).findFirst();		

		carro = new SmartForTwo(piloto, oficial);
	}

	@Test
	public void testDeveLancarExcecaoAoVerificarARegraPresidiarioSemPolicial() {
		try {
			carro.setPassageiro(policial);
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
			empresa.validarPoliticasEmpresa();
		} catch (Exception e) {
			assertEquals("Regra Presidiário inválida!", e.getMessage());
		}
	}
	
	@Test
	public void testDeveLancarExcecaoAoVerificarARegraChefeServicoVooSozinhoComOficiais() {
		try {
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
			carro.setPassageiro(chefeServicoVoo);
			carro.transportar(empresa.getAviao(), empresa.getTerminal());
			empresa.validarPoliticasEmpresa();
		} catch (Exception e) {
			assertEquals("Regra Chefe e Oficial inválida!", e.getMessage());
		}
	}
	
	@Test
	public void testDeveLancarExcecaoAoVerificarARegraPilotoSozinhoComComissarias() {
		try {
			carro.setMotorista(chefeServicoVoo);
			carro.setPassageiro(comissaria);
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
			carro.setPassageiro(Optional.empty());
			carro.transportar(empresa.getAviao(), empresa.getTerminal());
			empresa.validarPoliticasEmpresa();
		} catch (Exception e) {
			assertEquals("Regra Piloto e Comissária inválida!", e.getMessage());
		}
	}	

	@After
	public void tearDown() throws Exception {
	}
}