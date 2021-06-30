package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer>{
	CvSchool getById(int id);
	List<CvSchool> getAllByCandidate_idOrderByEndSchoolDesc(int id);
	List<CvSchool> getAllByCandidate_id(int id);

}
