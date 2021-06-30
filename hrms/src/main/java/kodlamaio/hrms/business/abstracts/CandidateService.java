package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {

	Result add(Candidate candidate);

	Result update(Candidate candidate);

	Result delete(int id);

	DataResult<Candidate> getById(int id);

	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getCandidateByIdentityNumber(String identityNumber);

	DataResult<CandidateCvDto> getCandidateCvById(int id);

}
