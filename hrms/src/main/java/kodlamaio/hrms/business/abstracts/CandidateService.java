package kodlamaio.hrms.business.abstracts;
import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	DataResult<List<Candidate>> findByNationalityIdentity(String nationalityIdentity);
	DataResult<List<Candidate>> fİndByEmail(String email);
	DataResult<Boolean> ValidateByPersonalInfo(String nationalityIdentity, String first_name, String last_name, String birth_date);
	
	

}
