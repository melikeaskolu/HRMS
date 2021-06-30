package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvSchoolService {
	Result add(CvSchool cvSchool);
	Result update(CvSchool cvSchool);
	Result delete(int id);
	DataResult<CvSchool> getById(int id);	
	DataResult<List<CvSchool>> getAll();
	DataResult<List<CvSchool>> getAllByCandidateIdOrderByEndSchoolDesc(int id);
	DataResult<List<CvSchool>> getAllByCandidateId(int id);

}
