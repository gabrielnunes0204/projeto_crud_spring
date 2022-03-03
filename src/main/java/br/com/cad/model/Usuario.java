package br.com.cad.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "usuario", allocationSize = 1, sequenceName = "sq_usuario")
public class Usuario {

	@Id
	@GeneratedValue(generator = "usuario", strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name = "nr_idade")
	private Integer idade;
	
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_senha")
	private String senha;
	
	public Usuario() {}
	
	public Usuario(String nome, Integer idade, String email, String senha) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
