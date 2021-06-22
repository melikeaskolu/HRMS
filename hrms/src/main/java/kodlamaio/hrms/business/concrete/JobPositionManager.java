package kodlamaio.hrms.business.concrete;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobTitleDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobPosition jobTitle) {
		if(getByJobTitle(jobTitle.getTitle()).getData()!=null) {
			return new ErrorResult( jobTitle.getTitle()+"job title could not be added");  //iş unvanı eklenemedi
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessDataResult<List<JobPosition>>("Job Title has been added.");  //İş unvanı eklendi.
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobTitleDao.findAll());
	}

	@Override
	public DataResult<List<JobPosition>> getByJobTitle(String title) {
		return new SuccessDataResult<List<JobPosition>>(this.jobTitleDao.findByTitle(title));
	}

}
