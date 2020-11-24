package br.com.codeitairlines.main;

import java.util.List;
import java.util.Optional;

import br.com.codeitairlines.dto.CriacaoEmpresaCodeItAirlines;
import br.com.codeitairlines.entities.EmpresaCodeItAirlines;
import br.com.codeitairlines.entities.SmartForTwo;
import br.com.codeitairlines.entities.Tripulante;

public class CodeItAirlinesApplication {

	public static void main(String[] args) throws Exception {

		try {
			EmpresaCodeItAirlines empresaCodeItAirlines = new CriacaoEmpresaCodeItAirlines().criarEmpresa();

			List<Tripulante> tripulacao = empresaCodeItAirlines.getTerminal().getTripulacao();

			Optional<Tripulante> piloto = tripulacao.stream().filter(t -> t.getEhPiloto()).findFirst();
			Optional<Tripulante> oficial = tripulacao.stream().filter(t -> t.getEhOficial()).findFirst();
			Optional<Tripulante> chefeServicoVoo = tripulacao.stream().filter(t -> t.getEhChefeServico()).findFirst();
			Optional<Tripulante> comissaria = tripulacao.stream().filter(t -> t.getEhComissaria()).findFirst();
			Optional<Tripulante> policial = tripulacao.stream().filter(t -> t.getEhPolicial()).findFirst();
			Optional<Tripulante> presidiario = tripulacao.stream().filter(t -> t.getEhPresidiario()).findFirst();

			SmartForTwo carro = new SmartForTwo(piloto, oficial);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(Optional.empty());
			carro.transportar(empresaCodeItAirlines.getAviao(), empresaCodeItAirlines.getTerminal());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setMotorista(chefeServicoVoo);
			carro.setPassageiro(comissaria);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(Optional.empty());
			carro.transportar(empresaCodeItAirlines.getAviao(), empresaCodeItAirlines.getTerminal());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(comissaria);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(Optional.empty());
			carro.transportar(empresaCodeItAirlines.getAviao(), empresaCodeItAirlines.getTerminal());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setMotorista(piloto);
			carro.setPassageiro(oficial);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(Optional.empty());
			carro.transportar(empresaCodeItAirlines.getAviao(), empresaCodeItAirlines.getTerminal());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(chefeServicoVoo);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(Optional.empty());
			carro.transportar(empresaCodeItAirlines.getAviao(), empresaCodeItAirlines.getTerminal());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setMotorista(policial);
			carro.setPassageiro(piloto);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(Optional.empty());
			carro.transportar(empresaCodeItAirlines.getAviao(), empresaCodeItAirlines.getTerminal());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			carro.setPassageiro(presidiario);
			carro.transportar(empresaCodeItAirlines.getTerminal(), empresaCodeItAirlines.getAviao());
			empresaCodeItAirlines.validarPoliticasEmpresa();

			System.out.println("Transporte realizado com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
