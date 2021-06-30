package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvProgrammingSkillService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvProgrammingSkillDao;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkill;
@Service
public class CvProgrammingSkillManager implements CvProgrammingSkillService {
	
	private CvProgrammingSkillDao cvProgrammingSkillDao;

	@Autowired
	public CvProgrammingSkillManager(CvProgrammingSkillDao cvProgrammingSkillDao) {
		super();
		this.cvProgrammingSkillDao = cvProgrammingSkillDao;
	}

	@Override
	public Result add(CvProgrammingSkill cvProgrammingSkill) {
		this.cvProgrammingSkillDao.save(cvProgrammingSkill);
		return new SuccessResult("Programming skill has been added.");
	}

	@Override
	public Result update(CvProgrammingSkill cvProgrammingSkill) {
		this.cvProgrammingSkillDao.save(cvProgrammingSkill);
		return new SuccessResult("Programming skill has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.cvProgrammingSkillDao.deleteById(id);
		return new SuccessResult("Programming skill has been deleted.");
	}

	@Override
	public DataResult<CvProgrammingSkill> getById(int id) {
		return new SuccessDataResult<CvProgrammingSkill>(this.cvProgrammingSkillDao.getById(id));

	}

	@Override
	public DataResult<List<CvProgrammingSkill>> getAll() {
		return new SuccessDataResult<List<CvProgrammingSkill>>(this.cvProgrammingSkillDao.findAll());

	}

	@Override
	public DataResult<List<CvProgrammingSkill>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvProgrammingSkill>>(this.cvProgrammingSkillDao.getAllByCandidate_id(id));

	}

}
