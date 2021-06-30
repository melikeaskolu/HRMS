package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvJobExperience;

public interface CvJobExperienceService {
	Result add(CvJobExperience cvJobExperience);
	Result update(CvJobExperience cvJobExperience);
	Result delete(int id);
	DataResult<CvJobExperience> getById(int id);	
	DataResult<List<CvJobExperience>> getAll();
	DataResult<List<CvJobExperience>> getAllByCandidateIdOrderByEndDateDesc(int id);
	DataResult<List<CvJobExperience>> getAllByCandidateId(int id);

}
