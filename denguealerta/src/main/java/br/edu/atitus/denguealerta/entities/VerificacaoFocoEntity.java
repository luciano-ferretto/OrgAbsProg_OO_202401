package br.edu.atitus.denguealerta.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "verificacao_foco")
public class VerificacaoFocoEntity extends GenericEntity {
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "idfoco")
	private FocoEntity foco;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "idusuario")
	private UsuarioEntity usuario;
	
	private LocalDate data;
	
	@Column(length = 500, nullable = false)
	private String observacao;

	public FocoEntity getFoco() {
		return foco;
	}

	public void setFoco(FocoEntity foco) {
		this.foco = foco;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
	

}
