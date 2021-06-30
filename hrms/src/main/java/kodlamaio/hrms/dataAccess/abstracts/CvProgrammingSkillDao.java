package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkill;

public interface CvProgrammingSkillDao extends JpaRepository<CvProgrammingSkill, Integer> {
	CvProgrammingSkill getById(int id);
	List<CvProgrammingSkill> getAllByCandidate_id(int id);

}
