package kodlamaio.hrms.business.concrete;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(getByJobTitle(jobTitle.getTitle()).getData()!=null) {
			return new ErrorResult( jobTitle.getTitle()+"job title could not be added");  //iş unvanı eklenemedi
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessDataResult<List<JobTitle>>("Job Title has been added.");  //İş unvanı eklendi.
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public DataResult<List<JobTitle>> getByJobTitle(String title) {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findByTitle(title));
	}

}
