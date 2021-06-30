package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {
	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if (!CheckIfNullField(jobPosting)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields."); // Eksik bilgi girdiniz. Lütfen bütün boşlukları doldurun..
																						
		}
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job posting has been added."); // İş ilanı eklendi.
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job posting has been updated."); // iş ilanı güncellendi
	}

	@Override
	public Result delete(int id) {
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("Job posting has been deleted."); // iş ilanı silindi
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getById(id));
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());

	}

	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job posting");  //Böyle bir iş ilanı yok

		}
		if (getById(id).getData().isActive() == false) {
			return new ErrorResult("There job posting is already closed.");  //Orada iş ilanı zaten kapalı
		}

		JobPosting jobPosting = getById(id).getData();
		jobPosting.setActive(false);
		update(jobPosting);
		return new SuccessResult("Job posting has been successfully closed.");  //İş ilanı başarıyla kapatıldı.
	}

	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPostingList() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPostingList());
	}

	@Override
	public DataResult<List<JobPosting>> findAllByOrderByReleaseDate() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByOrderByReleaseDate());
	}

	@Override
	public DataResult<List<JobPosting>> getAllByOpenJobPostingByEmployer(int id) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByOpenJobPostingByEmployer(id));

	}
	private boolean CheckIfNullField(JobPosting jobPosting) {
		if (jobPosting.getJobPosition() != null && jobPosting.getJobDescription() != null && jobPosting.getCity() != null
				&& jobPosting.getOpenPositionCount() != 0) {
			return true;
		}
		return false;
	}

}
