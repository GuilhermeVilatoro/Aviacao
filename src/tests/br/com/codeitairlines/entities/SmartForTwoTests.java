package br.com.codeitairlines.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.codeitairlines.dto.CriacaoEmpresaCodeItAirlines;

public class SmartForTwoTests {

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
		presidiario = tripulacao.stream().filter(t -> t.getEhPresidiario()).findFirst();

		carro = new SmartForTwo(piloto, oficial);
	}

	@Test
	public void testDeveLancarExcecaoAoTranportarSemInformarOrigemEDestino() {
		try {
			carro.transportar(null, null);
		} catch (Exception e) {
			assertEquals("Para realizar o transporte deverá ser informado a origem e o destino!", e.getMessage());
		}
	}

	@Test
	public void testDeveLancarExcecaoAoTranportarMesmaOrigemEDestino() {
		try {
			carro.transportar(empresa.getTerminal(), empresa.getTerminal());
		} catch (Exception e) {
			assertEquals("Os pontos de referência da origem e destino devem ser diferentes!", e.getMessage());
		}
	}

	@Test
	public void testDeveLancarExcecaoAoTranportarComUmMotoristaInvalido() {
		try {
			carro.setMotorista(comissaria);
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
		} catch (Exception e) {
			assertEquals("Não foi informado um motorista válido!", e.getMessage());
		}
	}

	@Test
	public void testDeveLancarExcecaoAoTranportarChefeServicoVooComOficial() {
		try {
			carro.setMotorista(chefeServicoVoo);
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
		} catch (Exception e) {
			assertEquals("Não podem ser transportados juntos chefe e oficial!", e.getMessage());
		}
	}

	@Test
	public void testDeveLancarExcecaoAoTranportarPilotoComComissaria() {
		try {
			carro.setPassageiro(comissaria);
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
		} catch (Exception e) {
			assertEquals("Não podem ser transportados juntos piloto e comissária!", e.getMessage());
		}
	}

	@Test
	public void testDeveLancarExcecaoAoTranportarPresidiarioSemPolicial() {
		try {
			carro.setPassageiro(presidiario);
			carro.transportar(empresa.getTerminal(), empresa.getAviao());
		} catch (Exception e) {
			assertEquals("Não pode ser transportado o presidiário sem o policial!", e.getMessage());
		}
	}

	@Test
	public void testDeveRealizarOTranporteEntrePilotoEOficial() throws Exception {
		carro.transportar(empresa.getTerminal(), empresa.getAviao());

		assertTrue(empresa.getTerminal().getTripulacao().size() == 6);
		assertTrue(empresa.getAviao().getTripulacao().size() == 2);
	}

	@After
	public void tearDown() throws Exception {
	}

}