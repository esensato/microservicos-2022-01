package gestao.academica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "TAB_ALUNO")
public class AlunoBean {
	
	@Column(name = "ID_ALUNO")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	@NotNull (message = "Informe o curso para o novo aluno")
	private String curso;
	
	@JsonIgnore
	@Transient
	private String senha;
	
	private String turma;

	public AlunoBean() {
		super();
	}
	
	public AlunoBean(int id, String nome, String curso, String turma) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.turma = turma;
	}
	
	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
