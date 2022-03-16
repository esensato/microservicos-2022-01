package gestao.turmas;

import org.springframework.data.repository.CrudRepository;

public interface TurmaDAO extends CrudRepository<Turma, Integer>{
	
	Turma findByNome(String nome);

}
