package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	List<Candidate> findByNationalityIdentity (String nationalityIdentity);
	List<Candidate> findByEmail (String email);

}