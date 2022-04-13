package gestao.turmas;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Table
public class Turma {
	
	@Id
	private int id;
	
	private String nome;
	
	@Schema(name = "total", description = "Total de alunos", required = true, example = "10")
	private int total;
	
	public Turma() {
		super();
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
