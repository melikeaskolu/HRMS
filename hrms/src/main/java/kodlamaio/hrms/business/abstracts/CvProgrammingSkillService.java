package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkill;

public interface CvProgrammingSkillService {
	Result add(CvProgrammingSkill cvProgrammingSkill);
	Result update(CvProgrammingSkill cvProgrammingSkill);
	Result delete(int id);
	DataResult<CvProgrammingSkill> getById(int id);	
	DataResult<List<CvProgrammingSkill>> getAll();
	DataResult<List<CvProgrammingSkill>> getAllByCandidateId(int id);
	


}
