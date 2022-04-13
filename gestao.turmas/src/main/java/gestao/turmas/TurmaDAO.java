package gestao.turmas;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaDAO extends ReactiveCrudRepository<Turma, Integer>{
	
	Turma findByNome(String nome);

}
