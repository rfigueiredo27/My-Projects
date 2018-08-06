package br.cefetrj.eic.psw.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tb_ponto_turistico")
public class PontoTuristico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String cidade;
	private String estado;
		
	public PontoTuristico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PontoTuristico(Long id, String nome, String descricao,
			String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

	

}
