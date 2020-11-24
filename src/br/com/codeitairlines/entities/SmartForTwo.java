package br.com.codeitairlines.entities;

import java.io.Serializable;
import java.util.Optional;

public class SmartForTwo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Optional<Tripulante> motorista;
	private Optional<Tripulante> passageiro;

	public SmartForTwo(Optional<Tripulante> motorista, Optional<Tripulante> passageiro) throws Exception {
		this.setMotorista(motorista);
		this.setPassageiro(passageiro);
	}

	public Optional<Tripulante> getMotorista() {
		return motorista;
	}

	public void setMotorista(Optional<Tripulante> motorista) throws Exception {
		this.motorista = motorista;		
	}

	public Optional<Tripulante> getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Optional<Tripulante> passageiro) throws Exception {
		this.passageiro = passageiro;		
	}

	public void transportar(PontoReferencia origem, PontoReferencia destino) throws Exception {
		validarRegrasSmartForTwo(origem, destino);

		origem.removeTripulacao(this.getMotorista());
		origem.removeTripulacao(this.getPassageiro());

		destino.setTripulacao(this.getMotorista());
		destino.setTripulacao(this.getPassageiro());
	}

	private void validarRegrasSmartForTwo(PontoReferencia origem, PontoReferencia destino) throws Exception {
		if (origem == null || destino == null)
			throw new Exception("Para realizar o transporte deverá ser informado a origem e o destino!");

		if ((origem.getEhTerminal() && destino.getEhTerminal()) || (origem.getEhAviao() && destino.getEhAviao()))
			throw new Exception("Os pontos de referência da origem e destino devem ser diferentes!");

		if (this.getMotorista().isEmpty() || !this.getMotorista().get().getEhMotorista())
			throw new Exception("Não foi informado um motorista válido!");

		if (!this.getPassageiro().isEmpty()) {
			if (this.getMotorista().get().getEhChefeServico() && this.getPassageiro().get().getEhOficial())
				throw new Exception("Não podem ser transportados juntos chefe e oficial!");

			if (this.getMotorista().get().getEhPiloto() && this.getPassageiro().get().getEhComissaria())
				throw new Exception("Não podem ser transportados juntos piloto e comissária!");

			if (!(this.getMotorista().get().getEhPolicial()) && this.getPassageiro().get().getEhPresidiario())
				throw new Exception("Não pode ser transportado o presidiário sem o policial!");
		}
	}
}