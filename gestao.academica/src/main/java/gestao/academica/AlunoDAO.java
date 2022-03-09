package gestao.academica;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDAO extends CrudRepository<AlunoBean, Integer> {
	
	Iterable<AlunoBean> findByTurma(String turma);
	
	@Query("select a from TAB_ALUNO a where a.turma = ?1 and a.curso = ?2")
	Iterable<AlunoBean> obterTurmaCurso(String turma, String curso);

}
