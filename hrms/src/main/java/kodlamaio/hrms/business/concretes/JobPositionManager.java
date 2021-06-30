package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(getJobByTitle(jobPosition.getTitle()).getData() != null){
			return new ErrorResult( jobPosition.getTitle() + " job title already exists");  //iş ünvanı zaten var.
		}
		this.jobPositionDao.save(jobPosition);
	    return new SuccessResult("Job position has been added.");  //İş pozisyonu eklendi
	}
//@Override
//	public Result update(JobPosition jobPosition) {
//		this.jobPositionDao.save(jobPosition);
//      return new SuccessResult("Job position has been updated."); //iş pozisyonu güncellendi.
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.jobPositionDao.deleteById(id);
//      return new SuccessResult("Job position has been deleted.");  //iş pozisyonu silindi.
//	}
//
//	@Override
//	public DataResult<JobPosition> getById(int id) {
//		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id));
//	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<List<JobPosition>> getJobByTitle(String title) {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findByTitle(title));
	}

}

