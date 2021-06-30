package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvJobExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CvJobExperience;
@Service
public class CvJobExperienceManager implements CvJobExperienceService {
	
	private CvJobExperienceDao cvJobExperienceDao;

	@Autowired
	public CvJobExperienceManager(CvJobExperienceDao cvJobExperienceDao) {
		super();
		this.cvJobExperienceDao = cvJobExperienceDao;
	}

	@Override
	public Result add(CvJobExperience cvJobExperience) {
		this.cvJobExperienceDao.save(cvJobExperience);
		return new SuccessResult("Job Experience has been added.");  //İş Deneyimi eklendi
	}

	@Override
	public Result update(CvJobExperience cvJobExperience) {
		this.cvJobExperienceDao.save(cvJobExperience);
		return new SuccessResult("Job Experience has been updated.");   //İş Deneyimi güncellendi
	}

	@Override
	public Result delete(int id) {
		this.cvJobExperienceDao.deleteById(id);
		return new SuccessResult("Job Experience has been deleted.");    //İş Deneyimi silindi
	}

	@Override
	public DataResult<CvJobExperience> getById(int id) {
		return new SuccessDataResult<CvJobExperience>(this.cvJobExperienceDao.getById(id));
	}

	@Override
	public DataResult<List<CvJobExperience>> getAll() {
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CvJobExperience>> getAllByCandidateIdOrderByEndDateDesc(int id) {
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.getAllByCandidate_idOrderByEndDateDesc(id));
	}

	@Override
	public DataResult<List<CvJobExperience>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.getAllByCandidate_id(id));
	}

}
