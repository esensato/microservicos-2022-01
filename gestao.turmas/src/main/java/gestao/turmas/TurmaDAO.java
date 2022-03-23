package gestao.turmas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaDAO extends CrudRepository<Turma, Integer>{
	
	Turma findByNome(String nome);

}
